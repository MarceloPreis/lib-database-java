package libMarcelo;

public class FactoryMySql implements IConnectionFactory{

	@Override
	public DBConnection connect(String sgbd, String database, String user, String pass, String url) {
		String driverName = "com.mysql.cj.jdbc.Driver";
		return new MySql(database, user, pass, url, driverName);
	}
	
}
