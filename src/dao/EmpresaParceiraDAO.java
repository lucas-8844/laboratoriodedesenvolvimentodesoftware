package dao;

import jakarta.persistence.*;
import model.EmpresaParceira;
import util.JPAUtil;

import java.util.List;

public class EmpresaParceiraDAO {

    EntityManager em = JPAUtil.getEntityManager();

    public void salvar(EmpresaParceira empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }

    public EmpresaParceira buscarPorId(Long id) {
        return em.find(EmpresaParceira.class, id);
    }

    public List<EmpresaParceira> listarTodos() {
        return em.createQuery("FROM EmpresaParceira", EmpresaParceira.class).getResultList();
    }

    public void atualizar(EmpresaParceira empresa) {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
    }

    public void deletar(Long id) {
        EmpresaParceira empresa = buscarPorId(id);
        em.getTransaction().begin();
        em.remove(empresa);
        em.getTransaction().commit();
    }
}