package br.com.carlosevalentin.applembrete.entidades;

import javax.persistence.*;

@Entity
@Table(name = "Lembretes")
public class Lembrete implements EntidadeBase {

    @Id
    @SequenceGenerator(name = "lembrete_generator", sequenceName = "lembrete_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lembrete_generator")
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Pessoa pessoa;

    public Lembrete() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
