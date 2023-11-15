package levelTestCheck.entity;

public class NPC_Merchant extends NPC {

	private static final long serialVersionUID = 1L;

	public NPC_Merchant(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}

	@Override
	public void addItemTaxes(Item i) {
		final float ITEM_TAX_MERCHANT_RATE = (i.getItemPrice() * 4) / 100;
		float itemTaxPlus = i.getItemPrice() - ITEM_TAX_MERCHANT_RATE;
		i.setItemPrice(itemTaxPlus);
	}

}
