package cz.czechitas.ukol3.model;

public class Computer {
    private boolean isOn;

    private Processor cpu;
    private Memory ram;
    private Disk hardDisk;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public Processor getCpu() {
        return cpu;
    }

    public void setCpu(Processor cpu) {
        this.cpu = cpu;
    }

    public Memory getRam() {
        return ram;
    }

    public void setRam(Memory ram) {
        this.ram = ram;
    }

    public Disk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Disk hardDisk) {
        this.hardDisk = hardDisk;
    }

    /**
     * Turns on the computer if all necessary components (CPU, RAM and hard disk) are present.
     * If the computer is already on, an error message  is displayed.
     * If any required component is missing, an error message is displayed and the method returns without turning on the computer.
     * */

    public void turnOn(){
        if( ram != null && hardDisk != null && cpu != null){
            if(!isOn){
                this.isOn = true;
                System.out.println("Computer is on.");
            } else {
                System.err.println("The computer is already turned on.");
            }
        } else {
            System.err.println("The computer can't be turned on.");
            return;
        }
    }

    /**
     * Turns off the computer if it is currently on.
     * If the computer is already off, no action is performed.
     */
    public void turnOff(){
        if(isOn){
            this.isOn = false;
            System.out.println("Computer is off.");
        }
    }

    /**
    * Returns a string representation of the computer's current state, including its components and on/off status
     * */
    @Override
    public String toString() {
        return "Computer{" +
                "isOn=" + isOn +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", hardDisk=" + hardDisk +
                '}';
    }
}
