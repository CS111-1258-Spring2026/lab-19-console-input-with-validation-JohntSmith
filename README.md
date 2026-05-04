# **Lab 19: Console Input With Validation**
### Overview:

You recently made your own classes from scratch and added validity checking in your setter methods. In this lab, you will create an array of two `NetflixOriginal` objects by getting valid inputs from the user.

**Step 1:**
- Write a method `instantiateFromInput()` that takes a Scanner object as a parameter and returns a `NetflixOriginal` object.
- Inside the method, prompt user to input `name`, `starRating` and `genre`. Set `starRating` and `genre` only when the inputs are valid. Keep asking the user to enter `starRating` and `genre` until they are valid.

**Step 2:**
- Inside the `main()` method, create an array of `NetflixOriginal` shows of size 2. Instantiate those two objects by calling the `instantiateFromInput()` method. 
- Finally, output the shows. Your output should look like:

	Please enter the name of the show: Atypical
	Please enter the star rating: 4.5
	Please enter the genre: drama
	Atypical,4.5,drama
	Please enter the name of the show: Stranger Things
	Please enter the star rating: 5.0
	Please enter the genre: science fiction
	Stranger Things,5.0,science fiction