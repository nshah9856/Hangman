
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class HangmanGame {
		
	public static void run(){
		List<String> data = Arrays.asList("MATHEMATICS","COMPUTER","THE","OXYMORON","INDIA","BANGLADESH"); 
		Random r;
		boolean playing = true;

		System.out.print("Have your CAPS LOCK ON");
		System.out.print("\nWelcome to Hangman");
		
		try {
			System.out.print("Loading Game...");
			
			Scanner scan = new Scanner(System.in);
			r = new Random();
			int tries, life = 0;
			boolean complete, correct;


			while (playing) {
				System.out.print("\nNew game has Started");
				
				String guessword = data.get(r.nextInt(data.size()));//list of string here
				life = 6;
				char guess[] = new char[guessword.length()];
				for (int i = 0; i < guess.length; i++)
					guess[i] = '_';
				
				complete = false;
				tries = 0;
				
				while (!complete && tries != life) {
					System.out.print("\nYou have " + (life - tries) + " try left");
					System.out.print(Arrays.toString(guess) + "\nEnter a single character: ");
					String inp = scan.next();
					char in = inp.charAt(0);
						correct = false;
					
					if (in == '_') // if player wants to quit the game in middle
					{
						playing = false;
						complete = true;
					} else {
						for (int i = 0; i < guessword.length(); i++) {
							if (guessword.charAt(i) == in) {
								guess[i] = in;
								correct = true;
								
							}
						}
						if (!correct)
							tries++;
						if (isTheWordGuessed(guess)) {
							complete = true;
							System.out.print("Congratulations, You have won the game!");
						}
					}
				}
				System.out.print("Original Word: " + guessword);
				if (playing) {
					if (!complete)
						System.out.print("No more guess left");
					String ng = scan.next("\nDo you want to play another game? [YES / NO]: ");
					
					if (ng.equalsIgnoreCase("no"))
						playing = false;
				}
				System.out.print("Game Over!");
			}
		} 
		finally{
			
		}
	}

	private static boolean isTheWordGuessed(char[] array) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == '_')
				return false;
		}
		return true;
	}
	
		public static void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
							
		}
		System.out.print(" ");
	}

}

