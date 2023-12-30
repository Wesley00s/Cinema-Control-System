package entities.session;

import java.time.LocalDateTime;

public class Ticket
{
    private double value;

    public Ticket(int id, LocalDateTime dateTimeIssue, double value)
    {
        this.value = value;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }


}
