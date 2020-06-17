package kino.show;

public interface ShowReposetory{
    void save(Show show);
    Show findByID(String id);
}
