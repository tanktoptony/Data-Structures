package symboltable;

import algs4.BST;
import algs4.Queue;
import algs4.StdIn;
import algs4.StdOut;
import myalgs4.*;

// Author: Anthony Jarina

public class CountCodonFollowers {

	public static void main(String[] args) {
		// 1. Build an array containing every possible codon using codonlist.txt
		StdIn.fromFile("data/codonlist.txt");
		String lines = StdIn.readLine();
		String[] codons = lines.split("\\s+");
		
		// 2. Read in the sequence from Wuhan file
		StdIn.fromFile("data/SARSCoV2-S-gene-WH.txt");
		String text = StdIn.readAll();
		
		// 3. Build symbol table where the key is a codon and the value is a queue of positions
		// where that specific codon occurs in the sequence
		BST <String, Queue> appearances = new BST<>();
		
		int len = text.length();
		int i = 0;		
		
		
		for (int j = 0; j < len; j+=3) {
			String codon = text.substring(i, i+3);
			if(!appearances.contains(codon)) {
				Queue<Integer> positions = new Queue<>();
				appearances.put(codon, positions);
			}
			i++;
			appearances.get(codon).enqueue(j);
			}
		
		//for(String key : appearances.keys()) {
			//StdOut.println(key + ": " + appearances.get(key).size());
		//}
		StdOut.println("Number of different codons following each codon:");
		
		for (String codon : codons) {
			BST <String, Boolean> followers = new BST<>();
			if(appearances.contains(codon)) {
				for(int k = 0; k < appearances.get(codon).size(); k++) {
					Integer location = appearances.get(codon).dequeue();
					String next = lines.substring(location + 3, location + 6);
					followers.put(next, true);
				}
				StdOut.println(followers.size());
			} else {
				StdOut.println("Does not occur in the sequence");
			}
		}
	}		
}

