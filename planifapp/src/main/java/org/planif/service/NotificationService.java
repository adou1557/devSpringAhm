package org.planif.service;


import org.planif.dao.entity.Notification;
import org.planif.dao.entity.Notification;
import org.planif.dao.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification saveNotification(Notification notification);

    Notification getNotificationById(Long id);
    public Notification updateNotification(Notification notification);
    List<Notification> getAllNotifications();
    void deleteAllNotification();
    void deleteNotification(Long id);
}
