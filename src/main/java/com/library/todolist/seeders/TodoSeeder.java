package com.library.todolist.seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.library.todolist.domain.entities.TodoEntity;
import com.library.todolist.domain.repositories.TodoRepository;

@Component
public class TodoSeeder implements CommandLineRunner {
  private TodoRepository todoRepository;

  public TodoSeeder(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  public void run(String... args) throws Exception {
    TodoEntity todo1 = new TodoEntity();
    if (todoRepository.count() == 0) {
      todo1.setName("todo 1");
      todo1.setDescription("Todo teste 1");
      todo1.setPriority(1);
      todo1.setCarried_out(false);
      todoRepository.save(todo1);
    }
  }
  
}
