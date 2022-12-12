/**
 * Classe que contém o nome da tabela do BD e as colunas desta tabela
 * @author Marcelo Preis
 */

 package libMarcelo;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String tableName;
	private List<Columns> columns = new ArrayList<Columns>();

	/**
	 * 
	 * @param tableName
	 * @param columns
	 */
	
	public Table(String tableName, List<Columns> columns) {
		super();
		this.tableName = tableName;
		this.columns = columns;
	}

	public String toQuery(String DBName) {
		String stmt = "CREATE TABLE " + DBName + "." + tableName;
		stmt += "(";
		for (Columns col : columns) {
			stmt += col.getName() + " " + col.getType() + ",";
		}
		stmt = stmt.substring(0, stmt.length() - 1);
		stmt += ");";
		
		return stmt;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

}
