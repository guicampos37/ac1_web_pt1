package com.example.aula3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aula3.models.CategoriaProduto;
import com.example.aula3.models.Produto;
import com.example.aula3.repository.CategoriaProdutoRepository;
import com.example.aula3.repository.ProdutoRepository;

@SpringBootApplication
public class Aula3Application {

    @Bean
    public CommandLineRunner init(
     @Autowired ProdutoRepository produtoRepository,
     @Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {

			produtoRepository.inserir(
					new Produto((long) 0, "prod1", 2000));

					
			produtoRepository.inserir(
					new Produto((long) 0, "prod2", 2000));


			List<Produto> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);

			System.out.println("Exemplo obter por nome");
			listaProdutos = produtoRepository.obterPorNome("2");
			listaProdutos.forEach(System.out::println);

			System.out.println("Inserir Categoria");

			CategoriaProduto c1 = new CategoriaProduto((long) 0, "Nivel 1", "Primeiro");
			categoriaProdutoRepository.editar(c1);

			listaProdutos.get(0).setCategoriaProduto(c1);
			produtoRepository.inserir(listaProdutos.get(0));

			System.out.println("Exemplo Delete");
			produtoRepository.excluirPorId(1);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
