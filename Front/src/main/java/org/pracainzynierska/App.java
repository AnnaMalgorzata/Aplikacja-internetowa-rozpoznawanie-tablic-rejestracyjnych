package org.pracainzynierska;
import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    static {
        //System.load("C:\\Users\\annam\\opencv\\build\\java\\x64\\opencv_java455.dll");
    }
    public static void main(String[] args) {

        nu.pattern.OpenCV.loadLocally();
        SpringApplication.run(App.class, args);
    }
}
