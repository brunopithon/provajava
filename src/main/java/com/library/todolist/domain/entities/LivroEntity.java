package com.library.todolist.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class LivroEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String isbn;
  private String anopub;
  private boolean carried_out;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  public String getAnopub() {
    return anopub;
  }
  public void setAnopub(String anopub) {
    this.anopub = anopub;
  }
  public boolean isCarried_out() {
    return carried_out;
  }
  public void setCarried_out(boolean carried_out) {
    this.carried_out = carried_out;
  }
}
