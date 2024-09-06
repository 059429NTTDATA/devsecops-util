package ntt.devsecops.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FunctionUtil {

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String nullToEmpty(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	public static String getMD5Hash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomAZ09() {
		Random random = new Random();
		int randomNumber = random.nextInt(36);
		String randomString;
		if (randomNumber < 10) {
			randomString = String.valueOf(randomNumber);
		} else {
			char randomChar = (char) (randomNumber + 55);
			randomString = String.valueOf(randomChar);
		}
		return randomString;
	}

	public static char getRandomChar() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int randomType = random.nextInt(3); // 0 for lowercase, 1 for uppercase, 2 for digit

		switch (randomType) {
		case 0:
			return (char) random.nextInt('a', 'z' + 1);
		case 1:
			return (char) random.nextInt('A', 'Z' + 1);
		case 2:
			return (char) random.nextInt('0', '9' + 1);
		default:
			throw new IllegalStateException("Invalid random type");
		}
	}

	public static String generateRandomString(int strLength) {
		String allowCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		StringBuilder sb = new StringBuilder(strLength);
		Random random = new Random();

		for (int i = 0; i < strLength; i++) {
			int randomIndex = random.nextInt(allowCharacters.length());
			char randomChar = allowCharacters.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}
}
