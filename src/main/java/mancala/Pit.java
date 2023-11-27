package mancala;

public class Pit implements Countable  {
    private int stoneCount;

    public Pit() {
        this.stoneCount = 0; // Initialize with zero stones
    }

    public void addStone() {
        this.stoneCount++;
    }

    public void addStones(int amount) {
        this.stoneCount += amount;
    }

    public int getStoneCount() {
        return this.stoneCount;
    }

    public int removeStones() {
        int stonesRemoved = this.stoneCount;
        this.stoneCount = 0; // Remove all stones
        return stonesRemoved;
    }
}
