package org.planif.web.controller;

import org.planif.dao.entity.Appointment;
import org.planif.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EvenementController {
    @Autowired
    private EvenementService evenementService;
    /**
     * Enregistre un nouvel evenement .
     *
     * @param appointment l'evenement à enregistrer
     * @return l'evenement enregistré
     */
    @PostMapping
    public ResponseEntity<Appointment> saveEvenement(@RequestBody Appointment appointment) {
        Appointment savedAppointment = evenementService.saveEvenement(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }
    /**
     * Met à jour un evenement existant.
     *
     * @param appointment le evenement à mettre à jour
     * @return l' evenement mise à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Appointment> updateEvenement(@RequestBody Appointment appointment) {
        Appointment updatedAppointment = evenementService.updateEvenement(appointment);
        return updatedAppointment != null ? new ResponseEntity<>(updatedAppointment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Supprime un evenement par son identifiant.
     *
     * @param id l'identifiant de l'evenement à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenementById(@PathVariable("id") Long id) {
        evenementService.deleteEvenement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEvenement() {
        evenementService.deleteAllEvenements();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un evenement par son identifiant.
     *
     * @param id l'identifiant de l' evenement à récupérer
     * @return l' evenement trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getEvenementById(@PathVariable("id") Long id) {
        Appointment appointment = evenementService.getEvenementById(id);
        return appointment != null ? new ResponseEntity<>(appointment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère toutes les evenements.
     *
     * @return une liste de tout les evenements
     */
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllEvenements() {
        List<Appointment> appointments = evenementService.getAllEvenements();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
