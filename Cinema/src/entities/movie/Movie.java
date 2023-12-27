package entities.movie;

public class Movie
{
    private String id;
    private String movieName;
    private int movieDuration;
    private final Gender movieGender;
    private final Act actMovie;

    public Movie()
    {
        this.movieGender = new Gender();
        this.actMovie = new Act();
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

    public void setActorName(String actorName)
    {
        this.actMovie.setActorName(actorName);
    }

    public void setActorRole (String actorRole)
    {
        this.actMovie.setRoleInMovie(actorRole);
    }

    public void setId(String id)
    {
        this.id = "F-" + id;
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

    public String getActorName ()
    {
        return actMovie.getActorName();
    }

    public String getActorRole ()
    {
        return actMovie.getRoleInMovie();
    }

    public String getId()
    {
        return id;
    }

    public void getMovie ()
    {
        System.out.println("ID do filme: " + getId());
        System.out.println("Filme: " + getMovieName());
        System.out.println("Gênero: " + getMovieGender());
        System.out.println("Duração (Em minutos): " + getMovieDuration());
        System.out.println("Ator(a) principal: " + getActorName());
        System.out.println("Papel do(a) ator(a) " +  getActorName() + ": '" + getActorRole() + "'");
        System.out.println("=======================================\n");
    }
}
