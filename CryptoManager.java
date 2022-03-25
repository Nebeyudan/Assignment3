

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//Initial variable
		boolean TF = true;
		//loop for the length of plain text
		for(int i=0; i<plainText.length();i++) {
			// if statement to check if it is between lower bound and upper bound
			if((plainText.charAt(i)>=LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND)) {
				// the return statement of it is
				TF = true;
			}
			else {
				// the return statment if it isn't
				TF= false;
				return TF;
			}
			
		}
		return TF;
	}
	

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//Initial string
		String k= "" ;	
			//loop to for the size of plain text
			for(int i =0; i< plainText.length();i++) {
				// create int K to create a cast of plainTxt then add the key 
				int K = (int)plainText.charAt(i)+key;
				// check if it is within range
					while(K>UPPER_BOUND) {
						K-= RANGE;
					}
				// considered in the for loop so after K is save as a number
				// it is converter back into a char so it can be add onto
				// k as a String(big K is an int, little k is a String)
				k+=(char)K;
			}	
			
		
			return k;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//Initial String and int
		String result="";
		int c=0;
		//loop for the length of text
		for(int i =0; i < plainText.length(); i++) {
			//create in and make a cast of int for both plain text and bellasoStr and add them
			int b= (int)plainText.charAt(i)+ (int)bellasoStr.charAt(i);
			//check range
			while(b>UPPER_BOUND) {
				b-= RANGE;
			}
			//after range is verified constantly add to result for each loop
			result +=(char)b;
			
		
		//this is just in case the key runs out.
		bellasoStr+=bellasoStr;
		}
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//Initial string
				String k= "" ;
				// check if it is in bounds
				
					//loop to for the size of plain text
					for(int i =0; i< encryptedText.length();i++) {
						// create int K to create a cast of plainTxt then add the key(DIFFERENCE FROM
						//ENCRYPTION IS SUBTRACT RATHER THAN ADD)
						int K = (int)encryptedText.charAt(i)-key;
						// check if it is within range(DIFFERENCE IS CHECKS IN LOWER BOUND)
							while(K<LOWER_BOUND) {
								K+= RANGE;
							}
						// considered in the for loop so after K is save as a number
						// it is converter back into a char so it can be add onto
						// k as a String(big K is an int, little k is a String)
						k+=(char)K;
					}	
					
				
					return k;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//Initial String and int
				String result="";
				int c=0;
				//loop for the length of text
				for(int i =0; i < encryptedText.length(); i++) {
					//create in and make a cast of int for both plain text and bellasoStr and add them
					//(DIFFERENCE IS SUBTRACT INSTEAD OF ADD)
					int b= (int)encryptedText.charAt(i)- (int)bellasoStr.charAt(i);
					//check range(DIFFERENCE IS CHECK FOR LOWER)
					while(b<LOWER_BOUND) {
						b+= RANGE;
					}
					//after range is verified constantly add to result for each loop
					result +=(char)b;
					
				
				//this is just in case the key runs out.
				bellasoStr+=bellasoStr;
				}
				return result;
	}
}