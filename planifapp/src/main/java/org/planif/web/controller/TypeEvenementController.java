package org.planif.web.controller;

import org.planif.dao.entity.TypeEvenement;
import org.planif.service.TypeEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeEvenements")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class TypeEvenementController {
    @Autowired
    private TypeEvenementService typeEvenementService;
    
   
    @PostMapping
    public ResponseEntity<TypeEvenement> saveTypeEvenement(@RequestBody TypeEvenement typeEvenement) {
        TypeEvenement savedTypeEvenement = typeEvenementService.saveTypeEvenement(typeEvenement);
        return new ResponseEntity<>(savedTypeEvenement, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<TypeEvenement> updateTypeEvenement(@RequestBody TypeEvenement typeEvenement) {
        TypeEvenement updatedTypeEvenement = typeEvenementService.updateTypeEvenement(typeEvenement);
        return updatedTypeEvenement != null ? new ResponseEntity<>(updatedTypeEvenement, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeEvenementById(@PathVariable("id") Long id) {
        typeEvenementService.deleteTypeEvenement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTypeEvenement() {
        typeEvenementService.deleteAllTypeEvenement();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TypeEvenement> getTypeEvenementById(@PathVariable("id") Long id) {
        TypeEvenement typeEvenement = typeEvenementService.getTypeEvenementById(id);
        return typeEvenement != null ? new ResponseEntity<>(typeEvenement, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public ResponseEntity<List<TypeEvenement>> getAllTypeEvenements() {
        List<TypeEvenement> typeEvenements = typeEvenementService.getAllTypeEvenements();
        return new ResponseEntity<>(typeEvenements, HttpStatus.OK);
    }
}
