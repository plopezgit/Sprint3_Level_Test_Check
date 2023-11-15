package levelTestCheck.entity;

import java.util.HashMap;
import java.util.Map;

import levelTestCheck.tool.Input;



public class NPCRolGameAdmin {
	
	private Map<Integer, NPC> characters;

	public NPCRolGameAdmin() {
		characters = new HashMap<>();
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
				System.out.println("OrderListAndFilter functional interface by lamda expression");
				break;
			case 2:
				System.out.println("OrderMapAndFilter functional interface by lamda expression");
				break;
			case 3:
				System.out.println("OrderListAndFilter functional interface by lamda expression");
				break;
			case 4:
				System.out.println("OrderListAndFilter functional interface by lamda expression");
				break;
			case 5:
				System.out.println("Sorry. No time to simulate");
				break;
			case 6:
				System.out.println("Sorry. No time to simulate");
				break;
			case 7:
				characters.get(Input.inputInt("Character key: ")).serializeDirectoryToFile();;
				break;
			case 8:
				System.out.println("Bye");
				break;
			default:
				System.out.println("No available option.\n");

			}
		} while (opcionMain != 8);

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
