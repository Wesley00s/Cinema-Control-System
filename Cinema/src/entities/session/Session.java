package entities.session;
import java.time.LocalDate;
import java.time.LocalTime;

public class Session
{
    private String id;
    private LocalDate sessionDate;
    private LocalTime sessionTime;
    private double ticketPrice;
    private double halfTicketPrice;
    private boolean sessionClose;

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

    public void setId(String id)
    {
        this.id = "S-" + id;
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

    public void getSession()
    {
        System.out.println("ID da sessão: " + getId());
        System.out.println("Data da sessão: " + getSessionDate());
        System.out.println("Hora da sessão: " + getSessionTime() + "h");
        System.out.println("Preço do ingresso: " + String.format("R$ %.2f", getTicketPrice()));
        System.out.println("Meio ingresso: " + String.format("R$ %.2f", getHalfTicketPrice()));
        System.out.println("Sessão fechada: " + isSessionClose());
        System.out.println("=======================================\n");
    }
}