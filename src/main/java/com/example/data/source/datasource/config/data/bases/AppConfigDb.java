package com.example.data.source.datasource.config.data.bases;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.data.source.datasource.repository.app",
        entityManagerFactoryRef = "appEntityManager")
public class AppConfigDb {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.database")
    public DataSource appConfigDb(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean appEntityManager(EntityManagerFactoryBuilder builder,
                                                                   @Qualifier("appConfigDb") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.example.data.source.datasource.model.app")
                .build();
    }
}
