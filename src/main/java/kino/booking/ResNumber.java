package kino.booking;

import java.util.UUID;

public class ResNumber {
    private final UUID resNumber = UUID.randomUUID();

    public UUID getResNumber() {
        return resNumber;
    }
}
