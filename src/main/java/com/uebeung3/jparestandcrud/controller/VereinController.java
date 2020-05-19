package com.uebeung3.jparestandcrud.controller;

import com.uebeung3.jparestandcrud.repository.VereinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("verein")
public class VereinController {

    @Autowired
    private VereinRepository vereinRepository;
    
}
