package org.pracainzynierska.component;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static marvin.MarvinPluginCollection.findTextRegions;

@Component
public class Algorytm {
    public static String PATH = "src/main/resources/images/cars/";
    public static String IMAGE_NAME = "car";

    public String algorytm(byte[] photo) throws TesseractException, IOException {

        OpenCV.loadShared();

        //in the case of color images, the decoded images will have the channels stored in BGR order
        //flag == 1 -> IMREAD_COLOR - if set, always convert image to the 3 channel BGR color image
        Mat image = Imgcodecs.imdecode(new MatOfByte(photo), 1);
        Imgcodecs.imwrite(PATH + IMAGE_NAME + ".png", image);

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\annam\\Desktop\\tessdata\\tessdata"); //set directory to trained models

        Imgcodecs imageCodecs = new Imgcodecs();

        int size = createSegments();

        String finalTable = "";
        for (int i = 0; i < size; i++) {
            Mat img = imageCodecs.imread(PATH + IMAGE_NAME + "_" + i + ".png");
            Mat imgGray = imageCodecs.imread(PATH + "img-gs.png");

            Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2BGR);
            Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);
            Imgcodecs.imwrite(PATH + "Gray " + i + ".png", imgGray);

            String table = tesseract.doOCR(new File(PATH + "Gray " + i + ".png")); //call tesseract function, processing file with OCR technique

            System.out.println(table);

            char[] tableToChars = table.toCharArray();
            StringBuilder plateWithOnlyDigitsAndLetters = new StringBuilder("");
            for (char c : tableToChars) {
                if (Character.isLetterOrDigit(c)) {
                    plateWithOnlyDigitsAndLetters.append(c);
                }
            }
            if (plateWithOnlyDigitsAndLetters.length() >= finalTable.length()) {
                finalTable = plateWithOnlyDigitsAndLetters.toString();
            }
        }

        System.out.println("NR TABLICY REJESTRACYJNEJ: " + Objects.requireNonNull(finalTable));

        if (Objects.equals(finalTable, "")) {
            return "brak";
        }
        return finalTable;
    }

    public static int createSegments() throws IOException {
        MarvinImage image = MarvinImageIO.loadImage("src/main/resources/images/cars/" + IMAGE_NAME + ".png");

        List<MarvinSegment> marvinSegments = findTextRegions(image, 30, 20, 100, 170);

        int size = 0;
        for (MarvinSegment s : marvinSegments) {
            if (s.height > 10) {
                String path = "src/main/resources/images/cars/" + IMAGE_NAME + ".png";


                if (s.y1 > 20) {
                    s.y1 -= 20;
                } else {
                    s.y1 = 0;
                }

                if (s.y2 + 20 <= image.getHeight()) {
                    s.y2 += 20;
                } else {
                    s.y2 = image.getHeight();
                }

                BufferedImage imageT = ImageIO.read(new File(path));

                BufferedImage out = imageT.getSubimage(s.x1, s.y1, s.x2 - s.x1, s.y2 - s.y1);
                String path2 = "src/main/resources/images/cars/" + IMAGE_NAME + "_";

                ImageIO.write(out, "png", new File(path2 + size + ".png"));
                System.out.println(path2 + size + ".png     height: " + s.height);
                size++;

            }
        }

        return size;
    }
}
