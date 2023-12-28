package entities.person;

public class Contact
{
    private String  phone;
    private String email;

    public Contact(String phone, String email)
    {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void displayContact ()
    {
        System.out.println("\tTelefone: " + getPhone());
        System.out.println("\tE-mail: " + getEmail());
    }
}
