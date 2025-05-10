package cz.czechitas.ukol3.model;

import java.text.MessageFormat;

public class Computer {
    private boolean isOn;

    private Processor cpu;
    private Memory ram;
    private Disk primaryDisk;
    private Disk secondaryDisk;

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

    public Disk getPrimaryDisk() {
        return primaryDisk;
    }

    public void setPrimaryDisk(Disk primaryDisk) {
        this.primaryDisk = primaryDisk;
    }

    public Disk getSecondaryDisk() {
        return secondaryDisk;
    }

    public void setSecondaryDisk(Disk secondaryDisk) {
        this.secondaryDisk = secondaryDisk;
    }

    /**
     * Turns on the computer if all necessary components (CPU, RAM and hard disk) are present.
     * If the computer is already on, an error message  is displayed.
     * If any required component is missing, an error message is displayed and the method returns without turning on the computer.
     */

    public void turnOn() {
        if (ram != null && primaryDisk != null && cpu != null) {
            if (!isOn) {
                this.isOn = true;
                System.out.println("Computer is on.");
            } else {
                System.err.println("The computer is already turned on.");
            }
        } else {
            System.err.println("The computer can't be turned on.");
        }
    }

    /**
     * Turns off the computer if it is currently on.
     * If the computer is already off, no action is performed.
     */
    public void turnOff() {
        if (isOn) {
            this.isOn = false;
            System.out.println("Computer is off.");
        }
    }

    /**
     * Attempts to create a file of the given size on the hard disk.
     * This action is only possible if the computer is turned on.
     * If there is enough free space on the primary disk, the file is saved there.
     * Otherwise, if the secondary disk exists and has enough free space, the file is saved there.
     * If there is not enough space on either disk, an error message is printed.
     */
    public void createFileOfSize(long size) {
        if (!isOn) {
            System.err.println("The computer must be on to create a file.");
            return;
        }
        if (primaryDisk.getFreeSpace() >= size) {
            primaryDisk.setSpaceUsed(primaryDisk.getSpaceUsed() + size);
            System.out.println(MessageFormat.format("File created on primary disk. Size: {0} B.", size));
        } else if (secondaryDisk != null && secondaryDisk.getFreeSpace() >= size) {
            secondaryDisk.setSpaceUsed(secondaryDisk.getSpaceUsed() + size);
            System.out.println(MessageFormat.format("File created on secondary disk. Size: {0} B.", size));
        } else {
            System.err.println("Not enough space on either disk to create the file.");
        }
    }

    /**
     * Attempts to remove a file of the give size from the disks.
     * This action is only possible if the computer is turned on.
     * If the primary disk has enough used space, the file is removed from it.
     * Otherwise, it attempts to remove the remaining size from the secondary disk.
     * If the combined used space of both disks is insufficient, an error is printed.
     */
    public void removeFilesOfSize(long size) {
        if (!isOn) {
            System.err.println("The computer must be on to remove a file.");
            return;
        }

        long primaryUsed = primaryDisk.getSpaceUsed();
        if (primaryUsed >= size) {
            primaryDisk.setSpaceUsed(primaryUsed - size);
            System.out.println(MessageFormat.format("Files removed on primary disk. Size: {0} B.", size));
        } else if (secondaryDisk != null) {
            long secondaryUsed = secondaryDisk.getSpaceUsed();
            long totalUsed = primaryUsed + secondaryUsed;

            if (totalUsed >= size) {
                primaryDisk.setSpaceUsed(0);
                secondaryDisk.setSpaceUsed(secondaryUsed - (size - primaryUsed));
                System.out.println(MessageFormat.format("Files removed from both disks. Size: {0} B.", size));
            } else {
                System.err.println("Not enough used space to remove the requested file size.");
            }
        } else {
            System.err.println("Not enough space to remove the requested file.");
        }
    }

    /**
     * Returns a string representation of the computer's current state, including its components and on/off status
     */
    @Override
    public String toString() {
        return "Computer{" +
                "isOn=" + isOn +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", primaryDisk=" + primaryDisk +
                ", secondaryDisk=" + secondaryDisk +
                '}';
    }
}
