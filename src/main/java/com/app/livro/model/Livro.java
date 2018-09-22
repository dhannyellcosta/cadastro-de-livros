/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.livro.model;

import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Oliveira
 */
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String autor;
    private String livro;
    private String anoEdicao;
    private String resenha;
    private Integer nota;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Lob
    private byte[] imagem;

    public Livro(String autor, String livro, String anoEdicao, String resenha, Integer nota) {
        this.autor = autor;
        this.livro = livro;
        this.anoEdicao = anoEdicao;
        this.resenha = resenha;
        this.dataCadastro = Calendar.getInstance().getTime();
        this.nota = nota;
    }

    public Livro() {
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the livro
     */
    public String getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(String livro) {
        this.livro = livro;
    }

    /**
     * @return the anoEdicao
     */
    public String getAnoEdicao() {
        return anoEdicao;
    }

    /**
     * @param anoEdicao the anoEdicao to set
     */
    public void setAnoEdicao(String anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    /**
     * @return the resenha
     */
    public String getResenha() {
        return resenha;
    }

    /**
     * @param resenha the resenha to set
     */
    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    @Override
    public String toString() {
        return "[Autor] " + autor + "\n[Livro] " + livro + "\n[Ano Edição] " + anoEdicao
                + "\n[Resenha] " + resenha + "\n[Data cadastro] " + dataCadastro;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    /**
     * @return the imagem
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public void setImagem(Image diminuirImagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
