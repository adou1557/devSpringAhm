package org.planif.mapper;

import org.modelmapper.ModelMapper;
import org.planif.dao.entity.Utilisateur;

import org.planif.dto.UtilisateurDtoReq;

public class UtilisateurMapper {

    private final ModelMapper modelMapper = new ModelMapper();
    public UtilisateurDtoReq fromUtilisateurToUtilisateurDto(Utilisateur utilisateur) {
        return modelMapper.map(utilisateur, UtilisateurDtoReq.class);
    }
}
