package program;

import static repositories.ManagerProgram.managerMenu;
import static repositories.MoviesManager.addPrevMovies;

public class Main
{
    public static void main(String[] args)
    {
        addPrevMovies();
        managerMenu();
    }
}