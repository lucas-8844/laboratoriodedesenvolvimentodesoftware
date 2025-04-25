package dao;

import jakarta.persistence.*;
import model.Aluno;
import util.JPAUtil;

import java.util.List;

public class AlunoDAO {

    EntityManager em = JPAUtil.getEntityManager();

    public void salvar(Aluno aluno) {
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
    }

    public Aluno buscarPorId(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> listarTodos() {
        return em.createQuery("FROM Aluno", Aluno.class).getResultList();
    }

    public void atualizar(Aluno aluno) {
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
    }

    public void deletar(Long id) {
        Aluno aluno = buscarPorId(id);
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
    }
}