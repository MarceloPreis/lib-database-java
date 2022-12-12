package libMarcelo;

public class FactoryConnectionNew implements IConnectionFactory {

	@Override
	public DBConnection connect(String sgbd, String database, String user, String pass, String url) {
		switch (sgbd) {
			case "1": {
				FactoryMySql mysqlF = new FactoryMySql();
				return mysqlF.connect(sgbd, database, user, pass, url);
			}
		}
		return null;
	}

}
