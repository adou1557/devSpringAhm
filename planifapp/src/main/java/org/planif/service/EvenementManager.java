package org.planif.service;

import org.planif.dao.entity.Appointment;
import org.planif.dao.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementManager implements EvenementService{

    @Autowired
    private EvenementRepository evenementRepository;
    @Override
    public Appointment saveEvenement(Appointment appointment) {
        
        return evenementRepository.save(appointment);
    }

    @Override
    public Appointment getEvenementById(Long id) {
        Optional<Appointment> evenement= evenementRepository.findById(id);
        return evenement.orElse(null);
    }

    @Override
    public Appointment updateEvenement(Appointment appointment) {
        return evenementRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public void deleteAllEvenements() {
        evenementRepository.deleteAll();
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
