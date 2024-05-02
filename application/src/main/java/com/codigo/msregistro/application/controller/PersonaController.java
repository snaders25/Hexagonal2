package com.codigo.msregistro.application.controller;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.PersonaRequest;
import com.codigo.msregistro.domain.ports.in.PersonaServiceIn;
import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-registro/v1/persona")
@RequiredArgsConstructor

public class PersonaController {
private final PersonaServiceIn personaServiceIn;

@PostMapping
    public ResponseEntity<PersonaDTO> registrar (@RequestBody PersonaRequest requestPersona){
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(personaServiceIn.crearPersonaIn(requestPersona));

}



}
