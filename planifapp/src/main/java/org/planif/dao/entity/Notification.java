package org.planif.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.planif.dao.enumeration.TypeNotification;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private TypeNotification typeNotification;
    private String contenu;
    private String destinataire;
    private String timestamp;
    /*
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EvenementNotification> evenementNotifications;
    */
}
