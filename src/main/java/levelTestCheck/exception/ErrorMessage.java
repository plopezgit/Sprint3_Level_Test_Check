package levelTestCheck.exception;

public class ErrorMessage {
	
	private static final String ITEM_DOES_NOT_EXIST_MESSAGE = "Item does not exist, are you sure you have the right item ID?...";
	private static final String FILE_NOT_FOUND_MESSAGE = "NPC destiny file not found.";
	private static final String INVALID_SALE = "Inventory full! The seller cannot buy the item.";

	public static String getItemDoesNotExistMessage() {
		return ITEM_DOES_NOT_EXIST_MESSAGE;
	}

	public static String getFileNotFoundMessage() {
		return FILE_NOT_FOUND_MESSAGE;
	}

	public static String getInvalidSale() {
		return INVALID_SALE;
	}
	
	
}
