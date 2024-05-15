package net.imbd.app.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieTitleController {

    @GetMapping("/movie-title")
    public String movieTitle(){
        return "The Shawshank Redemption";
    }
}
