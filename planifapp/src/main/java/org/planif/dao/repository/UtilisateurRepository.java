package org.planif.dao.repository;

import org.planif.dao.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long > {
    public Utilisateur findByNom(String nom);
}
