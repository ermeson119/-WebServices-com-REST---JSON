package com.escola.faculdade;

import com.escola.faculdade.model.entity.Pessoa;
import com.escola.faculdade.model.entity.Telefone;
import com.escola.faculdade.repository.PessoaRepository;
import com.escola.faculdade.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FaculdadeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
	}

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {


		List<Telefone> telefones = new ArrayList<>();

		Telefone telefone = new Telefone(1,"63","981201914");
		telefones.add(telefone);
		telefoneRepository.save(telefone);

		Pessoa pessoa = new Pessoa(1, "Ermeson Balbinot", telefones );
		pessoaRepository.save(pessoa);



	}
}
