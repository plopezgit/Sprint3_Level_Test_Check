package levelTestCheck.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

import levelTestCheck.entity.NPC;
import levelTestCheck.exception.ErrorMessage;

public class CharactersBackup {
	
	private Properties properties;
	private AESCypher encrypter;
	
	public CharactersBackup() {
		properties = new Properties();
		loadDirectoryNPCPropertiesFile();
		encrypter = new AESCypher();
		
	}
	
	public void serializeNPCListToFile(Map<Integer, NPC> characters) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(properties.getProperty("fileSerPath"));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

			String npcList = encrypter.encrypt(characters.toString(), properties.getProperty("encryptionKey"));
			objectOutputStream.writeObject(npcList);
			
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

}
