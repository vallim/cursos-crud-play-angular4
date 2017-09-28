package br.com.cursos.controller;

import br.com.cursos.model.Categoria;
import play.cache.Cached;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoriaController extends Controller {

    @Cached(key = "categorias")
    public Result listarCategorias() {
        return ok(Json.toJson(Categoria.values()));
    }
}