/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public final class Exemplar extends Obra {
    
    int codigo, ano, edicao;

    public Exemplar(int _obraCod, String obraTitulo, Autor _autor, Editora _editora, int _codigo, int _edicao, int _ano){
        // Contrutor da Obra é aqui embaixo
        super(_obraCod, obraTitulo, _autor, _editora);
        
        // Já aqui, é atributos dessa classe
        this.codigo = _codigo;
        this.ano = _ano;
        this.edicao = _edicao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    
    public void setObra(Obra obra){
        super.codigo = obra.codigo;
        super.titulo = obra.titulo;
        super.autor = obra.autor;
        super.editora = obra.editora;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", ano=" + ano + ", edicao=" + edicao;
    }
    
    
}
