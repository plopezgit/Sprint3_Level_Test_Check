package levelTestCheck.entity;

public class Item {

	private int itemID;
	private String itemName;
	private int itemOwnerKey;
	private String itemType;
	private float itemPrice;
	private float itemUsePercentage;

	public Item(int itemID, String itemName, String itemType, float itemPrice, int itemStock) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemOwnerKey = 0;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemUsePercentage = 100;
	}

	public Item(int itemID) {
		this.itemID = itemID;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemOwnerKey() {
		return itemOwnerKey;
	}

	public void setItemOwnerKey(int itemOwnerKey) {
		this.itemOwnerKey = itemOwnerKey;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public float getItemUsePercentage() {
		return itemUsePercentage;
	}

	public void setItemUsePercentage(float itemUsePercentage) {
		this.itemUsePercentage = itemUsePercentage;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemOwnerKey=" + itemOwnerKey + ", itemType="
				+ itemType + ", itemPrice=" + itemPrice + ", itemStock=" + ", itemUsePercentage="
				+ itemUsePercentage + "]";
	}

}
