package com.library.todolist.infrastructure.config;

import javax.sql.DataSource;

public interface BeanConfig {
  DataSource getDataSource();
}
