package levelTestCheck.exception;

public class ItemDoesNotExist extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemDoesNotExist () {

	}

	public ItemDoesNotExist (String message) {
		super(message);
	}


}
