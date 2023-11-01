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

import com.library.todolist.domain.entities.TodoEntity;
import com.library.todolist.domain.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  List<TodoEntity> storeOrUpdateTodo(@RequestBody TodoEntity todo) {
    return todoService.storeOrUpdateTodo(todo);
  }

  @GetMapping
  List<TodoEntity> listTodos() {
    return todoService.listTodos();
  }

  @GetMapping("/{id}")
  ResponseEntity<Object> findById(@PathVariable("id") Long id) {
    ResponseEntity<TodoEntity> response = todoService.findTodoById(id);
    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
      return new ResponseEntity<>("Todo não existe no sistema", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(response.getBody());
  }
  // @PutMapping
  // List<TodoEntity> updateTodo(@RequestBody TodoEntity todo) {
  //   return todoService.updateTodo(todo);
  // }

  @DeleteMapping("{id}")
  List<TodoEntity> destroyTodo(@PathVariable("id") Long id) {
    return todoService.destroyTodo(id);
  }
}
