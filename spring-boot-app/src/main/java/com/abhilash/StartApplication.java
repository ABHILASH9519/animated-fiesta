package com.abhishek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "Spring Boot application");
        model.addAttribute("msg", "Deployed through an automated Kubernetes delivery pipeline.");
        return "index";
    }

    @GetMapping("/healthz")
    @ResponseBody
    public String health() {
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
