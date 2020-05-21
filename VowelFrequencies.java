package myalgs4;

import algs4.StdIn;
import algs4.StdOut;

public class VowelFrequencies {

	public static void main(String[] args) {
		AVLTreeST<String, AVLTreeST<Character, Integer>> frequencies = new AVLTreeST<>();
		AVLTreeST<String, Integer> textLengths = new AVLTreeST<>();
		String[] textFilenames = {"data/tale.txt", "data/warandpeace.txt", "data/voyageofthebeagle.txt"};
		
		for (String filename: textFilenames) {
			StdIn.fromFile(filename);
			String text = StdIn.readAll();
			textLengths.put(filename, text.length());
			frequencies.put(filename, new AVLTreeST<Character, Integer>());
			for (int i = 0; i < text.length(); i++) {
				Character c = text.charAt(i);
				Integer frequency = 0;
				if (frequencies.get(filename).contains(c)) {
					frequency = frequencies.get(filename).get(c);
				}
				frequencies.get(filename).put(c, frequency+1);
			}
		}
		
		Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for (Character vowel: vowels) {
			StdOut.println("=== Percentages for " + vowel);
			for (String filename: textFilenames) {
				int vowelFrequency = frequencies.get(filename).get(vowel);
				int textLength = textLengths.get(filename);
				double percentage = 100.0*vowelFrequency/textLength;
				StdOut.println(filename + "\t" + percentage);
			}
		}
	}

}
