package entities.user;

import static Utilities.GenerateID.idGenerate;

public class User
{
    private final String id;
    private String name;
    private int age;
    private UserType userType;
    private  Contact contact;
    private Address address;
    private final boolean isStudent;

    public User(String name, int age, UserType userType, Contact contact, Address address, boolean isStudent)
    {
        this.id = userType + "-" + idGenerate();
        this.name = name;
        this.age = age;
        this.userType = userType;
        this.contact = contact;
        this.address = address;
        this.isStudent = isStudent;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setUser(UserType userType)
    {
        this.userType = userType;
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
        return userType;
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

    public boolean isStudent() {
        return isStudent;
    }
}