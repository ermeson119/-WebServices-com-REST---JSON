package com.escola.faculdade.controller;

import com.escola.faculdade.model.entity.Telefone;
import com.escola.faculdade.repository.TelefoneRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    TelefoneRepository telefoneRepository;

    @PostMapping("/form")
    public Telefone createCurso(@Valid @RequestBody Telefone notebook) {
        return telefoneRepository.save(notebook);
    }

    @GetMapping("/list")
    public List<Telefone> getAllCurso() {
        return telefoneRepository.findAll();
    }


    @GetMapping("/buscar/{id}")
    Optional<Telefone> getCursoById(@PathVariable Integer id) {
        return telefoneRepository.findById(id);
    }

    @PutMapping("/atualizar/{id}")
    Telefone updateOrCreate(@RequestBody Telefone novoTelefone, @PathVariable Integer id) {

        return telefoneRepository.findById(id)
                .map(telefone -> {
                    telefone.setDd(novoTelefone.getDd());
                    telefone.setNumero(novoTelefone.getNumero());
                    return telefoneRepository.save(telefone);
                })
                .orElseGet(() -> {
                    novoTelefone.setId(id);
                    return telefoneRepository.save(novoTelefone);
                });
    }

    @DeleteMapping("/deletar/{id}")
    void delete(@PathVariable Integer id) {
        telefoneRepository.deleteById(id);
    }

}
