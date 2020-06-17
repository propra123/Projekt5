package kino.customer;

public class Customer {

    private  EmailAdress email;
    private  Name name;

    public Customer(Name name, EmailAdress emailAdress){
        this.name=name;
        this.email=emailAdress;

    }

    public String getEmail() {
        return email.getEmailAdress();
    }
}
