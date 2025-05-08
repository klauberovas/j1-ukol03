package cz.czechitas.ukol3.model;

public class Memory {
    private long capacity;

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    /**
    * Returns a string representation of the Memory object, including its capacity in bytes.
    * */
    @Override
    public String toString() {
        return "Memory{" +
                "capacity=" + capacity + " B" +
                '}';
    }
}
