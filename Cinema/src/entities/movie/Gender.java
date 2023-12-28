package entities.movie;

public class Gender
{
    private String description;

    public Gender (String description)
    {
        this.description = description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getDescription ()
    {
        return description;
    }
}