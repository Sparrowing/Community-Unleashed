package bwphackstl17.smartneighborhood.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Helpers {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	/*
	 * Hash using BCrypt
	 * @param   stringToHash  String to be hashed
	 * @return  String        Hashed version of stringToHash
	 */
	public static String bcryptHash(String stringToHash) {
		return encoder.encode(stringToHash);
	}

}
