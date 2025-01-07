package org.planif.dao.repository;

import org.planif.dao.entity.TypeEvenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEvenementRepository extends JpaRepository<TypeEvenement,Long> {
}
