package org.planif.dao.repository;

import org.planif.dao.entity.EvenementNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementNotificationRepository extends JpaRepository<EvenementNotification,Long> {
}
