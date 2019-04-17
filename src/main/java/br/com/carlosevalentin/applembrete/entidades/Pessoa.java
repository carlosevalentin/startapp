package br.com.carlosevalentin.applembrete.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pessoas")
public class Pessoa implements EntidadeBase {

    @Id
    @SequenceGenerator(name = "pessoa_generator", sequenceName = "pessoa_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_generator")
    private long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pessoa")
    private List<Lembrete> lembretes;

    public Pessoa() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }
}
