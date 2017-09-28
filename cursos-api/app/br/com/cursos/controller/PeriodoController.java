package br.com.cursos.controller;

import br.com.cursos.model.Periodo;
import play.cache.Cached;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class PeriodoController {

    @Cached(key = "periodos")
    public Result listarPeriodos() {
        return ok(Json.toJson(Periodo.values()));
    }
}