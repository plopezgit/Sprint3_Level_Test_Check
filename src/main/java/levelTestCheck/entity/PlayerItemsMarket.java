package levelTestCheck.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerItemsMarket {

	private Map<Integer, NPC> characters;
	private List<Item> items;
	private float marketBalance;

	public PlayerItemsMarket() {
		characters = new HashMap<>();
		items = new ArrayList<>();
		fullfilInitialNPCDataBaseExample();
		fullfilInitialNpcItemsBagDataBaseExample();
		marketBalanceInitialization();
	}

	public List<Item> getItems() {
		return items;
	}
	
	public List<Item> addItems(Item e) {
		items.add(e);
		return items;
	}

	public Map<Integer, NPC> getCharacters() {
		return characters;
	}

	public float getMarketBalance() {
		return marketBalance;
	}

	public void setMarketBalance(float marketBalance) {
		this.marketBalance = marketBalance;
	}
	
	public String buyItem(int npcKey, int itemIndex) {
		String result;
		if (isValidSale(itemIndex, npcKey)) {
			characters.get(npcKey).buyItem(this, itemIndex);
			result = "Compra exitosa";
		} else {
			result = "No es posible la transaccion";
		}

		return result;
	}

	public void sellItem(int npcKey, int itemIndex) {
		characters.get(npcKey).sellItem(this, itemIndex);
	}

	public boolean isValidSale(int indexItem, int npcKey) {
		return this.getItems().get(indexItem).existStockItem() && 
				characters.get(npcKey).enoughBalance(indexItem) && 
				characters.get(npcKey).limitItemsValidation();
	}

	public float incrementMarketBalance(float totalTransacction) {
		marketBalance = marketBalance - totalTransacction;
		return marketBalance;
	}

	public float reduceMarketBalance(float totalTransacction) {
		marketBalance = marketBalance - totalTransacction;
		return marketBalance;
	}

	public boolean enoughMarketBalance(int itemPrice) {
		return marketBalance > itemPrice;
	}

	public int existItem(int itemID) {
		int itemIndex = -1;
		int i = 0;

		while (itemIndex == -1 && items.size() != i) {
			if (items.get(i).getItemID() == (itemID)) {
				itemIndex = i;
			} else {
				itemIndex = -1;
				i++;
			}
		}

		return itemIndex;
	}

	public void marketBalanceInitialization() {
		for (Item i : items) {
			marketBalance = +i.getItemPrice();
		}
	}

	public void fullfilInitialNPCDataBaseExample() {
		characters.put(1, new NPC_Farmer("Paul", "Hual"));
		characters.put(2, new NPC_Farmer("Phol", "Jul"));
		characters.put(3, new NPC_Thief("Kill", "Hual"));
		characters.put(4, new NPC_Thief("Bill", "Jul"));
		characters.put(5, new NPC_Merchant("Jaime", "Hual"));
		characters.put(6, new NPC_Merchant("Gamlo", "Jul"));
	}
	
	public void fullfilInitialNpcItemsBagDataBaseExample() {
		items.add(new Item(1, "Knive", "Army", 20.0F, 10));
		items.add(new Item(2, "Cup", "Instrument", 10.0F, 10));
		items.add(new Item(3, "Map", "Instrument", 30.0F, 10));
		items.add(new Item(4, "Jacket", "Cloth", 23.0F, 10));
		items.add(new Item(5, "MP3", "Electronic", 14.0F, 10));
		items.add(new Item(6, "Salt", "Conservative", 5.0F, 10));
	}

}
