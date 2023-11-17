package levelTestCheck.exception;

public class ErrorMessage {
	
	private static final String ITEM_DOES_NOT_EXIST_MESSAGE = "Item does not exist, are you sure you have the right item ID?...";
	private static final String FILE_NOT_FOUND_MESSAGE = "NPC destiny file not found";

	public static String getItemDoesNotExistMessage() {
		return ITEM_DOES_NOT_EXIST_MESSAGE;
	}

	public static String getFileNotFoundMessage() {
		return FILE_NOT_FOUND_MESSAGE;
	}
	
}
