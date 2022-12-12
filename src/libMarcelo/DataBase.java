/**
 * Classe que contém o nome do Banco de Dados e as tabelas do banco
 * @author Marcelo Preis
 */

package libMarcelo;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	private String DBName;
	private List<Table> tables = new ArrayList<Table>();

	/**
	 * 
	 * @param DBName Nome da DataBase
	 * @param tables Lista de tabelas da DataBase
	 */
	
	public DataBase(String DBName, List<Table> tables){
		this.DBName = DBName;
		this.tables = tables;
	}

	public String toQuery() {
		String query = "";
		for (Table table : tables) {
			query += " " + table.toQuery(DBName);
		}
		return query;
	}

	public String getDBName() {
		return DBName;
	}

	public void setDBName(String dBName) {
		DBName = dBName;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void addTable(Table table) {
		this.tables.add(table);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataBase [DBName=");
		builder.append(DBName);
		builder.append("]");
		builder.append(", tables= [");
		builder.append("]");
		return builder.toString();
	}

}
