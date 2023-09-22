package com.example.aula3.models;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String cat_nome;

    @Column(length = 200, nullable = false)
    private String cat_descricao;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Long id, String cat_nome, String cat_descricao) {
        
        this.cat_nome = cat_nome;
        this.cat_descricao = cat_descricao;
    }

    @Override
    public String toString() {
        return "CategoriaProduto [id=" + id + ", cat_nome=" + cat_nome + ", cat_descricao=" + cat_descricao + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    public String getCat_descricao() {
        return cat_descricao;
    }

    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }

    @OneToMany(mappedBy = "categoriaProduto")
    private List<Produto> produtos;

    
}
