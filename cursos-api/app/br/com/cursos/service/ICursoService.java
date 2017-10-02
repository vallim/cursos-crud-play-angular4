package br.com.cursos.service;

import br.com.cursos.model.Curso;
import com.google.inject.ImplementedBy;

import java.util.List;

@ImplementedBy(CursoService.class)
public interface ICursoService {

    List<Curso> findAll();

    Curso findById(Long id);

    Curso save(Curso curso);

    Curso update(Long id, Curso curso);

    void delete(Long id);
}
