package libMarcelo;

public interface IDBConnection {
	public Object getConnection();
	public String getStatus();
	public String execute(String sql);
}
