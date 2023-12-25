package entities.movie;

public class Act
{
    private String roleInMovie;
    private final Actor actor;

    public Act()
    {
        this.actor = new Actor();
    }

    public void setRoleInMovie(String roleInMovie)
    {
        this.roleInMovie = roleInMovie;
    }

    public void setActorName(String actor)
    {
        this.actor.setNameActor(actor);
    }

    public String getActorName()
    {
        return actor.getNameActor();
    }

    public String getRoleInMovie()
    {
        return roleInMovie;
    }
}
