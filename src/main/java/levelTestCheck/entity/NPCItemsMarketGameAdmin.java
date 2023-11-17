package levelTestCheck.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import levelTestCheck.tool.Input;

public class NPCItemsMarketGameAdmin {
	
	private Map<Integer, NPC> characters;
	private ItemsMarket itemsMarket;

	public NPCItemsMarketGameAdmin() {
		characters = new HashMap<>();
		itemsMarket = new ItemsMarket();
		fullfilInitialNPCDataBaseExample();		
	}

	public void menu() {
		String mainMenu = "NPC Admin console v1.\n" + "(1)Get items bag by character.\n" + "(2)Get character list by Location.\n"
				+ "(3)Get cheapest item by Location.\n" + "(4)Get item by price.\n" + "(5)Buy an item.\n"
				+ "(6)Sale an item.\n" + "(7)Save a charcater to file.\n"
				+ "(8)Exit.\n";
		
		int opcionMain = 0;

		do {
			switch (opcionMain = Input.inputInt("\n" + mainMenu)) {
			case 1:
				characters.get(Input.inputInt("Character key: 1-6")).getNpcItemsBag().forEach(System.out::println);
				break;
			case 2:
				String city = Input.inputString("City: ");
				characters.entrySet().stream().filter(npc -> npc.getValue().getNpcLocation().equalsIgnoreCase(city))
					.collect(Collectors.toList()).forEach(System.out::println);
				break;
			case 3:
				System.out.println("OrderListAndFilter functional interface method implementation by lamda expression.");
				break;
			case 4:
				System.out.println("OrderListAndFilter functional interface method implementation by lamda expression.");
				break;
			case 5:
				buyMarketItem(Input.inputInt("Character key: 1-6"), Input.inputInt("Item id: "));
				break;
			case 6:
				System.out.println("Sorry. No time to simulate.");
				break;
			case 7:
				characters.get(Input.inputInt("Character key: 1-6")).serializeNPCToFile();;
				break;
			case 8:
				System.out.println("Bye, bye.");
				break;
			default:
				System.out.println("No available option.\n");

			}
		} while (opcionMain != 8);

	}
	
	public String buyMarketItem (int npcKey, int itemId) {
		String result;
		if (isValidSale(itemsMarket.existItem(itemId), npcKey)) {
			characters.get(npcKey).buyItem(itemsMarket, itemsMarket.existItem(itemId));
			result = "Compra exitosa";
		} else {
			result = "No es posible la transaccion";
		}
		
		return result;
	}
	
	public boolean isValidSale (int indexItem, int npcKey) {
		return itemsMarket.getItems().get(indexItem).existStockItem() && 
					characters.get(npcKey).enoughBalance(indexItem);	
	}
	
	public void fullfilInitialNPCDataBaseExample() {
		characters.put(1, new NPC_Farmer("Paul", "Hual"));
		characters.put(2, new NPC_Farmer("Phol", "Jul"));
		characters.put(3, new NPC_Thief("Kill", "Hual"));
		characters.put(4, new NPC_Thief("Bill", "Jul"));
		characters.put(5, new NPC_Merchant("Jaime", "Hual"));
		characters.put(6, new NPC_Merchant("Gamlo", "Jul"));
	}

}
