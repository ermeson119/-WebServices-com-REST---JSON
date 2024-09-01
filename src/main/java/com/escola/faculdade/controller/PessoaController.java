package com.escola.faculdade.controller;

import com.escola.faculdade.model.entity.Pessoa;
import com.escola.faculdade.model.entity.Telefone;
import com.escola.faculdade.repository.PessoaRepository;
import com.escola.faculdade.repository.TelefoneRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;


    @PostMapping("/form")
    public Pessoa createCurso(@Valid @RequestBody Pessoa pessoa) {


        List<Telefone> novosTelefones = new ArrayList<>();

        for (Telefone telefone : pessoa.getTelefones()) {

            Telefone newTelefone = new Telefone();
            newTelefone.setDd(telefone.getDd());
            newTelefone.setNumero(telefone.getNumero());
            telefoneRepository.save(newTelefone);
            novosTelefones.add(newTelefone);
        }

        pessoa.setTelefones(novosTelefones);

        return pessoaRepository.save(pessoa);
    }



    @GetMapping("/list")
    public List<Pessoa> getAllEstudantes() {
        return pessoaRepository.findAll();
    }


    @GetMapping("/buscar/{id}")
    Optional<Pessoa> getCursoById(@PathVariable Integer id) {
        return pessoaRepository.findById(id);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarOuCriar(@RequestBody Pessoa novoPessoa, @PathVariable Integer id) {

        Pessoa pessoaAtualizado = pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(novoPessoa.getNome());
                    pessoa.setTelefones(novoPessoa.getTelefones());
                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(() -> {
                    novoPessoa.setId(id);
                    return pessoaRepository.save(novoPessoa);
                });

        return ResponseEntity.ok(pessoaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void  delete(@PathVariable Integer id)  {

        pessoaRepository.deleteById(id);
    }

}
