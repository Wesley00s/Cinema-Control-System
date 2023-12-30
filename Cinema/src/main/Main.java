package main;

import static Utilities.MainMenu.mainMenu;
import static repositories.MoviesManager.addPrevMovies;
import static repositories.RoomManager.addNewRoom;
import static repositories.SessionManager.addNewSession;

public class Main
{
    public static void main(String[] args)
    {
        addPrevMovies();
        addNewRoom();
        addNewSession();
        mainMenu();
    }
}