/**
 * Classe abstrata base para todos os diferentes tipos de conexão SGBD 
 * 
 * @author Marcelo Preis
 */

package libMarcelo;

public abstract class DBConnection implements IDBConnection{
	protected String database;
	protected String user;
	protected String pass;
	protected String url;
	protected String status;
	protected String port;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
