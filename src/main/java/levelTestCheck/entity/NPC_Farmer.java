package levelTestCheck.entity;

public class NPC_Farmer extends NPC {

	private static final long serialVersionUID = 1L;
	private final int ITEM_TAX = 2;
	private final int ITEM_DETERIORATION_PERCENTAGE = 15;
	
	public NPC_Farmer(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}
	
	@Override
	public void addItemTaxes(ItemsMarket itemsMarket, int itemIndex, Item i) {
		float ItemTaxFarmerRate = (itemsMarket.getItems().get(itemIndex).getItemPrice() * ITEM_TAX) / 100;
		float itemTaxPlus = i.getItemPrice() + ItemTaxFarmerRate;
		i.setItemPrice(itemTaxPlus);
	}
	
	@Override
	public void setItemDeterioration(ItemsMarket itemsMarket, int itemIndex, Item i) {
		final float ItemDeteriorationFarmerRate = (itemsMarket.getItems().get(itemIndex).getItemUsePercentage() * ITEM_DETERIORATION_PERCENTAGE) / 100;
		float wearAndTearFarmerReduction = i.getItemUsePercentage() - ItemDeteriorationFarmerRate;
		i.setItemUsePercentage(wearAndTearFarmerReduction);
	}

	@Override
	public String toString() {
		return "NPC_Farmer [" + super.toString() + "]";
	}

}
