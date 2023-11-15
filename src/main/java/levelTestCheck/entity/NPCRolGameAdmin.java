package levelTestCheck.entity;

import java.util.HashMap;
import java.util.Map;


public class NPCRolGameAdmin {
	
	private Map<Integer, NPC> characters;

	public NPCRolGameAdmin() {
		characters = new HashMap<>();
		fullfilInitialNPCDataBaseExample();		
	}

	public void menu() {
	//Menu While loop
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
