package br.com.cursos.controller;

import br.com.cursos.model.Curso;
import br.com.cursos.model.CursoNotFoundException;
import br.com.cursos.service.ICursoService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class CursoController extends Controller {

    @Inject
    private ICursoService cursoService;

    public Result listaCursos() {
        return ok(Json.toJson(cursoService.findAll()));
    }

    public Result novoCurso() {
        Curso curso = Json.fromJson(request().body().asJson(), Curso.class);

        return created(Json.toJson(cursoService.save(curso)));
    }

    public Result atualizaCurso() {
        Curso curso = Json.fromJson(request().body().asJson(), Curso.class);

        try {
            return ok(Json.toJson(cursoService.update(curso)));
        } catch (CursoNotFoundException ex) {
            return notFound("O curso com id: " + curso.getId() + " não foi encontrado");
        }
    }
}