package cz.czechitas.ukol3.model;

public class Processor {
    private String manufacturer;
    private long speed;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    /**
     * Returns a string representation of the Processor object, including its manufacturer and speed in Hz.
     * */
    @Override
    public String toString() {
        return "Processor{" +
                "manufacturer='" + manufacturer + '\'' +
                ", speed=" + speed + " Hz" +
                '}';
    }
}
