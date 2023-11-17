package levelTestCheck.entity;

public class NPC_Thief extends NPC {

	private static final long serialVersionUID = 1L;
	
	public NPC_Thief(String npcName, String npcLocation) {
		super(npcName, npcLocation);
	}

	@Override
	public void addItemTaxes(ItemsMarket itemsMarket, int itemIndex, Item i) {
		final float ITEM_TAX_THIEF_RATE = itemsMarket.getItems().get(itemIndex).getItemPrice() * 0;
		float itemTaxPlus = i.getItemPrice() + ITEM_TAX_THIEF_RATE;
		i.setItemPrice(itemTaxPlus);
	}

	@Override
	public void setItemDeterioration(ItemsMarket itemsMarket, int itemIndex, Item i) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "NPC_Thief [" + super.toString() + "]";
	}

}
