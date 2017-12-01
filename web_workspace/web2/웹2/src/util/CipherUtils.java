package util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class CipherUtils {

	public static String encrypt(String key, String plainText) {
		try{
			//암호화 키 생성
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			//지정된 암호화방식으로 암복호화를 수행하는 cipher 객체 생성
			Cipher cipher = Cipher.getInstance("AES");
			// cipher객체 초기화
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			//복호화 수행
			byte[] encrypted = cipher.doFinal(plainText.getBytes());
	
			return Hex.encodeHexString(encrypted);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String decrypt(String key, String cipherText){
		try{
			//암호화 키 생성
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			// 지정된 암호화방식으로 암복호화를 수행하는 cipher 객체 생성
			Cipher cipher = Cipher.getInstance("AES");
			// cipher 객체 초기화
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			// 복호호화 수행
			byte[] encrypted = cipher.doFinal(Hex.decodeHex(cipherText.toCharArray()));
	
			return new String(encrypted);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String text = "hello, java";
		 
		
		String cipherText = CipherUtils.encrypt("zxcv1234zxcv1234", text);
		System.out.println(cipherText);
		String plainText = CipherUtils.decrypt("zxcv1234zxcv1234", cipherText);
		System.out.println(plainText);
	}
}
