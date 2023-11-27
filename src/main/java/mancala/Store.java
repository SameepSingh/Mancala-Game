package mancala;

public class Store implements Countable {
    private int stoneCount;
    private Player owner; // Assuming you have a Player class defined elsewhere

    // Corrected constructor
    public Store() {
        this.stoneCount = 0; // Initialize with zero stones
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public void addStone() {
        this.stoneCount++;
    }

    @Override
    public void addStones(int amount) {
        this.stoneCount += amount;
    }

    @Override
    public int getStoneCount() {
        return this.stoneCount;
    }

    @Override
    public int removeStones() {
        int stonesRemoved = this.stoneCount;
        this.stoneCount = 0; // Remove all stones
        return stonesRemoved;
    }
}
