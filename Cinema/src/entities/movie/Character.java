package entities.movie;

public class Character {
    private String characterName;
    private final String actorName;
    private final String movieName;

    public Character(String actorName, String characterName, String movie)
    {
        this.characterName = characterName;
        this.actorName = actorName;
        this.movieName = movie;
    }


    public void setCharacterName (String character)
    {
        this.characterName = character;
    }

    public String getActorName()
    {
        return actorName;
    }

    public String getCharacterName()
    {
        return characterName;
    }
    public String getMovieName()
    {
        return movieName;
    }

    public void characterInfo ()
    {
        System.out.println("\t------------------------------");
        System.out.println("\t\t'" + getCharacterName() + "' - " + getMovieName());
    }

    public static void main(String[] args) {
        Character character = new Character("Tobey Maguire", "Peter Park", "Homem-Aranha");
        character.characterInfo();
    }
}
