package entities.movie;

import java.util.ArrayList;
import java.util.List;

public class Actor
{
    private final String id;
    private final String nameActor;
    public final List<Character> characters = new ArrayList<>();

    public Actor(String id, String nameActor, String characterName, String movie)
    {
        this.id = "T-" + id;
        this.nameActor = nameActor;
        Character character = new Character(nameActor, characterName, movie);
        this.characters.add(character);
    }

    public String getNameActor()
    {
        return nameActor;
    }

    public String getId()
    {
        return id;
    }

    public void characterInfo()
    {
        System.out.println("\n\tPersonagem - Filme");
        for (Character character : characters)
        {
            character.characterInfo();
        }
    }

    public void actorInfo ()
    {
        System.out.println("\nID do ator: " + getId());
        System.out.println("Nome do ator: " + getNameActor());
        characterInfo();
        System.out.println("======================================\n");
    }
}