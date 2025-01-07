package org.planif.service;


import org.planif.dao.entity.Calendrier;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CalendrierService {
    Calendrier saveCalendrier(Calendrier calendrier);

    Calendrier getCalendrierById(Long id);
    public Calendrier updateCalendrier(Calendrier calendrier);
    List<Calendrier> getAllCalendriers();

    void deleteAllCalendrier();
    void deleteCalendrier(Long id);
}
