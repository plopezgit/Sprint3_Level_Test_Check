package levelTestCheck.entity;

public class NPC_Thief extends NPC {

	private static final long serialVersionUID = 1L;
	

	public NPC_Thief(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}

	@Override
	public void addItemTaxes(Item i) {
		final float ITEM_TAX_THIEF_RATE = i.getItemPrice() * 0;
		float itemTaxPlus = i.getItemPrice() - ITEM_TAX_THIEF_RATE;
		i.setItemPrice(itemTaxPlus);
	}

}
