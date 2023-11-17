package levelTestCheck.entity;

public class NPC_Merchant extends NPC {

	private static final long serialVersionUID = 1L;

	public NPC_Merchant(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}
	
	public void addItemTaxes(ItemsMarket itemsMarket, int itemIndex, Item i) {
		final float ITEM_TAX_MERCHANT_RATE = (itemsMarket.getItems().get(itemIndex).getItemPrice() * 4) / 100;
		float itemTaxPlus = i.getItemPrice() + ITEM_TAX_MERCHANT_RATE;
		i.setItemPrice(itemTaxPlus);
	}
	
	@Override
	public void setItemDeterioration(ItemsMarket itemsMarket, int itemIndex, Item i) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "NPC_Merchant [" + super.toString() + "]";
	}

}
