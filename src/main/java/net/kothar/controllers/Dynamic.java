package net.kothar.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dynamic {

    @GetMapping(value = "/dynamic")
    public ResponseEntity<String> dynamic() {
        return ResponseEntity.ok("Dynamic");
    }
}
