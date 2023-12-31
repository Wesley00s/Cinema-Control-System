package repositories;

import entities.movie.Actor;

import java.util.List;
import java.util.Scanner;

import static repositories.MoviesManager.moviesMenu;

public class ActorManager
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void actorManagerMenu(List<Actor> actorList)
    {
        while (true)
        {
            System.out.println("\n\t############## VER ATORES ##############\n");
            System.out.println("""
                \nO que desejas?
                1 - Ver lista de atores
                2 - Procurar ator
                3 - Retornar ao menu de filmes""");
            switch (scanner.nextLine())
            {
                case "1" -> displayActorsList(actorList);
                case "2" -> searchActor(actorList);
                case "3" -> {System.out.println("Retornando ao menu de filmes..."); moviesMenu();}
            }

        }
    }
    public static void displayActorsList(List<Actor> actorList)
    {
        int contActor = 1;
        if (actorList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }

        for (Actor actor : actorList)
        {
            System.out.println("\n\n* ATOR " + contActor + " ================================\n");
            actor.actorInfo();
            contActor++;
        }
    }

    public static void searchActor(List<Actor> actorList)
    {
        if (actorList.isEmpty())
        {
            System.out.println("A lista está vazia!\n");
            return;
        }
        boolean findActor = false;
        String search;
        System.out.println("Informe o ID ou nome do ator que deseja procurar:");
        search = scanner.nextLine();

        for (Actor actor : actorList)
        {
            if (actor.getId().equals(search) || actor.getNameActor().equals(search))
            {
                System.out.println("\n* ATOR ENCONTRADO ===========================\n");
                actor.actorInfo();
                findActor = true;
            }
        }
        if (!findActor)
            System.out.println("Ator não encontrado!\n");
    }
}