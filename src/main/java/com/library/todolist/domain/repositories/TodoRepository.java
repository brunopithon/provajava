package com.library.todolist.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.todolist.domain.entities.TodoEntity;
import java.util.List;


public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
  List<TodoEntity> findByPriority(int priority);
  List<TodoEntity> findByName(String name);
}
