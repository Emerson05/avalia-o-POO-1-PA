package avaliacao;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Criptografia {
	
	public static String encriptografar(String senha) {
		 senha = "";
		
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			SecretKey secretkey = keyGenerator.generateKey();
			Cipher cipher;
			cipher = Cipher.getInstance("AES");
			cipher.init(cipher.ENCRYPT_MODE,secretkey);
			byte[] criptrogafia = cipher.doFinal(senha.getBytes());
			System.out.println("Senha criptografada: " +criptrogafia);
		}
		
		catch(Exception e) {
			
		}
		
		
		return senha;
	}
	
	
}
