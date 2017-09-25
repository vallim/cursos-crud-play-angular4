package br.com.cursos.repository;

import br.com.cursos.model.Curso;
import com.google.inject.ImplementedBy;

import java.util.List;

@ImplementedBy(CursoRepository.class)
public interface ICursoRepository {

    List<Curso> findAll();

    Curso save(Curso curso);

    Curso findById(Long id);

    Curso update(Curso curso);
}
