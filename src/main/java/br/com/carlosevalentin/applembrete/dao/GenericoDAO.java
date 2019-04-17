package br.com.carlosevalentin.applembrete.dao;

import br.com.carlosevalentin.applembrete.entidades.EntidadeBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class GenericoDAO<T extends EntidadeBase> implements IGenericoDAO<T> {

    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("hibernatejpa");
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void salvar(T tClass) throws Exception {
        EntityManager manager = getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(tClass);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new Exception("Erro método salvar: " + tClass.getClass().getSimpleName());
        } finally {
            manager.close();
        }
    }

    @Override
    public void atualizar(T tClass) throws Exception {
        EntityManager manager = getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(tClass);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new Exception("Erro método atualizar: " + tClass.getClass().getSimpleName());
        } finally {
            manager.close();
        }
    }

    @Override
    public void deletar(Class<T> tClass, long id) throws Exception {
        EntityManager manager = getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        T obj = manager.find(tClass, id);
        try {
            transaction.begin();
            manager.remove(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new Exception("Erro método deletar: " + tClass.getClass().getSimpleName());
        } finally {
            manager.close();
        }
    }

    @Override
    public List<T> findAll(Class<T> tClass) throws Exception {
        EntityManager manager = getEntityManager();
        List<T> objList;
        try {
            objList = manager.createQuery("FROM " + tClass.getName()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            manager.close();
        }
        return objList;
    }

    @Override
    public T findById(Class<T> tClass, long id) throws Exception {
        EntityManager manager = getEntityManager();
        T obj;
        try {
            obj = manager.find(tClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        } finally {
            manager.close();
        }
        return obj;
    }
}
