package com.WEB2.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("api/test")
    ResponseEntity<?> getAccountInfo() {
        return ResponseEntity.ok("Sve OK");
    }

}
