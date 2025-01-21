package org.planif.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class EvenementNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeNotification;
    private Date dateEnvoi;
    /*
    @ManyToOne
    private Notification notification;
    @ManyToOne
    private Appointment appointment;*/
}
