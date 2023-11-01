package com.library.todolist.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.todolist.domain.entities.LivroEntity;
import com.library.todolist.domain.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
  private LivroService livroService;

  public LivroController(LivroService livroService) {
    this.livroService = livroService;
  }

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  List<LivroEntity> storeOrUpdateLivro(@RequestBody LivroEntity livro) {
    return livroService.storeOrUpdateLivro(livro);
  }

  @GetMapping
  List<LivroEntity> listLivros() {
    return livroService.listLivros();
  }

  @GetMapping("/{id}")
  ResponseEntity<Object> findById(@PathVariable("id") Long id) {
    ResponseEntity<LivroEntity> response = livroService.findLivroById(id);
    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
      return new ResponseEntity<>("Livro não existe no sistema", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(response.getBody());
  }
  // @PutMapping
  // List<LivroEntity> Livro(@RequestBody LivroEntity livro) {
  //   return livroService.updateLivro(livro);
  // }

  @DeleteMapping("{id}")
  List<LivroEntity> destroyLivro(@PathVariable("id") Long id) {
    return livroService.destroyLivro(id);
  }
}
