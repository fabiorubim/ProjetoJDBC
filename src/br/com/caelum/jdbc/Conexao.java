package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
	public static void main(String[] args) throws ClassNotFoundException {
		try{
		  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","rubim1987");
		  System.out.println("Conectado!");
		  conexao.close();
		} catch (SQLException e)
		{
		  throw new RuntimeException(e);
		}
		
	}
}

