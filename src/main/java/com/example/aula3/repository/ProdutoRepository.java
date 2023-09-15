package com.example.aula3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.aula3.models.Produto;
import com.example.aula3.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto){
        entityManager.merge(produto);
        return produto;

    }

    public List<Produto> obterTodos(){
        return entityManager.createQuery("from Produto", 
        Produto.class).getResultList();
    }

    public List<Produto> obterPorNome(String prod_nome){
        String jpql = "select c from Produto c where c.cat_nome like :cat_nome";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("cat_nome", "%" + prod_nome + "%");
        return query.getResultList();
    }

    @Transactional
    public void excluirPorId(int id){
        Produto produto = entityManager.find(Produto.class, id);
        this.entityManager.remove(produto);
    }

}
