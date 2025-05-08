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

    public void setSpaceUsed(long spaceUsed) {
        this.spaceUsed = spaceUsed;
    }

    /**
    * Returns a string representation of the Disk object, including its capacity and used space in bytes.
    * */
    @Override
    public String toString() {
        return "Disk{" +
                "capacity=" + capacity + " B" +
                ", spaceUsed=" + spaceUsed + " B" +
                '}';
    }
}
