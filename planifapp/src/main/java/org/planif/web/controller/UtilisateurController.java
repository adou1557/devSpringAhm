package org.planif.web.controller;

import org.planif.dao.entity.Utilisateur;
import org.planif.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    /**
     * Enregistre un nouveau utilisateur.
     *
     * @param utilisateur le utilisateur à enregistrer
     * @return la utilisateur enregistré
     */
    @PostMapping
    public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
    }
    /**
     * Met à jour un utilisateur existant.
     *
     * @param utilisateur le utilisateur à mettre à jour
     * @return le utilisateur mise à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.UpdateUtilisateur(utilisateur);
        return updatedUtilisateur != null ? new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Supprime un utilisateur par son identifiant.
     *
     * @param id l'identifiant de la utilisateur à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateurById(@PathVariable("id") Long id) {
        utilisateurService.DeleteUtilisateurById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllUtilisateur() {
        utilisateurService.DeleteAllUtilisateurs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id l'identifiant du utilisateur à récupérer
     * @return le utilisateur trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur != null ? new ResponseEntity<>(utilisateur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère tout les utilisateurs.
     *
     * @return une liste de tout les utilisateurs
     */
    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }
}
