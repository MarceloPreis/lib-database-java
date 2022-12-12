package libMarcelo;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws org.json.simple.parser.ParseException, IOException {
		Reader reader = new Reader();
		DataBase db = reader.readDataBase("json/database.json");
		DBConnection connec = reader.readConnection("json/conec.json");
		
		String stmt = db.toQuery();
		connec.execute(stmt);
	}
}
