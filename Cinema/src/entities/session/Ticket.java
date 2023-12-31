package entities.session;

import java.time.LocalDateTime;

import static utilities.GenerateID.idGenerate;

public class Ticket
{
    private double value;
    private final String id;

    public Ticket(LocalDateTime dateTimeIssue, double value)
    {
        this.id = "T-" + idGenerate();
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

    public String getId()
    {
        return id;
    }
}