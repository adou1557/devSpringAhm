package org.planif.service;

import org.planif.dao.entity.Utilisateur;
import org.planif.dao.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurManager implements UtilisateurService{

    @Autowired
    public UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
       return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findByName(String name) {
        return utilisateurRepository.findByNom(name);
    }



    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
        Utilisateur user=utilisateurRepository.findByNom(utilisateur.getNom());
        utilisateurRepository.save(user);
        return null;
    }

    @Override
    public void DeleteUtilisateurById(Long Id) {
        utilisateurRepository.deleteById(Id);
    }

    @Override
    public void DeleteAllUtilisateurs() {
        utilisateurRepository.deleteAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Long Id) {
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(Id);
        return utilisateur.orElse(null);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
