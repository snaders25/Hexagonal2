package com.codigo.msregistro.infraestructure.adapters;

import com.codigo.msregistro.domain.aggregates.constants.Constants;
import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.PersonaRequest;
import com.codigo.msregistro.domain.ports.out.PersonaServiceOut;
import com.codigo.msregistro.infraestructure.dao.PersonaRepository;
import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import com.codigo.msregistro.infraestructure.entity.TipoDocumentoEntity;
import com.codigo.msregistro.infraestructure.mapper.PersonaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PersonaAdapter implements PersonaServiceOut {

    private final PersonaRepository personaRepository;

    @Override
    public PersonaDTO crearPersonaOut(PersonaRequest personaRequest) {
        PersonaEntity personaEntity = getPersonaCreate(personaRequest);
        return PersonaMapper.fromEntity(personaRepository.save(personaEntity));
    }

    private PersonaEntity getPersonaCreate(PersonaRequest personaRequest) {
        PersonaEntity entity = new PersonaEntity();

        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();

        tipoDocumento.setIdTipoDocumento(Long.valueOf(personaRequest.getTipoDoc()));
        entity.setNumDocu(personaRequest.getNumDocu());
        entity.setNombres(personaRequest.getNombres());
        entity.setApeMat(personaRequest.getApeMat());
        entity.setApePat(personaRequest.getApePat());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.USU_ADMIN);
        entity.setDateCreate(getTimestamp());
        return entity;

    }
    private Timestamp getTimestamp(){
        long currenTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currenTime);
        return timestamp;
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaOut(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PersonaDTO> obtenerTodosOut() {
        return List.of();
    }

    @Override
    public PersonaDTO actualizarPersonaOut(Long id, PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public PersonaDTO deleteOut(Long id) {
        return null;
    }
}

