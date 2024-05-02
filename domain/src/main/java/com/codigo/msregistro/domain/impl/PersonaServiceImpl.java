package com.codigo.msregistro.domain.impl;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.PersonaRequest;
import com.codigo.msregistro.domain.ports.in.PersonaServiceIn;
import com.codigo.msregistro.domain.ports.out.PersonaServiceOut;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor

public class PersonaServiceImpl implements PersonaServiceIn {

    private final PersonaServiceOut personaServiceOut;


    @Override
    public PersonaDTO crearPersonaIn(PersonaRequest personaRequest) {
        return personaServiceOut.crearPersonaOut(personaRequest);
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaIn(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PersonaDTO> obtenerTodosIn() {
        return List.of();
    }

    @Override
    public PersonaDTO actualizarPersonaIn(Long id, PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public PersonaDTO deleteIn(Long id) {
        return null;
    }
}
