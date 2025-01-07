package org.planif.service;


import org.planif.dao.entity.EvenementNotification;

import java.util.List;

public interface EvenementNotificationService {
    EvenementNotification saveEvenementNotification(EvenementNotification evenementNotification);

    EvenementNotification getEvenementNotificationById(Long id);
    public EvenementNotification updateEvenementNotification(EvenementNotification evenementNotification);
    List<EvenementNotification> getAllEvenementNotifications();

    void deleteAllEvenementNotification();
    void deleteEvenementNotification(Long id);
}
