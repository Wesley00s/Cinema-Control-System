package entities.movie;
import entities.movie.Gender;

public class Movie
{
    private String movieName;
    private int movieDuration;
    private final Gender movieGender;

    public Movie()
    {
        this.movieGender = new Gender();
    }

    public void setMovieName (String movieName)
    {
        this.movieName = movieName;
    }

    public void setMovieDuration (int movieDuration)
    {
        this.movieDuration = movieDuration;
    }

    public void setMovieGender (String movieGender)
    {
        this.movieGender.setDescription(movieGender);
    }

    public String getMovieName ()
    {
        return movieName;
    }

    public int getMovieDuration ()
    {
        return movieDuration;
    }

    public String getMovieGender ()
    {
        return movieGender.getDescription();
    }
}
