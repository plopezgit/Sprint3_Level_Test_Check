package levelTestCheck.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC {
	
	private String npcName;
	private String npcLocation;
	private List<Item> npcItemsBag;

	public NPC(String npcName, String npcLocation) {
		this.npcName = npcName;
		this.npcLocation = npcLocation;
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
		
		processBalanceToBuyTransferenceSimulation(itemsMarket, itemIndex);
		processItemToBuyTranspassSimulation(itemsMarket, itemIndex);

		addItemTaxes(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
		setItemDeterioration(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
								
		return getNpcItemsBag();
	}
	
	public List<Item> sellItem(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		processBalanceToSellTransferenceSimulation(itemsMarket, itemIndex);
		processItemToSellTranspassSimulation(itemsMarket, itemIndex);
					
		return getNpcItemsBag();
	}
	
	public void processBalanceToBuyTransferenceSimulation(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		itemsMarket.incrementMarketBalance(itemsMarket.getItems().get(itemIndex).getItemPrice());
		
	}
	
	public void processItemToBuyTranspassSimulation(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		getNpcItemsBag().add(itemsMarket.getItems().get(itemIndex));
		
	}
	
	public void processOwnerKeySignToBuyTransferSimulation(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		itemsMarket.getItems().get(itemIndex).setItemOwnerKey(this.hashCode());
	}
	
	public void processBalanceToSellTransferenceSimulation(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		itemsMarket.reduceMarketBalance(npcItemsBag.get(itemIndex).getItemPrice());
		
	}
	
	public void processItemToSellTranspassSimulation (PlayerItemsMarket itemsMarket, int itemIndex) {
		
		itemsMarket.addItems(npcItemsBag.get(itemIndex));
		npcItemsBag.remove(itemIndex);
		
	}
	
	public void processOwnerKeySignToSellTransferSimulation(PlayerItemsMarket itemsMarket, int itemIndex) {
		
		itemsMarket.getItems().get(itemsMarket.getItems().size()-1).setItemOwnerKey(itemsMarket.hashCode());
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
		return "NPC [npcName=" + npcName + ", npcLocation=" + npcLocation + ", npcWalletBalance="
				+ ", npcItemsBag=" + npcItemsBag + "]";
	}

}
