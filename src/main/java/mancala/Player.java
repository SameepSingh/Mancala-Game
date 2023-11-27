package mancala;
import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private UserProfile userProfile;
    private String name;
    private Store store;
    private int id;

    public Player(){
        this("");
    }

    public Player(String name) {
        this.name = name;
    }
    
    // Getter for UserProfile
    public UserProfile getUserProfile() {
        return userProfile;
    }
    

    public String getName() {
        return name;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getStoreCount() {
        return store.getStoneCount();
    }
    
    @Override
    public String toString() {
        return "Player: " + name + " (ID: " + id + ")";
    }
}