package kino.show;

import java.util.Objects;

// Wertobjekt
public class MovieTitle{
    private final String title;

    public MovieTitle(String title){
        this.title =title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieTitle mTitle = (MovieTitle) o;
        return title == mTitle.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
