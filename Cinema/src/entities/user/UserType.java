package entities.user;

public enum UserType
{
    G("GERENTE"),
    C("CLIENTE");

    private final String user;

    UserType(String user)
    {
        this.user = user;
    }

    public String getUser()
    {
        return user;
    }
}
