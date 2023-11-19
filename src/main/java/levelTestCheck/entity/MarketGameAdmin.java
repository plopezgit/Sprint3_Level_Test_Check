package levelTestCheck.entity;

import java.util.stream.Collectors;
import levelTestCheck.tool.CharactersBackup;
import levelTestCheck.tool.Input;

public class MarketGameAdmin {

	private PlayerItemsMarket itemsMarket;
	private CharactersBackup charactesBackup;

	public MarketGameAdmin() {
		itemsMarket = new PlayerItemsMarket();
		charactesBackup = new CharactersBackup();
	}

	public void menu() {
		String mainMenu = "NPC Admin console v1.\n" + "(1)Get items bag by character.\n"
				+ "(2)Get character list by Location.\n" + "(3)Get cheapest item by Location.\n"
				+ "(4)Get item by price.\n" + "(5)Buy an item.\n" + "(6)Sell an item.\n"
				+ "(7)Save a characters to file.\n" + "(8)Exit.\n";

		int opcionMain = 0;

		do {
			switch (opcionMain = Input.inputInt("\n" + mainMenu)) {
			case 1:
				itemsMarket.getCharacters().get(Input.inputInt("Character key: 1-6")).getNpcItemsBag().forEach(System.out::println);
				break;
			case 2:
				String city = Input.inputString("City: ");
				itemsMarket.getCharacters().entrySet().stream().filter(npc -> npc.getValue().getNpcLocation().equalsIgnoreCase(city))
						.collect(Collectors.toList()).forEach(System.out::println);
				break;
			case 3:
				System.out
						.println("OrderListAndFilter functional interface method implementation by lamda expression.");
				break;
			case 4:
				System.out
						.println("OrderListAndFilter functional interface method implementation by lamda expression.");
				break;
			case 5:
				int npcKey = Input.inputInt("Character key: 1-6");
				itemsMarket.sellItem(npcKey, itemsMarket.getCharacters().get(npcKey).existItem(Input.inputInt("Item id: ")));
				break;
			case 6:
				itemsMarket.buyItem(Input.inputInt("Character key: 1-6"), itemsMarket.existItem(Input.inputInt("Item id: ")));
				break;
			case 7:
				charactesBackup.backupNpcListToFile(itemsMarket.getCharacters());
				break;
			case 8:
				System.out.println("Bye, bye.");
				break;
			default:
				System.out.println("No available option.\n");

			}
		} while (opcionMain != 8);

	}

}
