package symboltable;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;

// Author: Anthony Jarina

public class MultisequenceCodonFrequencies {

	public static void main(String[] args) {
		// Symbol Table 1 declared and initialized
		AVLTreeST<String, AVLTreeST<String, Integer>> frequencies = new AVLTreeST<>();
		// Symbol Table 2
		AVLTreeST<String, Integer> textLengths = new AVLTreeST<>();

		String[] files = {"data/SARSCoV2-S-gene-CA.txt", "data/SARSCoV2-S-gene-IL.txt", "data/SARSCoV2-S-gene-WH.txt"};
				
		for (String file: files) {
			StdIn.fromFile(file);	//read in files

			frequencies.put(file, new AVLTreeST<String, Integer>()); //populate 1
			String text = StdIn.readAll();
			textLengths.put(file, text.length()); //populate 2
			int i = 0;
			for (int j = 0; j < text.length(); j+=3) {
				String codon = text.substring(i, i+3);
				Integer frequency = frequencies.get(file).get(codon);
				if (frequency == null) frequency = 0;
				frequencies.get(file).put(codon, frequency+1);
				i++;
			}
		}
				
		String[] leucines = {"ctt", "ctc", "cta", "ctg", "tta", "ttg"};
		for (String leucine: leucines) {
			StdOut.println("Frequencies for '" + leucine + "':");
			for (String file: files) {
				Integer frequency = frequencies.get(file).get(leucine);
				double percentage = 100.0 * frequency / textLengths.get(file);
				StdOut.printf("%-25s\t%6.2f\n", file, percentage);
			}
		}
		
		
	}

}
