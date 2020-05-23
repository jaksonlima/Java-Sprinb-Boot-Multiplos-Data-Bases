package com.example.data.source.datasource.config.data.bases;

import com.example.data.source.datasource.repository.auth.UsuarioRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

//@PropertySource("classpath:application.application")
@Configuration
@EnableJpaRepositories(
        basePackageClasses = UsuarioRepository.class,
        entityManagerFactoryRef = "authEntityManager")
public class AuthConfigDb {

    @Bean
    @ConfigurationProperties(prefix = "auth.database")
    public DataSource AuthConfigDb(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean authEntityManager(EntityManagerFactoryBuilder builder,
                                                                   @Qualifier("authConfigDb") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.example.data.source.datasource.model.auth")
                .build();
    }
}
