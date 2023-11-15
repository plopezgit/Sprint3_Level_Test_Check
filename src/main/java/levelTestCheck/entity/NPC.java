package levelTestCheck.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import levelTestCheck.tool.AESCypher;

public abstract class NPC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String npcName;
	private String npcLocation;
	private List<Item> npcItemsBag;
	private Properties properties;
	AESCypher encrypter;
	private final String NPC_DESTINY_FILE_NOT_FOUND_MSG = "NPC destiny file not found";
	
	
	public NPC(String npcName, String npcLocation) {
		this.npcName = npcName;
		this.npcLocation = npcLocation;
		properties = new Properties();
		npcItemsBag = new ArrayList<>();
		fullfilInitialNpcItemsBagDataBaseExample();
	}
	
	public String getNpcName() {
		return npcName;
	}

	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}

	public List<Item> getNpcItemsBag() {
		return npcItemsBag;
	}

	public void setNpcItemsBag(List<Item> npcItemsBag) {
		this.npcItemsBag = npcItemsBag;
	}
	

	public String getNpcLocation() {
		return npcLocation;
	}

	public void setNpcLocation(String npcLocation) {
		this.npcLocation = npcLocation;
	}

	public abstract void addItemTaxes(Item i);
	
	public void serializeDirectoryToFile() {
		try (FileOutputStream fileOutputStream = new FileOutputStream(properties.getProperty("fileSerPath"));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

			String npcObject = encrypter.encrypt(this.toString(), properties.getProperty("encryptionKey"));
			objectOutputStream.writeObject(npcObject);

		} catch (IOException e) {
			System.err.println(NPC_DESTINY_FILE_NOT_FOUND_MSG);
		}
	}
	
	public void fullfilInitialNpcItemsBagDataBaseExample() {
		npcItemsBag.add(new Item("Knive", "Army", 20.0F));
		npcItemsBag.add(new Item("Cup", "Instrument", 10.0F));
		npcItemsBag.add(new Item("Map", "Instrument", 30.0F));
		npcItemsBag.add(new Item("Knive", "Instrument", 20.0F));
	}

}
