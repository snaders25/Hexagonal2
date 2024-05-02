package com.codigo.msregistro.domain.aggregates.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequest {

    private String numDocu;

    private String nombres;

    private String apePat;

    private String apeMat;

    private  Integer tipoDoc;

}
