package levelTestCheck.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemsMarket {

	private List<Item> items;
	private float marketBalance;

	public ItemsMarket() {
		items = new ArrayList<>();
		fullfilInitialNpcItemsBagDataBaseExample();
	}

	public List<Item> getItems() {
		return items;
	}
	
	//market balance methods
	
	public int existItem (int itemID) {
		int itemIndex = -1;
		int i = 0;

		while (itemIndex==-1 && items.size() != i) {
			if (items.get(i).getItemID() == (itemID)) {
				itemIndex = i;
			}else {
				itemIndex = -1;
				i++;		
			}
		}
		
		return itemIndex;
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
