package org.planif.web.controller;

import org.planif.dao.entity.EvenementNotification;
import org.planif.service.EvenementNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/evenementNotification")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class EvenementNotificationController {
    @Autowired
    EvenementNotificationService evenementNotificationService;
    
    
    @PostMapping
    public ResponseEntity<EvenementNotification> saveEvenementNotification(@RequestBody EvenementNotification evenementNotification) {
        EvenementNotification savedEvenementNotification = evenementNotificationService.saveEvenementNotification(evenementNotification);
        return new ResponseEntity<>(savedEvenementNotification, HttpStatus.CREATED);
    }
    
    
    @PutMapping
    public ResponseEntity<EvenementNotification> updateEvenementNotification(@RequestBody EvenementNotification evenementNotification) {
        EvenementNotification updatedEvenementNotification = evenementNotificationService.updateEvenementNotification(evenementNotification);
        return updatedEvenementNotification != null ? new ResponseEntity<>(updatedEvenementNotification, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenementNotificationById(@PathVariable("id") Long id) {
        evenementNotificationService.deleteEvenementNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEvenementNotification() {
        evenementNotificationService.deleteAllEvenementNotification();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EvenementNotification> getEvenementNotificationById(@PathVariable("id") Long id) {
        EvenementNotification evenementNotification = evenementNotificationService.getEvenementNotificationById(id);
        return evenementNotification != null ? new ResponseEntity<>(evenementNotification, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public ResponseEntity<List<EvenementNotification>> getAllEvenementNotifications() {
        List<EvenementNotification> evenementNotifications = evenementNotificationService.getAllEvenementNotifications();
        return new ResponseEntity<>(evenementNotifications, HttpStatus.OK);
    }
}
