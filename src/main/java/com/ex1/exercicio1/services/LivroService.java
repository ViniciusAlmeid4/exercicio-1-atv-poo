package com.ex1.exercicio1.services;

import com.ex1.exercicio1.models.Livro;
import com.ex1.exercicio1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository lr;

    public Optional<Livro> get(Long id) {
        return lr.findById(id);
    }

    public List<Livro> getAll() {
        return lr.findAll();
    }

    public Livro create(Livro l) {
        return lr.save(l);
    }

    public void delete(Long id) {
        lr.deleteById(id);
    }
}
