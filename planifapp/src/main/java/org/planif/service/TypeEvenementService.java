package org.planif.service;


import org.planif.dao.entity.Calendrier;
import org.planif.dao.entity.TypeEvenement;
import org.planif.dao.entity.TypeEvenement;

import java.util.List;

public interface TypeEvenementService {
    TypeEvenement saveTypeEvenement(TypeEvenement typeEvenement);

    TypeEvenement getTypeEvenementById(Long id);
    public TypeEvenement updateTypeEvenement(TypeEvenement typeEvenement);

    List<TypeEvenement> getAllTypeEvenements();
    void deleteAllTypeEvenement();
    void deleteTypeEvenement(Long id);
}
