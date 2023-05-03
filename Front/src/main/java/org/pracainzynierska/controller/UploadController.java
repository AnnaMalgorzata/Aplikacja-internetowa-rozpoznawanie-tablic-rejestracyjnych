package org.pracainzynierska.controller;

import net.sourceforge.tess4j.TesseractException;
import org.pracainzynierska.component.Algorytm;
import org.pracainzynierska.component.WSClient;
import org.pracainzynierska.model.QueryInfo;
import org.pracainzynierska.model.entity.Photo;
import org.pracainzynierska.model.entity.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private WSClient wsClient;

    @Autowired
    private Algorytm algorytm;

    @GetMapping("/uploadimage")
    public String displayUploadForm(Model model) {
        return "imageupload";
    }

    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file, HttpSession session) throws IOException, TesseractException {

        byte[] fileByteArray = file.getBytes();

        String licensePlate = algorytm.algorytm(fileByteArray);

        QueryInfo queryInfo = wsClient.getCarByLicensePlate(licensePlate);

        Photo photo = new Photo();
        //photo.setFile(fileByteArray);
        photo.setFileName(file.getOriginalFilename());
        photo.setFileSize(file.getSize());
        photo.setLicensePlate(licensePlate);

        photoRepository.saveAndFlush(photo);

        if(queryInfo == null) {
            model.addAttribute("message", "Nie znaleziono abonamentu.");
            return "imageupload";
        }

        if (queryInfo.getAbonament() == null) {
            model.addAttribute("message", "Nie znaleziono abonamentu.");

        } else {
            model.addAttribute("message", "Samochód z rejestracją " + licensePlate + " posiada abonament.");
            model.addAttribute("abonaments", queryInfo.getAbonament()); //przekazujemy stronie informacje, które udało się poobrać z web serwisu
        }

        if (queryInfo.getCar() != null) {
            model.addAttribute("cars", queryInfo.getCar());
        }

        if (queryInfo.getPayment() != null) {
            model.addAttribute("payments", queryInfo.getPayment());
        }

        if (queryInfo.getSchedule() != null) {
            model.addAttribute("schedules", queryInfo.getSchedule());
        }

        if (queryInfo.getUser() != null) {
            model.addAttribute("users", queryInfo.getUser());
        }

        return "imageupload";
    }
}