package main;

import static repositories.ManagerProgram.addMainManager;
import static utilities.MainMenu.mainMenu;
import static repositories.MoviesManager.addPrevMovies;
import static repositories.RoomManager.addNewRoom;
import static repositories.SessionManager.addNewSession;

public class Main
{
    public static void main(String[] args)
    {
        addMainManager();
        addPrevMovies();
        addNewRoom();
        addNewSession();
        mainMenu();
    }
}