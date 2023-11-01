package com.library.todolist.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.todolist.domain.entities.TodoEntity;
import com.library.todolist.domain.repositories.TodoRepository;

@Service
public class TodoService {
  private TodoRepository todoRepository;
  // private BeanConfig beanConfig;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
    // this.beanConfig = beanConfig;
  }

  public List<TodoEntity> storeOrUpdateTodo(TodoEntity todo){
    todoRepository.save(todo);
    return listTodos();
  }

  public List<TodoEntity> listTodos() {
    Sort sort = Sort.by(Sort.Direction.DESC, "priority").and(
      Sort.by(Sort.Direction.ASC, "name")
    );
    return todoRepository.findAll(sort);
  }

  public ResponseEntity<TodoEntity> findTodoById(Long id) {
    Optional<TodoEntity> todo = todoRepository.findById(id);
    if (todo.isPresent()) {
      return ResponseEntity.ok(todo.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public List<TodoEntity> updateTodo(TodoEntity todo) {
    todoRepository.save(todo);
    return listTodos();
  }
  public List<TodoEntity> destroyTodo(Long id) {
    todoRepository.deleteById(id);
    return listTodos();
  }
}
