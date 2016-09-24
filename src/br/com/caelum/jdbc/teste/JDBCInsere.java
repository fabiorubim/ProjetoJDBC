package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

/*
 * Esta técnica abaixo para inserir dados no banco de dados é problemática, pois mistura a lógica do negócio com
 * código SQL.
 * 
 * ******API DE ORM - JPA ou HIBERNATE
 * Hoje em dia não se usa diretamente JDBC, o mais usado é algum tipo de API de ORM como JPA ou HIBERNATE.
 * Tanto no uso do JDBC quanto de bibliotecas ORM deve-se prestar a atenção no momento de fechar uma conexão
 * */

public class JDBCInsere {
	public static void main(String[] args) throws SQLException {
		Connection conexao = null;
		/*
		 * Pode-se usar também try-with-resources à partir dos Java7. Com isso permite declarar e inicializar objetos
		 * que implementam AutoClosable, dessa forma ao término do try o próprio compilador inserirá instruções para invocar
		 * o "close" desses recursos.
		 * ex: try(Connection con = new ConnectionFactory().getConnection()){
		 * */
	  try{
		conexao = new ConnectionFactory().getConnection();
		//Este trecho de código SQL é chamado de statement
		String sql = "INSERT INTO contatos(nome,email,endereco,dataNascimento) "+
		             "VALUES(?,?,?,?)";
		
		//PreparedStatement é uma INTERFACE que possui sua implementação na conexão, no método prepareStatement
		//O PreparedStatement pré-compila o código SQL, evitando assim problemas como SQLInjection e o problema
		//de Joana D'Arc
		//PreparedStatement é também mais rápido que Statement e contém muito mais recursos.
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		//Aqui a order dos campos é o primeiro parâmetro do setString
		stmt.setString(1, "Caelum");
		stmt.setString(2, "contato@caelu.com.br");
		stmt.setString(3, "R. Vergueiro 3185 cj57");
		
		//PreparedStatement só aceita o tipo DATE, como date é UM LONG então pegamos de Calendar.getInstance().getTimeInMillis()
		java.sql.Date dataParaGravar = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		stmt.setDate(4, dataParaGravar);
		
		stmt.execute();
	  } catch(SQLException e){
		  System.out.println(e);
		  
	  }finally{
		  //Mesmo se o código dentro de TRY lançar um exceção, a conexão será sempre fechada.
		  conexao.close();
	  }
		
		
		
	}

}
