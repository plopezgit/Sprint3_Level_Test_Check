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

import levelTestCheck.exception.ErrorMessage;
import levelTestCheck.tool.AESCypher;

public abstract class NPC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String npcName;
	private String npcLocation;
	private float npcWalletBalance;
	private List<Item> npcItemsBag;
	private Properties properties;
	AESCypher encrypter;
	
	public NPC(String npcName, String npcLocation) {
		this.npcName = npcName;
		this.npcLocation = npcLocation;
		npcWalletBalance = 500;
		npcItemsBag = new ArrayList<>();
		properties = new Properties();
		loadDirectoryNPCPropertiesFile();
		encrypter = new AESCypher();
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
	
	public float getNpcWalletBalance() {
		return npcWalletBalance;
	}

	public void setNpcWalletBalance(float npcWalletBalance) {
		this.npcWalletBalance = npcWalletBalance;
	}
	
	public boolean enoughBalance (int itemPrice) {
		return npcWalletBalance > itemPrice;
	}

	public abstract void addItemTaxes(PlayerItemsMarket itemsMarket, int itemIndex, Item i);	
	
	public abstract void setItemDeterioration(PlayerItemsMarket itemsMarket, int itemIndex, Item i);
	
	public abstract boolean limitItemsValidation();
	
	public List<Item> buyItem(PlayerItemsMarket itemsMarket, int itemIndex) {
		try {
			reduceNPCWalletBalance((float) itemsMarket.getItems().get(itemIndex).getItemPrice());
			itemsMarket.incrementMarketBalance(itemsMarket.getItems().get(itemIndex).getItemPrice());
		} catch (IndexOutOfBoundsException e) {
			System.err.println(ErrorMessage.getItemDoesNotExistMessage());
		} 
			getNpcItemsBag().add(itemsMarket.getItems().get(itemIndex));
				itemsMarket.getItems().get(itemIndex).reduceStockItem();
					itemsMarket.getItems().get(itemIndex).setItemOwnerKey(this.hashCode());
						addItemTaxes(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
							setItemDeterioration(itemsMarket, itemIndex, npcItemsBag.get(npcItemsBag.size()-1));
								npcItemsBag.get(npcItemsBag.size()-1).setItemStock(1);
								
		return getNpcItemsBag();
	}
	
	public List<Item> saleItem(PlayerItemsMarket itemsMarket, int itemIndex) {
		try {
			incrementNPCWalletBalance((float) npcItemsBag.get(itemIndex).getItemPrice());
			itemsMarket.reduceMarketBalance(npcItemsBag.get(itemIndex).getItemPrice());
		} catch (IndexOutOfBoundsException e) {
			System.err.println(ErrorMessage.getItemDoesNotExistMessage());
		} 
			itemsMarket.getItems().add(npcItemsBag.get(itemIndex));
				npcItemsBag.remove(itemIndex);
					itemsMarket.getItems().get(itemsMarket.getItems().size()-1).setItemOwnerKey(itemsMarket.hashCode());
					
		return getNpcItemsBag();
	}
	
	
	public float reduceNPCWalletBalance (float totalTransacction) {
		npcWalletBalance = npcWalletBalance - totalTransacction;
		return npcWalletBalance;
	}
	
	public float incrementNPCWalletBalance (float totalTransacction) {
		npcWalletBalance = npcWalletBalance + totalTransacction;
		return npcWalletBalance;
	}
	
	public int existItem (int itemID) {
		int itemIndex = -1;
		int i = 0;

		while (itemIndex==-1 && npcItemsBag.size() != i) {
			if (npcItemsBag.get(i).getItemID() == (itemID)) {
				itemIndex = i;
			}else {
				itemIndex = -1;
				i++;		
			}
		}
		
		return itemIndex;
	}
	
	public void serializeNPCToFile() {
		try (FileOutputStream fileOutputStream = new FileOutputStream(properties.getProperty("fileSerPath"));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

			String npcObject = encrypter.encrypt(this.toString(), properties.getProperty("encryptionKey"));
			objectOutputStream.writeObject(npcObject);
			
			desSeriaizeNPCFromFileToObject();

		} catch (IOException e) {
			System.err.println(ErrorMessage.getFileNotFoundMessage());
		}
	}
	
	public void desSeriaizeNPCFromFileToObject() {
		try (FileInputStream fileOutputStream = new FileInputStream(properties.getProperty("fileSerPath"));
				ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream)) {

			String desencryptedNpcObject = encrypter.desencrypt(objectInputStream.readObject().toString(),
					properties.getProperty("encryptionKey"));

			System.out.println(desencryptedNpcObject);

		} catch (IOException | ClassNotFoundException e) {
			System.err.println(ErrorMessage.getFileNotFoundMessage());
		}
	}
	
	private void loadDirectoryNPCPropertiesFile() {
		try (FileReader reader = new FileReader("file.properties")){
			properties.load(reader);
		} catch (IOException e) {
			System.err.println(ErrorMessage.getFileNotFoundMessage());
		}
	}

	@Override
	public String toString() {
		return "NPC [npcName=" + npcName + ", npcLocation=" + npcLocation + ", npcWalletBalance=" + npcWalletBalance
				+ ", npcItemsBag=" + npcItemsBag + "]";
	}

}
