package libMarcelo;

public class Columns {
	private String type;
	private String name;
	private boolean pk;
	private boolean nn;
	private boolean ai;

	public Columns(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
