package repositories;

import entities.movie.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositories.MoviesManager.moviesMenu;

public class ActorManger
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Actor> actorList = new ArrayList<>();

    private static void listActors (List<Actor> actorList)
    {
        if (actorList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        for (Actor actor : actorList)
        {
            actor.actorInfo();
        }
    }

    private static void searchActor (List<Actor> actorList)
    {
        if (actorList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        boolean findActor = false;
        String search;
        System.out.println("Iforme o ID ou nome do ator que deseja procurar:");
        search = scanner.nextLine();

        for (Actor actor : actorList)
        {
            if (actor.getId().equals(search) || actor.getNameActor().equals(search))
            {
                System.out.println("\n\tATOR ENCONTRADO");
                actor.actorInfo();
                findActor = true;
            }
        }
        if (!findActor)
        {
            System.out.println("Ator não encontrado!\n");
        }
    }

    public static void actorManager (List<Actor> actorList)
    {
        System.out.println("""
                \nO que desejas?
                1 - Ver lista de atores
                2 - Procurar ator
                3 - Retornar ao menu de filmes""");
        switch (scanner.nextLine())
        {
            case "1" -> {listActors(actorList); actorManager(actorList);}
            case "2" -> {searchActor(actorList); actorManager(actorList);}
            case "3" -> {System.out.println("Retornando ao menu de filmes..."); moviesMenu();}
        }
    }
}