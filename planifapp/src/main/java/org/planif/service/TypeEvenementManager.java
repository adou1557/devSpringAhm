package org.planif.service;

import org.planif.dao.entity.TypeEvenement;
import org.planif.dao.repository.TypeEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeEvenementManager implements TypeEvenementService{
    @Autowired
    private TypeEvenementRepository typeEvenementRepository;

    @Override
    public TypeEvenement saveTypeEvenement(TypeEvenement typeEvenement) {
        return typeEvenementRepository.save(typeEvenement);
    }

    @Override
    public TypeEvenement getTypeEvenementById(Long id) {
        Optional<TypeEvenement> typeEvenement = typeEvenementRepository.findById(id);
        return typeEvenement.orElse(null);
    }

    @Override
    public TypeEvenement updateTypeEvenement(TypeEvenement typeEvenement) {
        return typeEvenementRepository.save(typeEvenement);
    }

    @Override
    public List<TypeEvenement> getAllTypeEvenements() {
        return typeEvenementRepository.findAll();
    }

    @Override
    public void deleteAllTypeEvenement() {
        typeEvenementRepository.deleteAll();
    }

    @Override
    public void deleteTypeEvenement(Long id) {
        typeEvenementRepository.deleteById(id);
    }
}
