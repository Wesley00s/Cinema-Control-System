package entities.person;

public class Person
{
    private final String id;
    private String name;
    private int age;
    private UserType user;
    private  Contact contact;
    private Address address;

    public Person(String id, String name, int age, UserType user, Contact contact,  Address address)
    {
        this.id = user + "-" + id;
        this.name = name;
        this.age = age;
        this.user = user;
        this.contact = contact;
        this.address = address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUser(UserType user)
    {
        this.user = user;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public void setContact(Contact contact)
    {
        this.contact = contact;
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

    public int getAge()
    {
        return age;
    }

    public void getAddress()
    {
        address.displayAddress();
    }

    public void getContact()
    {
        contact.displayContact();
    }

    public void displayPerson()
    {
        System.out.println("\t\t\tDADOS PESSOAIS");
        System.out.println("\tTipo de usuário: " + getUser().getUser());
        System.out.println("\tID: " + getId());
        System.out.println("\tNome: " + getName());
        System.out.println("\tIdade: " + getAge());
        System.out.println("\t------------------------------------");
        System.out.println("\t\t\tDADOS DE CONTATO");
        getContact();
        System.out.println("\t------------------------------------");
        System.out.println("\t\t\tENDEREÇO");
        getAddress();
        System.out.println("\t====================================\n");
    }
}