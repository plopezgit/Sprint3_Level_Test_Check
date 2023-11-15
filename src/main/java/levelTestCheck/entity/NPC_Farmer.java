package levelTestCheck.entity;

public class NPC_Farmer extends NPC {

	private static final long serialVersionUID = 1L;

	public NPC_Farmer(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}

	@Override
	public void addItemTaxes(Item i) {
		final float ITEM_TAX_FARMER_RATE = (i.getItemPrice() * 2) / 100;
		float itemTaxPlus = i.getItemPrice() - ITEM_TAX_FARMER_RATE;
		i.setItemPrice(itemTaxPlus);
	}

}
