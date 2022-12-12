/**
 * Classe que lê os arquivos JSON e retorna os elementos do Banco.	
 * 
 */

package libMarcelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	public DBConnection readConnection(String path) throws IOException, ParseException {
		FileReader reader = new FileReader(path);
		JSONParser jsonParser = new JSONParser();
		JSONObject connecJSON = (JSONObject) jsonParser.parse(reader);
		
		String sgbd = (String) connecJSON.get("sgbd");
		String database = (String) connecJSON.get("database");
		String user = (String) connecJSON.get("user");
		String pass = (String) connecJSON.get("pass");
		String url = (String) connecJSON.get("url");
		
		FactoryConnectionNew f = new FactoryConnectionNew();
		return f.connect(sgbd, database, user, pass, url);
	}
	
	@SuppressWarnings("unchecked")
	public DataBase readDataBase(String path) throws IOException, ParseException {
		List<Table> tablesList = new ArrayList<Table>();
		String DBName;
		FileReader reader = new FileReader(path);
		JSONParser jsonParser = new JSONParser();
		
		JSONObject dbJSON = (JSONObject) jsonParser.parse(reader);
		DBName = (String) dbJSON.get("DBName");

		JSONArray tables = (JSONArray) dbJSON.get("tables");
		tables.forEach(table -> {			
			Table newTable = readTable((JSONObject)table);
			tablesList.add(newTable);
		});
		
		return new DataBase(DBName, tablesList);	
	}
	
	@SuppressWarnings("unchecked")
	public Table readTable(JSONObject t) {
		List<Columns> columnList = new ArrayList<Columns>();
		String tableName = (String) t.get("tableName");

		JSONArray cols = (JSONArray) t.get("columns");
		cols.forEach(col -> {
			Columns newCol = readColumn((JSONObject) col);
			columnList.add(newCol);
		});
		
		return new Table(tableName, columnList);
	}
	
	public Columns readColumn(JSONObject c) {
		String type = (String) c.get("type");
		String name = (String) c.get("name");
		
		return new Columns(name, type);
	}
	
}
