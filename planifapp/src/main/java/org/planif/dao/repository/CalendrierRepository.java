package org.planif.dao.repository;

import org.planif.dao.entity.Calendrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierRepository extends JpaRepository< Calendrier,Long> {
    Calendrier findById(long id);
}
