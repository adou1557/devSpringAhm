package org.planif.service;


import org.planif.dao.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur addUtilisateur(Utilisateur utilisateur);
    Utilisateur findByName(String name);
    Utilisateur UpdateUtilisateur(Utilisateur utilisateur);
    void DeleteUtilisateurById(Long Id);
    void DeleteAllUtilisateurs();
    Utilisateur getUtilisateurById(Long Id);
    List<Utilisateur> getAllUtilisateurs();

}
