package entities.session;
import entities.movie.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Session
{
    private final String id;
    private String sessionDate;
    private String sessionTime;
    private double ticketPrice;
    private double halfTicketPrice;
    private final Room room;
    private Movie movie;
    private final List<Seat> seatList;

    public Session(String id, String sessionDate, String sessionTime, double ticketPrice, Movie movie, Room room)
    {
        this.id = "S-" + id;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.ticketPrice = ticketPrice;
        this.halfTicketPrice = ticketPrice / 2;
        this.movie = movie;
        this.room = room;
        this.seatList = room.getSeatList();
    }

    public void setSessionDate(String sessionDate)
    {
        this.sessionDate = sessionDate;
    }

    public void setSessionTime(String sessionTime)
    {
        this.sessionTime = sessionTime;
    }

    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }

    public void setHalfTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
        this.halfTicketPrice = ticketPrice / 2;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public String getSessionDate()
    {
        return sessionDate;
    }

    public String getSessionTime()
    {
        return sessionTime;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }

    public double getHalfTicketPrice()
    {
        return halfTicketPrice;
    }

    public boolean isSessionClose()
    {
        for (Seat seat : seatList)
        {
            if (seat.isOccupied())
            {
                return false;
            }
        }
        return true;
    }

    public String getId()
    {
        return id;
    }

    public Movie getMovie()
    {
        return this.movie;
    }

    public void getMovieInfo()
    {
        movie.movieInfo();
    }

    public void getSession()
    {
        System.out.println("\t\t* INFORMAÇÕES DA SESSÃO");
        System.out.println("\tID da sessão: " + getId());
        System.out.println("\tData da sessão: " + getSessionDate());
        System.out.println("\tHora da sessão: " + getSessionTime() + "h");
        System.out.println("\tPreço do ingresso: " + String.format("R$ %.2f", getTicketPrice()));
        System.out.println("\tMeio ingresso: " + String.format("R$ %.2f", getHalfTicketPrice()));
        System.out.println("\tSessão fechada: " + (isSessionClose() ? "SIM" : "NÃO"));
        System.out.println("\t------------------------------------");
        System.out.println("\t\t\t* FILME DA SESSÃO");
        getMovieInfo();
    }

    public List<Seat> getSeatList()
    {
        return seatList;
    }

    public Room getRoom()
    {
        return room;
    }
}