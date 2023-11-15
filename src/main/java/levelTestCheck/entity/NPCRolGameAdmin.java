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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
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
		characters.put(1, null);
		characters.put(2, null);
		characters.put(3, null);
		characters.put(4, null);
		characters.put(5, null);
		characters.put(6, null);
	}

}
