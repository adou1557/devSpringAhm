package org.planif.mapper;


import org.modelmapper.ModelMapper;
import org.planif.dao.entity.Appointment;
import org.planif.dto.EvenementDto;



public class EvenementMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public EvenementDto fromEvenementToEvenementDto(Appointment appointment) {
        return modelMapper.map(appointment, EvenementDto.class);
    }
}
