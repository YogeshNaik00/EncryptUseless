package com.sangamone;

import java.util.Scanner;
public class EncryptUseless {
	String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+=/|{}[]:;',?.`~0123456789";

	String check[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
			"35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51",
			"52", /* Alphabets ends */
			"53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
			"71", "72", "73", "74", "75", "76", "77", "78","79","80", /* special char ends */
			"81", "82", "83", "84", "85", "86", "87", "88", "89", "90", /* Number Ends */ };
	int len = alphabets.length();

	public String encrypt(String useless, int offset) {
		String useless1 = useless;
		int offset1 = offset;

		String afterOffset = "";
		String afterStringToInt = "";
		for (int i = 0; i < useless1.length(); i++) {
			char temp = useless1.charAt(i);
			int oldPosition = alphabets.indexOf(temp);
			int newPosition = (oldPosition + offset1) % len;
			temp = alphabets.charAt(newPosition);
			afterOffset += temp;
		}

		for (int j = 0; j < afterOffset.length(); j++) {
			char temp1 = afterOffset.charAt(j);
			int stringPos = alphabets.indexOf(temp1);
			String temp11 = check[stringPos];
			afterStringToInt += temp11;
		}
		System.out.println("Hash process----> " +useless1+" ---> "+afterOffset+" ---> "+afterStringToInt);
		
		return afterStringToInt;
	}

	public String decrypt(String useless, int offset) {
		String intToString = useless;
		String position = "";
		int charIndex = 1;
		String beforeOffset = "";
		String afterOffset = "";
		for (int i = 0; i < intToString.length(); i++) {
			char temp = intToString.charAt(i);
			position += temp;
			if (i == charIndex) {
				int a1 = Integer.parseInt(position);
				int b1 = a1 - 1;
				char temp1 = alphabets.charAt(b1);
				beforeOffset += temp1;
				charIndex += 2;
				position = "";
			}
		}
		for (int j = 0; j < beforeOffset.length(); j++) {
			char temp = beforeOffset.charAt(j);
			int oldPosition = alphabets.indexOf(temp);
			int newPosition = (oldPosition - offset) % len;
			if (newPosition < 0) {
				newPosition = (len + (newPosition)) % len;
			}
			temp = alphabets.charAt(newPosition);
			afterOffset += temp;
		}
		System.out.println("Hash process----> " + intToString+" ---> "+beforeOffset+" ---> "+afterOffset);
		
		return afterOffset;
	}

	public static void main(String[] args) {
		EncryptUseless eu = new EncryptUseless();
		for(int i=0;i<(i+1);i++) {
			
	    Scanner sc = new Scanner(System.in); 
	  
	    System.out.println(" Enter password ");

	    String userName = sc.nextLine();
		int offset = 19;
		System.out.println("****** Encoding ******");
		String encrypt = eu.encrypt(userName, offset);
		System.out.println("");
		System.out.println("");
		System.out.println("****** Decoding ******");
		String decrypt = eu.decrypt(encrypt, offset);
		  System.out.println("");
		  System.out.println("");
		
		}
	}

}
