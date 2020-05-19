package com.uebeung3.jparestandcrud.controller;

import com.uebeung3.jparestandcrud.model.Verein;
import com.uebeung3.jparestandcrud.repository.VereinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("verein")
public class VereinController {

    @Autowired
    private VereinRepository vereinRepository;


    //get all
    @GetMapping("/mitglieder")
    public List<Verein> getAllMitglieder(){
        return vereinRepository.findAll();
    }

    //create
    @PostMapping("/mitglieder")
    public Verein createMitglied(@Validated @RequestBody Verein mitglied){
      return vereinRepository.save(mitglied);
    }

    //get by id
    @GetMapping("/mitglieder/{id}")
    public ResponseEntity<Verein> getMitgliedById(@PathVariable(value = "id") Long mitgliedId){

    }


    //update
    @PostMapping("/mitglieder/{id}")
    public ResponseEntity<Verein> updateMitglied(@PathVariable(value = "id") Long mitgliedId, @RequestBody Verein mitglied){

    }



    //delete
    @DeleteMapping("/mitglieder/{id}")
    public ResponseEntity<Verein> deleteMitglied(@PathVariable(value = "id") Long mitgliedId, @RequestBody Verein mitglied){

    }


}
