package org.example.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String HelloController(@RequestParam(name ="name", required = false, defaultValue = "Vasya")
                                  String name, Model model) {
        model.addAttribute("name", name);

        return "hello";
    }
}
