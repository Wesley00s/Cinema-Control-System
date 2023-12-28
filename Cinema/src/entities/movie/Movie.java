package entities.movie;

public class Movie
{
    private final String id;
    private String movieName;
    private int movieDuration;
    private final Gender movieGender;
    private final Character characterName;

    public Movie(String id, String movieName, int movieDuration, String movieGender, String actorName, String characterName) {
        this.id = "F-" + id;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
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

    public void movieInfo()
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
