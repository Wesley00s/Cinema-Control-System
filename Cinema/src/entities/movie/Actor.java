package entities.movie;

import java.util.ArrayList;
import java.util.List;

import static Utilities.GenerateID.idGenerate;

public class Actor
{
    private final String id;
    private final String nameActor;
    public final List<Character> characters;

    public Actor(String nameActor)
    {
        this.id = "T-" + idGenerate();
        this.nameActor = nameActor;
        this.characters = new ArrayList<>();
    }

    public void addCharacter (Character character)
    {
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
        System.out.println("\n\t\tPersonagem - Filme");
        for (Character character : characters)
        {
            character.characterInfo();
        }
    }

    public void actorInfo ()
    {
        System.out.println("\tID do ator: " + getId());
        System.out.println("\tNome do ator: " + getNameActor());
        characterInfo();
    }
}