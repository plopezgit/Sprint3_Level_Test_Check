package levelTestCheck.entity;

import java.util.ArrayList;
import java.util.List;
import levelTestCheck.exception.ErrorMessage;

public abstract class NPC {
	
	private String npcName;
	private String npcLocation;
	private float npcWalletBalance;
	private List<Item> npcItemsBag;

	public NPC(String npcName, String npcLocation) {
		this.npcName = npcName;
		this.npcLocation = npcLocation;
		npcWalletBalance = 500;
		npcItemsBag = new ArrayList<>();
	}

	public List<Item> getNpcItemsBag() {
		return npcItemsBag;
	}
	
	public String getNpcLocation() {
		return npcLocation;
	}
	
	public abstract void addItemTaxes(PlayerItemsMarket itemsMarket, int itemIndex, Item i);	
	
	public abstract void setItemDeterioration(PlayerItemsMarket itemsMarket, int itemIndex, Item i);
	
	public abstract boolean limitItemsValidation();
	
	public List<Item> buyItem(PlayerItemsMarket itemsMarket, int itemIndex) {
		try {
			reduceNPCWalletBalance((float) itemsMarket.getItems().get(itemIndex).getItemPrice());
			itemsMarket.incrementMarketBalance(itemsMarket.getItems().get(itemIndex).getItemPrice());
		} catch (IndexOutOfBoundsException e) {
			System.err.println(ErrorMessage.getItemDoesNotExistMessage());
		} 
			getNpcItemsBag().add(itemsMarket.getItems().get(itemIndex));
				itemsMarket.getItems().get(itemIndex).reduceStockItem();
					itemsMarket.getItems().get(itemIndex).setItemOwnerKey(this.hashCode());
						addItemTaxes(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
							setItemDeterioration(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
								npcItemsBag.get(npcItemsBag.size()-1).setItemStock(1);
								
		return getNpcItemsBag();
	}
	
	public List<Item> saleItem(PlayerItemsMarket itemsMarket, int itemIndex) {
		try {
			incrementNPCWalletBalance((float) npcItemsBag.get(itemIndex).getItemPrice());
			itemsMarket.reduceMarketBalance(npcItemsBag.get(itemIndex).getItemPrice());
		} catch (IndexOutOfBoundsException e) {
			System.err.println(ErrorMessage.getItemDoesNotExistMessage());
		} 
			itemsMarket.getItems().add(npcItemsBag.get(itemIndex));
				npcItemsBag.remove(itemIndex);
					itemsMarket.getItems().get(itemsMarket.getItems().size()-1).setItemOwnerKey(itemsMarket.hashCode());
					
		return getNpcItemsBag();
	}
	
	public float reduceNPCWalletBalance (float totalTransacction) {
		npcWalletBalance = npcWalletBalance - totalTransacction;
		return npcWalletBalance;
	}
	
	public float incrementNPCWalletBalance (float totalTransacction) {
		npcWalletBalance = npcWalletBalance + totalTransacction;
		return npcWalletBalance;
	}

	public boolean enoughBalance (int itemPrice) {
		return npcWalletBalance > itemPrice;
	}
	
	public int existItem (int itemID) {
		int itemIndex = -1;
		int i = 0;

		while (itemIndex==-1 && npcItemsBag.size() != i) {
			if (npcItemsBag.get(i).getItemID() == (itemID)) {
				itemIndex = i;
			}else {
				itemIndex = -1;
				i++;		
			}
		}
		
		return itemIndex;
	}
	
	@Override
	public String toString() {
		return "NPC [npcName=" + npcName + ", npcLocation=" + npcLocation + ", npcWalletBalance=" + npcWalletBalance
				+ ", npcItemsBag=" + npcItemsBag + "]";
	}

}
