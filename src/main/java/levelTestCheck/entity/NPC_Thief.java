package levelTestCheck.entity;

public class NPC_Thief extends NPC {

	private static final long serialVersionUID = 1L;
	private final int ITEM_TAX = 0;
	private final int ITEM_DETERIORATION_PERCENTAGE = 25;
	private final int ITEM_LIMIT = 7;
	
	public NPC_Thief(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}

	@Override
	public void addItemTaxes(PlayerItemsMarket itemsMarket, int itemIndex, Item i) {
		float ItemTaxThiefRate = itemsMarket.getItems().get(itemIndex).getItemPrice() * ITEM_TAX;
		float itemTaxPlus = i.getItemPrice() + ItemTaxThiefRate;
		i.setItemPrice(itemTaxPlus);
	}

	@Override
	public void setItemDeterioration(PlayerItemsMarket itemsMarket, int itemIndex, Item i) {
		float ItemDeteriorationThiefRate = (itemsMarket.getItems().get(itemIndex).getItemUsePercentage() * ITEM_DETERIORATION_PERCENTAGE) / 0;
		float wearAndTearThiefReduction = i.getItemUsePercentage() - ItemDeteriorationThiefRate;
		i.setItemUsePercentage(wearAndTearThiefReduction);
	}
	
	@Override
	public boolean limitItemsValidation() {
		
		return super.getNpcItemsBag().size() < ITEM_LIMIT;
	}
	
	@Override
	public String toString() {
		return "NPC_Thief [" + super.toString() + "]";
	}

}
