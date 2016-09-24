package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//O Design Pattern Facotry serve para encapsular a construção de objetos complicados, de algo repetitivo.
//Basta invocar o método e já obetemos uma nova conexão.
//Podemos também, mais tarde, mudar a forma de obtenção de conexão, para por exemplo usando o mecanismo de Pooling
public class ConnectionFactory {
	public Connection getConnection(){
	  try{
		return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","rubim1987");
	  } catch(SQLException e){
		  //Isto diminui o acomplamento. O código que chamar a fábrica de conexões não ficará acomplado com a API do JDBC
		  throw new RuntimeException(e);
	  }
	}

}

//Padrões de projeto como o Factory serverm para criar componentes reutilizáveis que facilitem a padronização, isso
//permite agilidade na criação de soluções para problemas recorrentes no desenvolvimento de sistemas. 