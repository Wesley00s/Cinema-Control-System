package repositories;
import entities.movie.Actor;
import entities.movie.Character;
import entities.movie.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositories.ActorManger.actorManager;
import static repositories.GenerateID.idGenerate;
import static repositories.ManagerProgram.managerMenu;

public class MoviesManager
{
    private static final ArrayList<Movie> moviesList = new ArrayList<>();
    private static final List<Actor> actorList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean findMovieName;

    public static void addPrevMovies ()
    {
        Movie matrix = new Movie("2962430", "The Matrix", 126, "Ficção científica", "Keanu Reeves", "Neo");
        Movie wick = new Movie("3027189", "John Wick", 117, "Ação", "Keanu Reeves", "John");
        Movie inter = new Movie("1663556", "Interestellar", 169, "Ficção", "Mattew McConaghey", "Cooper");
        Movie ramboI = new Movie("1970961", "Rambo I", 139, "Ação", "Sylvester Stallone", "Rambo");
        Movie rocky = new Movie("7467448", "Rocky", 128, "Drama", "Sylvester Stallone", "Rocky Balboa");
        Movie terminator = new Movie("6428301", "O Exterminador do futuro", 137, "Ficção", "Arnold Swaznegger", "Terminator");
        Actor keanu = new Actor("2589149","Keanu Reeves","Neo", "The Matrix");
        Actor mattew = new Actor("9369829","Mattew McConaghey", "Cooper", "Interestellar");
        Actor stallone = new Actor("8529642","Sylvester Stallone", "Rambo", "Rambo I");
        Actor arnold = new Actor("1119795","Arnold Swarznegger", "Terminator", "O Exterminador do futuro");
        Character john = new Character("", "John", "John Wick");
        Character balboa = new Character("", "Rocky Balboa", "Rocky");
        keanu.characters.add(john);
        stallone.characters.add(balboa);
        moviesList.add(matrix);
        moviesList.add(wick);
        moviesList.add(inter);
        moviesList.add(ramboI);
        moviesList.add(rocky);
        moviesList.add(terminator);
        actorList.add(keanu);
        actorList.add(mattew);
        actorList.add(stallone);
        actorList.add(arnold);
    }

    static void searchMovie ()
    {
        findMovieName = false;
        System.out.println("Informe o nome do filme que deseja procurar: ");
        String movieSearch = scanner.nextLine();

        for (Movie movie : moviesList)
        {
            if (movie.getMovieName().equals(movieSearch))
            {
                System.out.println("\n\tFILME ENCONTRADO");
                movie.movieInfo();
                findMovieName = true;
            }
        }
        if (!findMovieName)
        {
            System.out.println("Filme não '" + movieSearch + "' encontrado.\n");
        }
    }
    static void showMoviesList()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("A lista de filmes está vazia!");
            return;
        }
        int contMovies = 1;
        System.out.println("\n\tLISTA DE FILMES");
        for (Movie movie : moviesList)
        {
            System.out.println("Filme " + contMovies);
            movie.movieInfo();
            contMovies++;
        }
    }
    static void removeMovie ()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("A lista de filmes está vazia.");
            return;
        }
        boolean findMovieToRemove = false;
        Movie movieRemoved = null;

        System.out.println("Informe o nome do filme que deseja remover:");
        String movieRemove = scanner.nextLine();

        for (Movie movie : moviesList) {
            if (movie.getMovieName().equals(movieRemove)) {
                System.out.println("Filme '" + movie.getMovieName() + "' removido.\n");
                movieRemoved = movie;
                findMovieToRemove = true;
            }
        }

        if (findMovieToRemove)
        {
            moviesList.remove(movieRemoved);
        }
        else
        {
            System.out.println("Filme '" + movieRemove + "' não encontrado.\n");
        }
    }
    public static void moviesMenu()
    {
        System.out.println("\n\t############## APLICAÇÃO 1 - ADICIONAR FILMES ##############\n");
        System.out.println("""
                O que deseja?
                1 - Listar filme
                2 - Ver lista
                3 - Remover filme
                4 - Procurar filme
                5 - Vizualizar atores
                6 - Retornar ao menu do administrador""");
        switch (scanner.nextLine())
        {
            case "1" -> addMovies();
            case "2" -> {showMoviesList(); moviesMenu();}
            case "3" -> {removeMovie(); moviesMenu();}
            case "4" -> {searchMovie(); moviesMenu();}
            case "5" -> actorManager(actorList);
            case "6" -> {System.out.println("Retornado ao menu do administrador..."); managerMenu();}
            default -> {System.out.println("Opção inválida!\n"); moviesMenu();}
        }
    }

    public static void addMovies()
    {
        String movieName;
        String movieGender;
        String movieDuration;
        String actorName;
        String characterName;
        boolean findActor;



        System.out.println("===========================");
        do
        {
            findMovieName = false;
            System.out.println("Informe o nome do filme:");
            movieName = scanner.nextLine();
            for (Movie name : moviesList)
            {
                if (name.getMovieName().equals(movieName))
                {
                    findMovieName = true;
                    System.out.println("Filme '" + movieName + "' já presente na lista.\n");
                }
            }
        }
        while (movieName.trim().isEmpty() || findMovieName);

        do
        {
            System.out.println("Informe o gênero do filme:");
            movieGender = scanner.nextLine();
        }
        while (movieGender.trim().isEmpty() );

        boolean invalidMovieDuration;
        do
        {
            invalidMovieDuration = false;

            System.out.println("Informe a duração do filme em minutos:");
            movieDuration = scanner.nextLine();

            try
            {
                if (Integer.parseInt(movieDuration) <= 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidMovieDuration = true;
            }
        }
        while (movieDuration.trim().isEmpty() || invalidMovieDuration || Integer.parseInt(movieDuration) <= 0);

        do
        {
            System.out.println("Informe o(a) ator(a) principal de '" + movieName + "':");
            actorName = scanner.nextLine();


        }
        while (actorName.trim().isEmpty());

        do
        {
            findActor = false;

            System.out.println("Informe o papel de " + actorName + " no filme '" + movieName + "':");
            characterName = scanner.nextLine();

        }
        while (characterName.trim().isEmpty());

        for (Actor actor : actorList)
        {
            if (actor.getNameActor().equals(actorName))
            {
                Character newCharacter = new Character(actorName, characterName, movieName);
                if (!actor.characters.contains(newCharacter))
                {
                    actor.characters.add(newCharacter);
                    findActor = true;
                }
            }
        }

        if (!findActor)
        {
            Actor newActor = new Actor(idGenerate(), actorName, characterName, movieName);
            actorList.add(newActor);
        }

        Movie movie = new Movie(idGenerate(), movieName, Integer.parseInt(movieDuration), movieGender, actorName, characterName);
        moviesList.add(movie);
        System.out.println("Filme '" + movieName + "' adicionado com sucesso!\n");
        moviesMenu();
    }
}