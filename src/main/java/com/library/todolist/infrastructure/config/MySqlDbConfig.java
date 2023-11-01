package com.library.todolist.infrastructure.config;

import javax.sql.DataSource;

// import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("mysql")
public class MySqlDbConfig implements BeanConfig {
  @Bean
  public DataSource getDataSource() {
    // DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    //   dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
    //   dataSourceBuilder.url("jdbc:mysql://localhost:3308/provajava");
    //   dataSourceBuilder.username("root");
    //   dataSourceBuilder.password("root");
    //   return dataSourceBuilder.build();
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3308/provajava");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
  }
}
