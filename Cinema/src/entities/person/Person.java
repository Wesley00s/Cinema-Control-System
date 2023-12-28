package entities.person;

public class Person
{
    private final String id;
    private String name;
    private UserType user;

    public Person(String id, String name, UserType user)
    {
        this.id = user + "-" + id;
        this.name = name;
        this.user = user;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public UserType getUser()
    {
        return user;
    }

    public void setUser(UserType user)
    {
        this.user = user;
    }

    public void getPerson()
    {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getName());
        System.out.println("Tipo de usuário: " + getUser().getUser());
        System.out.println("===============================\n");
    }
}