package cinema.movie;
import cinema.genero.Genero;

public class Movie
{
    private String movieName;
    private String movieDuration;
    private Genero movieGender;

    public Movie()
    {
        this.movieGender = new Genero();
    }

    public void setMovieName (String movieName)
    {
        this.movieName = movieName;
    }
    public void setMovieDuration (String movieDuration)
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

    public String getMovieDuration ()
    {
        return movieDuration;
    }
    public String getMovieGender ()
    {
        return movieGender.getDescription();
    }
    public void getMovie()
    {
        System.out.println("Filme: " + getMovieName());
        System.out.println("Gênero: " + getMovieGender());
        System.out.println("Duração (Em minutos): " + getMovieDuration());
    }
}
