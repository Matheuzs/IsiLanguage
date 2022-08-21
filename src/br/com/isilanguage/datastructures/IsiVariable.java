package br.com.isilanguage.datastructures;

public class IsiVariable extends IsiSymbol {
	
	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	
	private int type;
	private String value;
	private boolean hasBeenUsed = false;
	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}
	
	public static String getTypeText(int type) {
		switch(type) {
			case 0:
				return "numero";
			case 1:
				return "texto";
		}
		return null;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean hasBeenUsed() {
		return hasBeenUsed;
	}

	@Override
	public void setUsed() {
		this.hasBeenUsed = true;
	}
	
	@Override
	public String toString() {
		return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}

	@Override
	public String generateJavaCode() {
		String str;
		if(type == NUMBER) {
			str = "double";
		}
		else {
			str = "String";
		}
		return str + " " + super.name + ";";
	}
}
