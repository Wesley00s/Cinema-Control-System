package entities.movie;

import java.util.ArrayList;

public class Movie
{
    private final String id;
    private String movieName;
    private int movieDuration;
    private final int  indicativeRating;
    private final Gender movieGender;
    private final Character character;


    public Movie(String id, String movieName, int movieDuration, int indicativeRating, Gender movieGender, String actorName, Character character)
    {
        this.id = "F-" + id;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.indicativeRating = indicativeRating;
        this.movieGender = movieGender;
        this.character = new Character(actorName, character.getCharacterName(), movieName);
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
        this.character.setCharacterName(actorRole);
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
        return character.getActorName();
    }

    public String getCharacter()
    {
        return character.getCharacterName();
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
        System.out.println("\tPapel do(a) ator(a) " +  getActorName() + ": '" + getCharacter() + "'");
    }
}