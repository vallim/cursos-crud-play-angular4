package br.com.cursos.service;

import br.com.cursos.model.Curso;
import br.com.cursos.model.CursoNotFoundException;
import br.com.cursos.repository.ICursoRepository;
import org.springframework.beans.BeanUtils;

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
    public Curso update(Long id, Curso curso) {
        Curso cursoExistente = findById(id);

        if (cursoExistente == null) {
            throw new CursoNotFoundException();
        }
        BeanUtils.copyProperties(curso, cursoExistente);

        return cursoRepository.update(curso);
    }

    @Override
    public void delete(Long id) {
        cursoRepository.delete(id);
    }
}