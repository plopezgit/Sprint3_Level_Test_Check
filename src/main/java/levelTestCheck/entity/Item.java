package levelTestCheck.entity;

public class Item {

	private String itemName;
	private String itemType;
	private float itemPrice;
	private float itemUsePercentage;
	private final float ITEM_DETERIORATION_THIEF_RATE = (itemUsePercentage * 25) / 100;
	private final float ITEM_DETERIORATION_FARMER_RATE = (itemUsePercentage * 15) / 100;
	
	public Item(String itemName, String itemType, float itemPrice, float itemUsePercentage) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemUsePercentage = 100;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	
	//Method class
	
	public void wearAndTearThive() {
		
		float itemDeteriorationReduction = itemUsePercentage - ITEM_DETERIORATION_THIEF_RATE;
		itemUsePercentage = itemDeteriorationReduction;
	}
	
	public void wearAndTearFarmer() {
		float wearAndTearFarmerReduction = itemUsePercentage - ITEM_DETERIORATION_FARMER_RATE;
		itemUsePercentage = wearAndTearFarmerReduction;
	}
	
}
