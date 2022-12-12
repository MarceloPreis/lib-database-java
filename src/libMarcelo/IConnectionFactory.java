package libMarcelo;

public interface IConnectionFactory {
	public DBConnection connect(String sgbd, String database, String user, String pass, String url);
}
