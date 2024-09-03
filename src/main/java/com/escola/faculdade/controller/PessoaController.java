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
    public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {


        List<Telefone> novosTelefones = new ArrayList<>();

        for (Telefone telefone : pessoa.getTelefones()) {
            Telefone newTelefone = telefoneRepository.findById(telefone.getId()).orElseThrow();
//            Telefone newTelefone = new Telefone();
//            newTelefone.setDd(telefone.getDd());
//            newTelefone.setNumero(telefone.getNumero());
//            telefoneRepository.save(newTelefone);
            novosTelefones.add(newTelefone);
        }

        pessoa.setTelefones(novosTelefones);

        return pessoaRepository.save(pessoa);
    }



    @GetMapping("/list")
    public List<Pessoa> getAllPessoa() {
        return pessoaRepository.findAll();
    }


    @GetMapping("/buscar/{id}")
    Optional<Pessoa> getPessoaById(@PathVariable Integer id) {
        return pessoaRepository.findById(id);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa novoPessoa, @PathVariable Integer id) {
        Pessoa pessoaAtualizada = pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(novoPessoa.getNome());
                    pessoa.getTelefones().clear();

                    if (novoPessoa.getTelefones() != null) {
                        List<Telefone> novosTelefones = new ArrayList<>();

                        for (Telefone telefone : novoPessoa.getTelefones()) {
                            Telefone newTelefone = telefoneRepository.findById(telefone.getId())
                                    .orElseThrow(() -> new RuntimeException("Telefone não encontrado: " + telefone.getId()));
                            novosTelefones.add(newTelefone);
                        }

                        pessoa.getTelefones().addAll(novosTelefones);
                    }

                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(() -> {
                    novoPessoa.setId(id);
                    if (novoPessoa.getTelefones() != null) {
                        List<Telefone> novosTelefones = new ArrayList<>();

                        for (Telefone telefone : novoPessoa.getTelefones()) {
                            Telefone newTelefone = telefoneRepository.findById(telefone.getId())
                                    .orElseThrow(() -> new RuntimeException("Telefone não encontrado: " + telefone.getId()));
                            novosTelefones.add(newTelefone);

                        }
                        novoPessoa.setTelefones(novosTelefones);

                    } else {
                        novoPessoa.setTelefones(new ArrayList<>());
                    }
                    return pessoaRepository.save(novoPessoa);
                });

        return ResponseEntity.ok(pessoaAtualizada);
    }


    @DeleteMapping("/deletar/{id}")
    public void  delete(@PathVariable Integer id)  {

        pessoaRepository.deleteById(id);
    }

}
