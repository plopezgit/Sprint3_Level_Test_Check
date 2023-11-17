package levelTestCheck.entity;

public class Item {

	private int itemID;
	private String itemName;
	private int itemOwnerKey;
	private String itemType;
	private float itemPrice;
	private int itemStock;
	private float itemUsePercentage;
	
	public Item(int itemID, String itemName, String itemType, float itemPrice, int itemStock) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemOwnerKey = 0;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
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

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public float getItemUsePercentage() {
		return itemUsePercentage;
	}

	public void setItemUsePercentage(float itemUsePercentage) {
		this.itemUsePercentage = itemUsePercentage;
	}
	
	//Method class
	
	public void reduceStockItem () {
		itemStock -= 1;
	}
	
	public boolean existStockItem () {
		return itemStock > 0;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemOwnerKey=" + itemOwnerKey + ", itemType="
				+ itemType + ", itemPrice=" + itemPrice + ", itemStock=" + itemStock + ", itemUsePercentage="
				+ itemUsePercentage + "]";
	}
	
}
