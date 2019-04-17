package br.com.carlosevalentin.applembrete.dao;

import br.com.carlosevalentin.applembrete.entidades.EntidadeBase;

import java.util.List;

public interface IGenericoDAO<T extends EntidadeBase> {
    public void salvar(T tClass) throws Exception;
    public void atualizar(T tClass) throws Exception;
    public void deletar(Class<T> tClass, long id) throws Exception;
    public List<T> findAll(Class<T> tClass) throws Exception;
    public T findById(Class<T> tClass, long id) throws Exception;
}
