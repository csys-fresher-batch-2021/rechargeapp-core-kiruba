package in.kiruba.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    /**
     * this method is used to handle the exception
     * @param message
     */
	public ServiceException(String message) {
		super(message);
	}
}
