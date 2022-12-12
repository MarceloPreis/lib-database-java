/**
 * Classe representa a conexão específica com SGBD MySQL.
 * 
 * @author Marcelo Preis
 * 
 */

package libMarcelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql extends DBConnection {
	private String driverName;
	/**
	 * 
	 * @param database Nome da DataBase 
	 * @param user User de acesso
	 * @param pass Senha de acesso
	 * @param url URL do driver d Conexão 
	 */

	public MySql(String database, String user, String pass, String url, String driverName){
		this.database = database;
		this.user = user;
		this.pass = pass;
		this.url = url;
		this.driverName = driverName;
		this.status = "Não Conectado...";
	}

	public Connection getConnection() {
		System.out.println(driverName + " " + user + " " + url + " " + pass);
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, pass);

			if (connection != null) {
				this.status = ("STATUS--->Conectado com sucesso!");
			} else {
				this.status = ("STATUS--->Não foi possivel realizar conexão");
			}

			return connection;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
		} catch (SQLException e) {

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		}
		return null;
	}

	public String getStatus() {
		return status;
	}
	
	@Override
	public String execute(String sql) {
		java.sql.PreparedStatement prepare;
		Connection connection = this.getConnection();
		
		try {
			prepare =  connection.prepareStatement(sql);
			String[] statements = sql.split(";");
			
			for (String statement : statements) {
				prepare.addBatch(statement);
			}
			
			prepare.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Executado com sucesso!";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MySql [database=");
		builder.append(database);
		builder.append(", user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append(", url=");
		builder.append(url);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
