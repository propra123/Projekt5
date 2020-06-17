package kino.show;

import java.util.Objects;

//Werteobjekt
public class Time {

    private final String time;


    public Time(String time){
        this.time = time;
    }

    public String getTimeslotTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Time time = (Time) o;
        return time.equals(time.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

}
