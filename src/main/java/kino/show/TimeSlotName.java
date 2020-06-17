package kino.show;


import java.util.Objects;

//Werteobjekt
public class TimeSlotName {
    private final String timeslotName;


    public TimeSlotName(String timeslotName){
        this.timeslotName = timeslotName;
    }

    public String getTimeslotName() {
        return timeslotName;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimeSlotName timeslotName = (TimeSlotName) o;
        return timeslotName.equals(timeslotName.timeslotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeslotName);
    }

}
