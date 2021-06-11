package in.kiruba.exception;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    /**
     * this method is user to handle the exception 
     * @param message
     */
	public DatabaseException(String message) {
		super(message);
	}

}
