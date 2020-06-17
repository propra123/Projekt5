package kino.show;

import java.util.Objects;

// Entity
public class Timeslot  {
    private final TimeSlotName timeslotName;
    private final Time time;

     Timeslot(TimeSlotName timeslotName, Time time){
        this.timeslotName = timeslotName;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public TimeSlotName getTimeslotName() {
        return timeslotName;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Timeslot slot = (Timeslot) o;
        return timeslotName.equals(slot.timeslotName) && time.equals(slot.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeslotName,time);
    }

}
