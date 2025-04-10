package model;

public interface BookActions {
    String getTitle();
    void changeOwner(Person newOwner);
    void updateStatus(boolean isAvailable);
}

