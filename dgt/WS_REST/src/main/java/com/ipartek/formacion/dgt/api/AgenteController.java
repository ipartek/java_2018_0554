package com.ipartek.formacion.dgt.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin // aceptamos peticiones de javascript de otros origenes
@RestController
@Api(tags = { "AGENTE" }, produces = "application/json", description="Gestión de agentes")
public class AgenteController {

}
