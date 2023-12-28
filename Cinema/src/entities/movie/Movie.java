package entities.movie;

public class Movie
{
    private final String id;
    private String movieName;
    private int movieDuration;
    private final int  indicativeRating;
    private final Gender movieGender;
    private final Character characterName;

    public Movie(String id, String movieName, int movieDuration, int indicativeRating, String movieGender, String actorName, String characterName)
    {
        this.id = "F-" + id;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.indicativeRating = indicativeRating;
        this.movieGender = new Gender(movieGender);
        this.characterName = new Character(actorName, characterName, movieName);
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

    public void setActorRole (String actorRole)
    {
        this.characterName.setCharacterName(actorRole);
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
        return characterName.getActorName();
    }

    public String getActorRole ()
    {
        return characterName.getCharacterName();
    }

    public String getId()
    {
        return id;
    }

    public int getIndicativeRating()
    {
        return indicativeRating;
    }

    public void movieInfo()
    {
        System.out.println("\tID do filme: " + getId());
        System.out.println("\tFilme: " + getMovieName());
        System.out.println("\tGênero: " + getMovieGender());
        System.out.println("\tDuração (Em minutos): " + getMovieDuration());
        System.out.println("\tClassificação indicativa: " + (getIndicativeRating() == 0 ? "L" : getIndicativeRating()));
        System.out.println("\tAtor(a) principal: " + getActorName());
        System.out.println("\tPapel do(a) ator(a) " +  getActorName() + ": '" + getActorRole() + "'");
    }
}
