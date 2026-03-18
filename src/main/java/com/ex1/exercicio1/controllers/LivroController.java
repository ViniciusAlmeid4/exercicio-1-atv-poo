package com.ex1.exercicio1.controllers;

import com.ex1.exercicio1.models.Livro;
import com.ex1.exercicio1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/livros")
public class LivroController {
    @Autowired
    private LivroService ls;

    @GetMapping("/{id}")
    public Optional<Livro> get(@PathVariable Long id) {
        return ls.get(id);
    }

    @GetMapping()
    public List<Livro> getAll() {
        return ls.getAll();
    }

    @PostMapping()
    public ResponseEntity<Livro> create(@RequestBody Livro l) {
        Livro cl = ls.create(l);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(cl.getId()).toUri();
        return ResponseEntity.created(uri).body(cl);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ls.delete(id);
        return ResponseEntity.noContent().build();
    }
}
