package in.kiruba.exception;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DatabaseException(String message) {
		super(message);
	}

}
