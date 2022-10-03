/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public abstract class Obra {
    int codigo;
    String titulo;
    
    // Composição!
    Autor autor = new Autor();
    Editora editora = new Editora();
    
    public Obra(int _codigo, String _titulo, Autor _autor, Editora _editora){
        this.codigo = _codigo;
        this.titulo = _titulo;
        
        this.autor = _autor;
        this.editora = _editora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora;
    }
    
}
