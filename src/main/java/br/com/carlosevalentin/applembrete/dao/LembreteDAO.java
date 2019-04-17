package br.com.carlosevalentin.applembrete.dao;

import br.com.carlosevalentin.applembrete.entidades.Lembrete;

import java.util.List;

public class LembreteDAO extends GenericoDAO<Lembrete> {

    @Override
    public void salvar(Lembrete tClass) throws Exception {
        super.salvar(tClass);
    }

    @Override
    public void deletar(Class<Lembrete> lembreteClass, long id) throws Exception {
        super.deletar(lembreteClass, id);
    }

    @Override
    public void atualizar(Lembrete tClass) throws Exception {
        super.atualizar(tClass);
    }

    @Override
    public Lembrete findById(Class<Lembrete> lembreteClass, long id) throws Exception {
        return super.findById(lembreteClass, id);
    }

    @Override
    public List<Lembrete> findAll(Class<Lembrete> lembreteClass) throws Exception {
        return super.findAll(lembreteClass);
    }
}
