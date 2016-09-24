/*
 Javabeans é uma classe básica em Java, ela deve possui no mínimo um construtor SEM PARÂMETROS, getters and setters
 e EXTENER a classe Serializable, esta último não é sempre feito.
 
 ************Diferença entre um BEAN e um POJO**************
 *O PJO é um objeto simples, que PODE OU NÂO possuir getters e setters e não possui um padrão para nomear seus métodos 
 *getters e setters.
 *Um BEAND É UM POJO, só que ele possui REGRAS, existe uma especificação para DEFINIR UM BEAN.
 *Um bean é definido por várias regras, mas as principais são:
 * -Possui ao menos um CONSTRUTOR SEM parâmetros.
 * -Possuir getters e setters com o padrão de nomes, por exemplo: getNome, setNome;
 * - EXTENDER serializable
 * Um BEAN deve possuir AO MENOS o que tem acima, se possuir a mais, como um outro construtrutor com parâmetros,
 * ele NÃO deixa de ser um BEAN.
 */

//Um BEAN é muito usado para representar o MODELO de dados na OO ou entidades(tabelas) em um banco de dados.


package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	//Métodos get e set para id, nome, email, endereco e dataNascimento
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
