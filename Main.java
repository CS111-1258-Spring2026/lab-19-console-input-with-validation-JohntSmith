/**
 * Main class for Lab 19: Console input with validation.
 * This Program defines a NetflixOriginal class with name, star rating, and genre.
 * Validates the input, and stores the data in an array. Then prints the details of each show.
 * @JohntSmith
 * <Date> 05/06/2026
 * CS 111 1258
 */
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		NetflixOriginal [] shows = new NetflixOriginal[2];
		for (int i = 0; i < shows.length; i++) {
			shows[i] = instantiateFromInput(keyboard);
			System.out.println(shows[i]);
		}
		//System.out.println(shows[0]);
		//System.out.println(shows[1]);
	}
		/**
     	 * Prompts the user for name, star rating, and genre.
     	 * Validates that the rating is between 0-5 and the genre is within 
     	 * the allowed list defined in the NetflixOriginal class.
     	 * @param keyboard The Scanner object used for console input.
     	 * @return A fully initialized and validated NetflixOriginal object.
     	 */
		public static NetflixOriginal instantiateFromInput(Scanner keyboard){

			String name, genre = "";
			double starRating = -1.0;
			NetflixOriginal temp = new NetflixOriginal();
		
			//Prompt for input name
			System.out.print("Please enter the name of the show: ");
			name = keyboard.nextLine().trim();
			
			//Prompt for input starRating with numeric and range validation (do while loop)
			while (true) {
				System.out.print("Please enter the star rating: ");
				if (keyboard.hasNextDouble()) {
					starRating = keyboard.nextDouble();
					keyboard.nextLine(); //Consume the buffer
					if (starRating >= 0 && starRating <= 5) break;
					else System.out.println("ERROR: please enter a star rating between 0.0-5.0");
				} else 
					{
					System.out.println("ERROR: please enter a valid number for the star rating.");
					keyboard.nextLine(); //Clear the invalid input
					}
			}
						
			//Prompt for input genre with validation against VALID_GENRES array (do while loop)
			boolean validGenre = false;
			while (!validGenre) {
				System.out.print("Please enter the genre: ");
				genre = keyboard.nextLine().trim();
				validGenre = temp.setGenre(genre);

				if (!validGenre) {
					System.out.println("ERROR: That is not a valid genre. Please choose one of the following: ");
					for (int i = 0; i < NetflixOriginal.VALID_GENRES.length; i++) {
						System.out.print(NetflixOriginal.VALID_GENRES[i] + (i < NetflixOriginal.VALID_GENRES.length -1 ? ", " : ""));
					}
					System.out.println();
				}
				
			}

			return new NetflixOriginal(name, starRating, genre);
		}
				
}