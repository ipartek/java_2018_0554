package com.ipartek.formacion.dgt.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin // aceptamos peticiones de javascript de otros origenes
@RestController
@Api(tags = { "MULTA" }, produces = "application/json", description="Gestión de multas")
public class MultaController {

}
