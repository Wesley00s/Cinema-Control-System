package entities.person;

public enum UserType {
    G("GERENTE"),
    A("ATENDENTE"),
    C("USUÁRIO COMUM");

    private final String user;

    UserType(String user)
    {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
