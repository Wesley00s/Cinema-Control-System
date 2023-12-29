package entities.session;
import entities.movie.Movie;

import java.time.LocalDate;
import java.time.LocalTime;

public class Session
{
    private final String id;
    private LocalDate sessionDate;
    private LocalTime sessionTime;
    private double ticketPrice;
    private double halfTicketPrice;
    private boolean sessionClose;
    private Movie movie;

    public Session(String id, LocalDate sessionDate, LocalTime sessionTime, double ticketPrice, boolean sessionClose, Movie movie)
    {
        this.id = "S-" + id;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.ticketPrice = ticketPrice;
        this.halfTicketPrice = ticketPrice / 2;
        this.sessionClose = sessionClose;
        this.movie = movie;
    }

    public void setSessionDate(LocalDate sessionDate)
    {
        this.sessionDate = sessionDate;
    }

    public void setSessionTime(LocalTime sessionTime)
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

    public void setSessionClose(boolean sessionClose)
    {
        this.sessionClose = sessionClose;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public LocalDate getSessionDate()
    {
        return sessionDate;
    }

    public LocalTime getSessionTime()
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
        return sessionClose;
    }

    public String getId()
    {
        return id;
    }

    public void getMovie()
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
        getMovie();
    }
}