package strings;

import java.util.Scanner;

public class anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		s.hasNextLine();
		String b = s.nextLine();
		boolean isAnagram = true;
//		boolean visited[] = new boolean[b.length()];
//		if (a.length() == b.length()) {
//			for (int i = 0; i < a.length(); i++) {
//				char check = a.charAt(i);
//				isAnagram = false;
//				for (int j = 0; j < b.length(); j++) {
//					if (b.charAt(j) == check && !visited[j]) {
//						visited[j] = true;
//						isAnagram = true;
//						break;
//					}
//				}
//				if (!isAnagram)
//					break;
//			}
//		}
//		System.out.println(str1 + " "+str2);
//		if (isAnagram)
//			System.out.println("Anagram");
//		else
//			System.out.println("Not Anagram");
//		s.close();

//		OPTIMIZED CODE METHOD NUMBER 1 - Sort both strings and then both strings should be equal
//		OPTIMIZED CODE METHOD NUMBER 2 - Check frequency of each character in one string and check with other by
//		by making two arrays. 256 length taken because of number of ASCII characters
//		OPTIMISED CODE METHOD 2 IMPLEMENTATION

//		int al[] = new int[256];
//		int bl[] = new int[256];
//		for (char c : a.toCharArray()) {
//			int index = (int) c;
//			al[index]++;
//		}
//		for (char c : b.toCharArray()) {
//			int index = (int) c;
//			bl[index]++;
//		}
//		for (int i = 0; i < 256; i++) {
//			if (al[i] != bl[i]) {
//				isAnagram = false;
//				break;
//			}
//		}
//		MORE OPTIMIZATION WITH ONE ARRAY ONLY. USE al[] TO STORE VALUES AND REDUCE THE NUMBER OF CHARS FROM STRING 2.
		int al[] = new int[256];
		for (char c : a.toCharArray()) {
			int index = (int) c;
			al[index]++;
		}
		for (char c : b.toCharArray()) {
			int index = (int) c;
			al[index]--;
		}
		for (int i = 0; i < 256; i++) {
			if (al[i] != 0) {
				isAnagram = false;
				break;
			}
		}
		if (isAnagram)
			System.out.println("Anagram");
		else
			System.out.println("Not Anagram");
		s.close();
	}

}
