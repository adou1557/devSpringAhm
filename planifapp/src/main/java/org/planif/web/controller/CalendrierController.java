package org.planif.web.controller;


import org.planif.dao.entity.Calendrier;
import org.planif.service.CalendrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendriers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class CalendrierController {
    @Autowired
    private CalendrierService calendrierService;
    /**
     * Enregistre un nouveau calendrier.
     *
     * @param calendrier le calendrier à enregistrer
     * @return la calendrier enregistré
     */
    @PostMapping
    public ResponseEntity<Calendrier> saveCalendrier(@RequestBody Calendrier calendrier) {
        Calendrier savedCalendrier = calendrierService.saveCalendrier(calendrier);
        return new ResponseEntity<>(savedCalendrier, HttpStatus.CREATED);
    }
    /**
     * Met à jour un calendrier existant.
     *
     * @param calendrier le calendrier à mettre à jour
     * @return le calendrier mise à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Calendrier> updateCalendrier(@RequestBody Calendrier calendrier) {
        Calendrier updatedCalendrier = calendrierService.updateCalendrier(calendrier);
        return updatedCalendrier != null ? new ResponseEntity<>(updatedCalendrier, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Supprime un calendrier par son identifiant.
     *
     * @param id l'identifiant de la calendrier à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendrierById(@PathVariable("id") Long id) {
        calendrierService.deleteCalendrier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCalendrier() {
        calendrierService.deleteAllCalendrier();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un calendrier par son identifiant.
     *
     * @param id l'identifiant du calendrier à récupérer
     * @return le calendrier trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Calendrier> getCalendrierById(@PathVariable("id") Long id) {
        Calendrier calendrier = calendrierService.getCalendrierById(id);
        return calendrier != null ? new ResponseEntity<>(calendrier, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère tout les calendriers.
     *
     * @return une liste de tout les calendriers
     */
    @GetMapping
    public ResponseEntity<List<Calendrier>> getAllCalendriers() {
        List<Calendrier> calendriers = calendrierService.getAllCalendriers();
        return new ResponseEntity<>(calendriers, HttpStatus.OK);
    }
}

