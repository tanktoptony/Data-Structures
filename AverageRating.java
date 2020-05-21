package symboltable;

import algs4.StdOut;
import algs4.SequentialSearchST;
import algs4.StdIn;
import algs4.BinarySearchST;
import algs4.BST;

// Anthony Jarina CSC 403

public class AverageRating {

	public static void main(String[] args) {
		SequentialSearchST<String, Double> ratings= new SequentialSearchST<>();
		
		// populating symbol table
		ratings.put("Outstanding", 3.0);
		ratings.put("Excellent", 2.5);
		ratings.put("Very Good", 2.0);
		ratings.put("Good", 1.5);
		ratings.put("Fair", 1.0);
		ratings.put("Poor", 0.5);
		ratings.put("Avoid", 0.0);
		
		//reading ratings file
		StdIn.fromFile("data/ratings.txt");
		String[] ratingsFile = StdIn.readAllLines();
	
		int counter = 0; // create a counter variable in order to determine what to divide by for average
		Double acc = 0.0;
		
		for (String ratingName: ratingsFile) {	
			acc += ratings.get(ratingName);
			counter += 1;
		}
		
		StdOut.println("The average value from ratings.txt is: " + acc/counter + ".");
	}

}
