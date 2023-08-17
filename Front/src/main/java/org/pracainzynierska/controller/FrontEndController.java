package org.pracainzynierska.controller;

import org.pracainzynierska.component.WSClient;
import org.pracainzynierska.model.DatabaseQuery;
import org.pracainzynierska.model.entity.Photo;
import org.pracainzynierska.model.entity.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FrontEndController {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping("/")
    public String home(Model model, HttpSession session, Authentication authentication) {

        System.out.println("userId: " + session.getAttribute("userId"));


        if(authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            int userId = wsClient.findUserByUsername(username).getId();
            session.setAttribute("userId", userId);
            if(wsClient.checkIfUserAdmin(username)) {
                session.setAttribute("admin", true);
            }
        }

        return "home";
    }

    @GetMapping("/database")
    public String database(Model model) {

        model.addAttribute("datas", wsClient.getDataBase());
        return "database";
    }

    @GetMapping("/history")
    public String history(Model model) {
        List<Photo> photoList = photoRepository.findAll();
        model.addAttribute("photos", photoList);

        return "history";
    }

}
