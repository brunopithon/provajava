package com.library.todolist.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.todolist.domain.entities.LivroEntity;
import java.util.List;


public interface LivroRepository extends JpaRepository<LivroEntity, Long>{
  List<LivroEntity> findByTitulo(String titulo);
}
