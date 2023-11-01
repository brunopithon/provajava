package com.library.todolist.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.todolist.domain.entities.LivroEntity;
import com.library.todolist.domain.repositories.LivroRepository;

@Service
public class LivroService {
  private LivroRepository livroRepository;
  // private BeanConfig beanConfig;

  public LivroService(LivroRepository livroRepository) {
    this.livroRepository = livroRepository;
    // this.beanConfig = beanConfig;
  }

  Sort sort = Sort.by(Sort.Order.asc("titulo")); // Classifique pelo título em ordem ascendente

  public List<LivroEntity> storeOrUpdateLivro(LivroEntity livro){
    livroRepository.save(livro);
    return listLivros();
  }

  public List<LivroEntity> listLivros() {
    Sort sort = Sort.by(Sort.Direction.DESC).and(
      Sort.by(Sort.Direction.ASC, "titulo")
    );
    return livroRepository.findAll(sort);
  }

  public ResponseEntity<LivroEntity> findLivroById(Long id) {
    Optional<LivroEntity> livro = livroRepository.findById(id);
    if (livro.isPresent()) {
      return ResponseEntity.ok(livro.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public List<LivroEntity> updateTodo(LivroEntity livro) {
    livroRepository.save(livro);
    return listLivros();
  }
  public List<LivroEntity> destroyLivro(Long id) {
    livroRepository.deleteById(id);
    return listLivros();
  }
}
