package levelTestCheck.entity;

import java.util.ArrayList;
import java.util.List;

public class PlayerItemsMarket {

	private List<Item> items;
	private float marketBalance;

	public PlayerItemsMarket() {
		items = new ArrayList<>();
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

	public float getMarketBalance() {
		return marketBalance;
	}

	public void setMarketBalance(float marketBalance) {
		this.marketBalance = marketBalance;
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

	public void fullfilInitialNpcItemsBagDataBaseExample() {
		items.add(new Item(1, "Knive", "Army", 20.0F, 10));
		items.add(new Item(2, "Cup", "Instrument", 10.0F, 10));
		items.add(new Item(3, "Map", "Instrument", 30.0F, 10));
		items.add(new Item(4, "Jacket", "Cloth", 23.0F, 10));
		items.add(new Item(5, "MP3", "Electronic", 14.0F, 10));
		items.add(new Item(6, "Salt", "Conservative", 5.0F, 10));
	}

}
