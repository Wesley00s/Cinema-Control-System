package entities.user;

public class Address
{
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int number;


    public Address(String state, String city,  String neighborhood, String street, int number)
    {
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public String getState()
    {
        return state;
    }

    public String getCity()
    {
        return city;
    }

    public String getNeighborhood()
    {
        return neighborhood;
    }

    public String getStreet()
    {
        return street;
    }

    public int getNumber()
    {
        return number;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setNeighborhood(String neighborhood)
    {
        this.neighborhood = neighborhood;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void displayAddress ()
    {
        System.out.println("\tEstado: " + getState());
        System.out.println("\tCidade: " + getCity());
        System.out.println("\tBairro: " + getNeighborhood());
        System.out.println("\tRua: " + getStreet());
        System.out.println("\tNúmero: " + getNumber());
    }
}