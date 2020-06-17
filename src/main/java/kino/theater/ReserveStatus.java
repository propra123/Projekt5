package kino.theater;

import java.util.Objects;

//Werteobjekt

public class ReserveStatus {
    private final boolean isReserved;

    public ReserveStatus(boolean isReserved) {
        this.isReserved = isReserved;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReserveStatus reserved = (ReserveStatus) o;
        return isReserved == reserved.isReserved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isReserved);
    }
}
