package org.planif.service;


import org.planif.dao.entity.Appointment;

import java.util.List;

public interface EvenementService {
    Appointment saveEvenement(Appointment appointment);

    Appointment getEvenementById(Long id);
    public Appointment updateEvenement(Appointment appointment);
    List<Appointment> getAllEvenements();
    void deleteAllEvenements();
    void deleteEvenement(Long id);
}
