/* Represents a Netflix Original show */

/* UML CLASS DIAGRAM:
-----------------------------------------
	NetflixOriginal
-----------------------------------------
+ VALID_GENRES : String[]        //static
- name : String
- starRating : double
- genre : String
-----------------------------------------
+ NetflixOriginal()
+ NetflixOriginal(name : String, starRating : double, genre : String)
+ getName() : String
+ getStarRating() : double
+ getGenre() : String
+ setName(name : String) : void
+ setStarRating(starRating : double) : boolean
+ setGenre(genre : String) : boolean
+ setAll(name : String, starRating : double, genre : String) : boolean
+ toString() : String
+ equals(other : NetflixOriginal) : boolean
-----------------------------------------
*/
public class NetflixOriginal
{
  /***** CONSTANTS and OTHER STATIC VARIABLES *****/
  public static final String[] VALID_GENRES = {"drama","comedy", "horror","action", "science fiction","anime", "reality","unknown"};

  /***** INSTANCE VARIABLES *****/
  private String name;
  private double starRating;
  private String genre;

  /***** CONSTRUCTORS *****/
  /** DESCRIPTION: No-argument constructor instantiates NetflixOriginal object and initializes all instance variables to default values.*/
  public NetflixOriginal()
  {
    name = "Unknown";
    starRating = 0.0;
    genre = "unknown";
  }

  /** DESCRIPTION: Full constructor instantiates NetflixOriginal object and initializes all instance variables to corresponding parameters.*/
  public NetflixOriginal(String name, double starRating, String genre)
  {
    if(!this.setStarRating(starRating) || !this.setGenre(genre))
    {
      System.out.println("ERROR: Invalid data passed to NetflixOriginal constructor. Exiting...");
      System.exit(0);
    }
    else
    {
      this.name = name;
    }
  }

  /***** ACCESSORS *****/
  /** DESCRIPTION: returns the name instance variable.*/
  public String getName()
  {
    return name;
  }

  /** DESCRIPTION: returns the starRating instance variable.*/
  public double getStarRating()
  {
    return starRating;
  }

  /** DESCRIPTION: returns the genre instance variable.*/
  public String getGenre()
  {
    return genre;
  }

  /***** MUTATORS *****/
  /** DESCRIPTION: sets the name instance variable to the given parameter.*/
  public void setName(String name)
  {
    this.name = name;
  }

  /** DESCRIPTION: Assigns the parameter to starRating instance variable only if it is between 0 and 5 stars, inclusive.*/
  public boolean setStarRating(double starRating)
  {
    if(starRating >= 0.0 && starRating <= 5.0)
    {
      this.starRating = starRating;
      return true;
    }
    else
    {
      return false;
    }
  }

	/** DESCRIPTION: Assigns the parameter to genre only if the genre is valid, i.e. is in the VALID_GENRES array.*/
  public boolean setGenre(String genre)
  {
		//check each element of VALID_GENRES array
    for(int i = 0; i < VALID_GENRES.length; i++)
    {
			//check if parameter genre is in the array
      if(genre.equalsIgnoreCase(VALID_GENRES[i]))
      {
				//if it is, then set the instance variable
        this.genre = VALID_GENRES[i];
        return true;
      }
    }
		//else if not found
    return false;
  }

	/**DESCRIPTION: Assigns parameters to corresponding instance variables only if it is valid. Returns true if all variables are set, if one or more is not set then returns false.*/
  public boolean setAll(String name, double starRating, String genre)
  {
    boolean ratingIsSet, genreIsSet;

    this.name = name;
    //set star rating only if valid
    ratingIsSet = this.setStarRating(starRating);
    //set genre only if valid
    genreIsSet = this.setGenre(genre);


    return ratingIsSet && genreIsSet;
  }

  /***** OTHER REQUIRED METHODS *****/
  /** DESCRIPTION: Returns a string of all instance variables separated by commas.*/
  public String toString()
  {
    return String.format("%s,%.1f,%s",name,starRating,genre);
  }

  /**DESCRIPTION: Determines whether all instance variables of calling object are equal to all instance variables of parameter.*/
  public boolean equals(NetflixOriginal other)
  {
    return this.name.equals(other.name) &&
          this.starRating == other.starRating &&
          this.genre.equals(other.genre);
  }


}