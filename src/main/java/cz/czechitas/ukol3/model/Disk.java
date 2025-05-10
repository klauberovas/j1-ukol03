package cz.czechitas.ukol3.model;

public class Disk {
    private long capacity;
    private long spaceUsed;

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getSpaceUsed() {
        return spaceUsed;
    }

    /**
     * Sets the amount of used space on the disk.
     * Ensures the value is not negative and does not exceed the disk's capacity.
     * Prints an error message if the value is invalid and does not change the current state.
     */
    public void setSpaceUsed(long spaceUsed) {
        if (spaceUsed >= 0) {
            if (spaceUsed > this.capacity) {
                System.err.println("Space used cannot be greater than capacity.");
            } else {
                this.spaceUsed = spaceUsed;
            }
        } else {
            System.err.println("Space used cannot be less than capacity.");
        }
    }

    public long getFreeSpace() {
        return capacity - spaceUsed;
    }

    /**
     * Returns a string representation of the Disk object, including its capacity and used space in bytes.
     */
    @Override
    public String toString() {
        return "Disk{" +
                "capacity=" + capacity + " B" +
                ", spaceUsed=" + spaceUsed + " B" +
                '}';
    }
}
