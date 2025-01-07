package org.planif.service;

import org.planif.dao.entity.Calendrier;
import org.planif.dao.entity.EvenementNotification;
import org.planif.dao.repository.EvenementNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementNotificationManager implements EvenementNotificationService {

    @Autowired
    private EvenementNotificationRepository repo;
    @Override
    public EvenementNotification saveEvenementNotification(EvenementNotification evenementNotification) {
        return repo.save(evenementNotification);
    }

    @Override
    public EvenementNotification getEvenementNotificationById(Long id) {
        Optional<EvenementNotification> evenementNotification= repo.findById(id);
        return evenementNotification.orElse(null);
    }

    @Override
    public EvenementNotification updateEvenementNotification(EvenementNotification evenementNotification) {
        return repo.save(evenementNotification);
    }

    @Override
    public List<EvenementNotification> getAllEvenementNotifications() {
        return repo.findAll();
    }

    @Override
    public void deleteAllEvenementNotification() {
        repo.deleteAll();
    }

    @Override
    public void deleteEvenementNotification(Long id) {
        repo.deleteById(id);
    }
}
