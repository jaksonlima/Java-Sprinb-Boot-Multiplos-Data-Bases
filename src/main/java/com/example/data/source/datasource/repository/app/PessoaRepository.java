package com.example.data.source.datasource.repository.app;

import com.example.data.source.datasource.model.app.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
