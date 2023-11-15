package levelTestCheck.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	private final String FILE_NOT_FOUND_MSG = "NPC destiny file not found";
	
	
	public NPC(String npcName, String npcLocation) {
		this.npcName = npcName;
		this.npcLocation = npcLocation;
		npcItemsBag = new ArrayList<>();
		properties = new Properties();
		loadDirectoryNPCPropertiesFile();
		encrypter = new AESCypher();
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
	
	public void serializeNPCToFile() {
		try (FileOutputStream fileOutputStream = new FileOutputStream(properties.getProperty("fileSerPath"));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

			String npcObject = encrypter.encrypt(this.toString(), properties.getProperty("encryptionKey"));
			objectOutputStream.writeObject(npcObject);
			
			desSeriaizeNPCFromFileToObject();

		} catch (IOException e) {
			System.err.println(FILE_NOT_FOUND_MSG);
		}
	}
	
	public void desSeriaizeNPCFromFileToObject() {
		try (FileInputStream fileOutputStream = new FileInputStream(properties.getProperty("fileSerPath"));
				ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream)) {

			String desencryptedNpcObject = encrypter.desencrypt(objectInputStream.readObject().toString(),
					properties.getProperty("encryptionKey"));

			System.out.println(desencryptedNpcObject);

		} catch (IOException | ClassNotFoundException e) {
			System.err.println(FILE_NOT_FOUND_MSG);
		}
	}
	
	private void loadDirectoryNPCPropertiesFile() {
		try (FileReader reader = new FileReader("file.properties")){
			properties.load(reader);
		} catch (IOException e) {
			System.err.println(FILE_NOT_FOUND_MSG);
		}
	}
	
	public void fullfilInitialNpcItemsBagDataBaseExample() {
		npcItemsBag.add(new Item("Knive", "Army", 20.0F));
		npcItemsBag.add(new Item("Cup", "Instrument", 10.0F));
		npcItemsBag.add(new Item("Map", "Instrument", 30.0F));
		npcItemsBag.add(new Item("Knive", "Instrument", 20.0F));
	}

	@Override
	public String toString() {
		return "NPC [npcName=" + npcName + ", npcLocation=" + npcLocation + ", npcItemsBag=" + npcItemsBag + "]";
	}
	
	

}
