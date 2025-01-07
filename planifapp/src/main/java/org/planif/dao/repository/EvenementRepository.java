package org.planif.dao.repository;

import org.planif.dao.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Appointment,Long> {
}
