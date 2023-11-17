package levelTestCheck.entity;

public class NPC_Farmer extends NPC {

	private static final long serialVersionUID = 1L;
	
	public NPC_Farmer(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}
	
	@Override
	public void addItemTaxes(ItemsMarket itemsMarket, int itemIndex, Item i) {
		final float ITEM_TAX_FARMER_RATE = (itemsMarket.getItems().get(itemIndex).getItemPrice() * 2) / 100;
		float itemTaxPlus = i.getItemPrice() + ITEM_TAX_FARMER_RATE;
		i.setItemPrice(itemTaxPlus);
	}
	
	@Override
	public void setItemDeterioration(ItemsMarket itemsMarket, int itemIndex, Item i) {
		final float ITEM_DETERIORATION_FARMER_RATE = (itemsMarket.getItems().get(itemIndex).getItemUsePercentage() * 15) / 100;
		float wearAndTearFarmerReduction = i.getItemUsePercentage() - ITEM_DETERIORATION_FARMER_RATE;
		i.setItemUsePercentage(wearAndTearFarmerReduction);
	}

	@Override
	public String toString() {
		return "NPC_Farmer [" + super.toString() + "]";
	}

}
