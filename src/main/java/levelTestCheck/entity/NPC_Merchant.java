package levelTestCheck.entity;

public class NPC_Merchant extends NPC {

	private static final long serialVersionUID = 1L;
	private final int ITEM_TAX = 4;
	private final int ITEM_DETERIORATION_PERCENTAGE = 0;
	private final int ITEM_LIMIT = 7;


	public NPC_Merchant(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}
	
	public void addItemTaxes(PlayerItemsMarket itemsMarket, int itemIndex, Item i) {
		float ItemTaxMerchantRate = (itemsMarket.getItems().get(itemIndex).getItemPrice() * ITEM_TAX) / 100;
		float itemTaxPlus = i.getItemPrice() + ItemTaxMerchantRate;
		i.setItemPrice(itemTaxPlus);
	}
	
	@Override
	public void setItemDeterioration(PlayerItemsMarket itemsMarket, int itemIndex, Item i) {
		float ItemDeteriorationThiefRate = (itemsMarket.getItems().get(itemIndex).getItemUsePercentage() * ITEM_DETERIORATION_PERCENTAGE) / 0;
		float wearAndTearMerchantReduction = i.getItemUsePercentage() - ItemDeteriorationThiefRate;
		i.setItemUsePercentage(wearAndTearMerchantReduction);
	}
	
	@Override
	public boolean limitItemsValidation() {
		
		return super.getNpcItemsBag().size() < ITEM_LIMIT;
	}
	
	@Override
	public String toString() {
		return "NPC_Merchant [" + super.toString() + "]";
	}

}
