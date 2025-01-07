package org.planif.service;

import org.planif.dao.entity.Calendrier;
import org.planif.dao.repository.CalendrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendrierManager implements CalendrierService{

    @Autowired
    private CalendrierRepository calendrierRepository;
    @Override
    public Calendrier saveCalendrier(Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }

    @Override
    public Calendrier getCalendrierById(Long id) {
        Optional<Calendrier>calendrier= calendrierRepository.findById(id);
        return calendrier.orElse(null);
    }

    @Override
    public Calendrier updateCalendrier(Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }

    @Override
    public List<Calendrier> getAllCalendriers() {
        return calendrierRepository.findAll();
    }

    @Override
    public void deleteAllCalendrier() {
        calendrierRepository.deleteAll();
    }

    @Override
    public void deleteCalendrier(Long id) {
        calendrierRepository.deleteById(id);
    }
}
