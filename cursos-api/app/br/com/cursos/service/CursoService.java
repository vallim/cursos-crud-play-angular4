package br.com.cursos.service;

import br.com.cursos.model.Curso;
import br.com.cursos.model.CursoNotFoundException;
import br.com.cursos.repository.ICursoRepository;

import javax.inject.Inject;
import java.util.List;

public class CursoService implements ICursoService {

    @Inject
    private ICursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso update(Curso curso) {
        Curso cursoToUpdate = findById(curso.getId());

        if (cursoToUpdate == null) {
            throw new CursoNotFoundException();
        }

        return cursoRepository.update(curso);
    }
}