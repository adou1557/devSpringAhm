package org.planif.web.controller;

import org.planif.dao.entity.Notification;
import org.planif.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    /**
     * Enregistre une nouvella notification.
     *
     * @param notification la notification à enregistrer
     * @return la notification enregistrée
     */
    @PostMapping
    public ResponseEntity<Notification> saveNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
    }
    /**
     * Met à jour une notification existant.
     *
     * @param notification la notification à mettre à jour
     * @return la notification mise à jour ou une réponse 404 si non trouvé
     */
    @PutMapping
    public ResponseEntity<Notification> updateNotification(@RequestBody Notification notification) {
        Notification updatedNotification = notificationService.updateNotification(notification);
        return updatedNotification != null ? new ResponseEntity<>(updatedNotification, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Supprime une notification par son identifiant.
     *
     * @param id l'identifiant de la notification à supprimer
     * @return une réponse 204 si l'opération est réussie
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificationById(@PathVariable("id") Long id) {
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllNotification() {
        notificationService.deleteAllNotification();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Récupère une notification par son identifiant.
     *
     * @param id l'identifiant de la notification à récupérer
     * @return la notification trouvé ou une réponse 404 si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable("id") Long id) {
        Notification notification = notificationService.getNotificationById(id);
        return notification != null ? new ResponseEntity<>(notification, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Récupère tout les notifications.
     *
     * @return une liste de tout les notifications
     */
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
