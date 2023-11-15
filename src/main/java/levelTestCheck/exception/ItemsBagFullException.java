package levelTestCheck.exception;

public class ItemsBagFullException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemsBagFullException () {

	}

	public ItemsBagFullException (String message) {
		super(message);
	}


}
