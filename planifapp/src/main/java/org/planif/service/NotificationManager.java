package org.planif.service;

import org.planif.dao.entity.Calendrier;
import org.planif.dao.entity.Notification;
import org.planif.dao.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationManager implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
     return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long id) {
        Optional<Notification> notification= notificationRepository.findById(id);
        return notification.orElse(null);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

    @Override
    public void deleteAllNotification() {
        notificationRepository.deleteAll();
    }

    @Override
    public void deleteNotification(Long id) {

        notificationRepository.deleteById(id);
    }
}
