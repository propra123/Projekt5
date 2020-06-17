package kino.customer;

import java.util.Objects;

public class EmailAdress {
    private final String emailAdress;

    public EmailAdress(String emailAdress) {
        this.emailAdress=emailAdress;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmailAdress email = (EmailAdress) o;
        return emailAdress == email.emailAdress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAdress);
    }
}
