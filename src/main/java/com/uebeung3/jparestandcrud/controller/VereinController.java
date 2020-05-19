package com.uebeung3.jparestandcrud.controller;

import com.uebeung3.jparestandcrud.model.Verein;
import com.uebeung3.jparestandcrud.repository.VereinRepository;
import com.uebeung3.jparestandcrud.exception.mitgliedNotFoundException;
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
    public ResponseEntity<Verein> getMitgliedById(@PathVariable(value = "id") Long mitgliedId)
            throws mitgliedNotFoundException{
        Verein mitglied = vereinRepository.findById(mitgliedId)
                .orElseThrow(() -> new mitgliedNotFoundException("Mitglied mit folgendem ID nicht gefunden: " + mitgliedId));
        return ResponseEntity.ok().body(mitglied);
    }


    //update
    @PostMapping("/mitglieder/{id}")
    public ResponseEntity<Verein> updateMitglied(@PathVariable(value = "id") Long mitgliedId, @RequestBody Verein mitgliedDetails)
            throws mitgliedNotFoundException{
        Verein mitglied = vereinRepository.findById(mitgliedId)
                .orElseThrow(() -> new mitgliedNotFoundException("Mitglied mit folgendem ID nicht gefunden: " + mitgliedId));


        mitglied.setFirstName(mitgliedDetails.getFirstName());
        mitglied.setLastName(mitgliedDetails.getLastName());
        mitglied.setBackNumber(mitgliedDetails.getBackNumber());
        vereinRepository.save(mitglied);
        return ResponseEntity.ok().body(mitglied);

    }



    //delete
    @DeleteMapping("/mitglieder/{id}")
    public ResponseEntity<Verein> deleteMitglied(@PathVariable(value = "id") Long mitgliedId)
            throws mitgliedNotFoundException{
             vereinRepository.findById(mitgliedId)
                .orElseThrow(() -> new mitgliedNotFoundException("Mitglied mit folgendem ID nicht gefunden: " + mitgliedId));

             vereinRepository.deleteById(mitgliedId);
             return ResponseEntity.ok().build();
    }


}
