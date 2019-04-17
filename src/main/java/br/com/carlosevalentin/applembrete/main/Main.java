package br.com.carlosevalentin.applembrete.main;

import br.com.carlosevalentin.applembrete.dao.LembreteDAO;
import br.com.carlosevalentin.applembrete.entidades.Lembrete;
import br.com.carlosevalentin.applembrete.entidades.Pessoa;
import br.com.carlosevalentin.applembrete.dao.PessoaDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {

        Lembrete lembrete = new Lembrete();
        lembrete.setTitulo("Codificar");
        lembrete.setDescricao("Todos os dias, 10:00");
//
//        List<Lembrete> lembretes = new ArrayList();
//        lembretes.add(lembrete);

//        PessoaDAO pessoaDAO = new PessoaDAO();

        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Valentin");
//        pessoa.setLembretes(lembretes);
        pessoa.setId(1);

        lembrete.setPessoa(pessoa);

        LembreteDAO lembreteDAO = new LembreteDAO();

        lembreteDAO.salvar(lembrete);


        lembrete.setPessoa(pessoa);

//        pessoaDAO.salvar(pessoa);
    }
}
