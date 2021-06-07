package projescola.util;

public class projescolaException extends RuntimeException {

	private Integer code;
	
	public projescolaException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
