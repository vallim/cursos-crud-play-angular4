package br.com.cursos.repository;

import br.com.cursos.model.Curso;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.function.Function;

public class CursoRepository implements ICursoRepository {

    @Inject
    private JPAApi jpaApi;

    @Override
    @Transactional
    public List<Curso> findAll() {
        return wrap(this::list);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return wrap(em -> persist(em, curso));
    }

    @Override
    public Curso findById(Long id) {
        try {
            return wrap(em -> findById(em, id));
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }

    @Override
    public Curso update(Curso curso) {
        return wrap(em -> update(em, curso));
    }

    private Curso update(EntityManager em, Curso curso) {
        return em.merge(curso);
    }

    private Curso findById(EntityManager em, Long id) {
        return (Curso) em.createQuery("select c from Curso c where c.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    private Curso persist(EntityManager em, Curso curso) {
        em.persist(curso);

        return curso;
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private List<Curso> list(EntityManager em) {
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
    }
}