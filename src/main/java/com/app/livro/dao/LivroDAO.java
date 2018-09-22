/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tmanagerplate file, choose Tools | Tmanagerplates
 * and open the tmanagerplate in the editor.
 */
package com.app.livro.dao;

import com.app.livro.jpa.JPAUtil;
import com.app.livro.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Oliveira
 */
public class LivroDAO {

    private EntityManager manager;

    // método de operação gravar um livro no banco -------------------------------------
    public void gravarLivro(Livro livro) {

        manager = new JPAUtil().getEtityManager();
        manager.getTransaction().begin();
        manager.persist(livro);
        manager.getTransaction().commit();
        manager.close();

    }

    // método de operação listar todos os livros do banco -------------------------------
    public List<Livro> getLivros() {

        manager = new JPAUtil().getEtityManager();
        manager.getTransaction().begin();

        List<Livro> livros = manager.createQuery("from Livro").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return livros;

    }

    // método de operação deletar um livro no banco --------------------------------------
    public void deletarLivro(Integer id) {

        manager = new JPAUtil().getEtityManager();
        manager.getTransaction().begin();

        Livro livro = manager.find(Livro.class, id);

        manager.remove(livro);

        manager.getTransaction().commit();
        manager.close();
    }

    // método de operação buccar um livro no banco -----------------------------------------
    public Livro buscarLivro(Integer id) {

        manager = new JPAUtil().getEtityManager();
        manager.getTransaction().begin();

        Livro livro = manager.find(Livro.class, id);

        manager.getTransaction().commit();
        manager.close();

        return livro;
    }

    // método de operação alterar um livro no banco ------------------------------------------
    public void alterarLivro(Livro livro) {

        manager = new JPAUtil().getEtityManager();
        manager.getTransaction().begin();

        manager.merge(livro);

        manager.getTransaction().commit();
        manager.close();

    }

    // método de operação para gerar 10 livros no banco ---------------------------------------
    public void gerarDados() {

        manager = new JPAUtil().getEtityManager();

        manager.getTransaction().begin();

        for (int i = 0; i < 10; i++) {
            Livro livro = new Livro("Autor" + i, "Livro" + i, "200" + i, "abc 000" + i, i);
            manager.persist(livro);
        }

        manager.getTransaction().commit();
        manager.close();

    }
}
