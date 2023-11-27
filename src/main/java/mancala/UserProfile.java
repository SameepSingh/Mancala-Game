package mancala;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String GAME_TYPE_KALAH = "Kalah";
    private static final String GAME_TYPE_AYO = "Ayo";

    private String name;
    private Store store;
    private int kalahGamesPlayed;
    private int ayoGamesPlayed;
    private int kalahGamesWon;
    private int ayoGamesWon;

    public UserProfile(String name) {
        this.name = name;
        this.kalahGamesPlayed = 0;
        this.ayoGamesPlayed = 0;
        this.kalahGamesWon = 0;
        this.ayoGamesWon = 0;
    }

    public String getName() {
        return name;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getStoreCount() {
        return store != null ? store.getStoneCount() : 0;
    }

    public void incrementGamesPlayed(String gameType) {
        if (GAME_TYPE_KALAH.equals(gameType)) {
            kalahGamesPlayed++;
        } else if (GAME_TYPE_AYO.equals(gameType)) {
            ayoGamesPlayed++;
        }
    }

    public void incrementGamesWon(String gameType) {
        if (GAME_TYPE_KALAH.equals(gameType)) {
            kalahGamesWon++;
        } else if (GAME_TYPE_AYO.equals(gameType)) {
            ayoGamesWon++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserProfile{name='").append(name).append('\'')
          .append(", kalahGamesPlayed=").append(kalahGamesPlayed)
          .append(", ayoGamesPlayed=").append(ayoGamesPlayed)
          .append(", kalahGamesWon=").append(kalahGamesWon)
          .append(", ayoGamesWon=").append(ayoGamesWon)
          .append('}');
        return sb.toString();
    }
}




/*package mancala;
import java.util.ArrayList;
import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    private UserProfile userProfile;
    private String name;
    private Store store;
    private int id;
 
    private int kalahGamesPlayed;
    private int ayoGamesPlayed;
    private int kalahGamesWon;
    private int ayoGamesWon;

    public UserProfile(String name) {
        this.name = name;
        this.kalahGamesPlayed = 0;
        this.ayoGamesPlayed = 0;
        this.kalahGamesWon = 0;
        this.ayoGamesWon = 0;
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
    
    public void incrementGamesPlayed(String gameType) {
        if ("Kalah".equals(gameType)) {
            kalahGamesPlayed++;
        } else if ("Ayo".equals(gameType)) {
            ayoGamesPlayed++;
        }
    }

    // Method to increment the number of games won based on game type
    public void incrementGamesWon(String gameType) {
        if ("Kalah".equals(gameType)) {
            kalahGamesWon++;
        } else if ("Ayo".equals(gameType)) {
            ayoGamesWon++;
        }
    }

    @Override
    public String toString() {
        return "UserProfile{" +
               "name='" + name + '\'' +
               ", kalahGamesPlayed=" + kalahGamesPlayed +
               ", ayoGamesPlayed=" + ayoGamesPlayed +
               ", kalahGamesWon=" + kalahGamesWon +
               ", ayoGamesWon=" + ayoGamesWon +
               '}';
    }
}*/