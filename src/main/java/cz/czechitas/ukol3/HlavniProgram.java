package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;
import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Memory;
import cz.czechitas.ukol3.model.Processor;

/**
 * Entry class of the entire program
 */
public class HlavniProgram {

    public static void main(String... args) {
        // 1. PART
        Computer myComputer = new Computer();
        System.out.println(myComputer.toString());
        myComputer.turnOn();      // Prints an error because the computer doesn't have all the required components at this moment.

        Processor myProcessor = new Processor();
        myProcessor.setSpeed(3_490_000_000L);
        myProcessor.setManufacturer("Apple");

        Memory myMemory = new Memory();
        myMemory.setCapacity(24_000_000_000L);

        Disk myDisk = new Disk();
        myDisk.setCapacity(994_662_584_320L);

        myComputer.setCpu(myProcessor);
        myComputer.setRam(myMemory);
        myComputer.setHardDisk(myDisk);

        System.out.println(myComputer.toString());

        myComputer.turnOn();
        myComputer.turnOn();      // Prints an error because the computer is already running.
        System.out.println(myComputer.toString());
        myComputer.turnOff();

        myComputer.turnOff();      // Does not print an error, because the computer is already off.

        // 2.PARt
        myComputer.createFileOfSize(100L); // Prints an error because the computer is off.
        myComputer.turnOn();
        myComputer.createFileOfSize(100_000_000L);
        myComputer.createFileOfSize(994_662_584_323L); //  Prints an error because the requested file size exceeds the disk capacity.
        myComputer.removeFileOfSize(100L);
        myComputer.removeFileOfSize(100_000_000_000_000_000L); // Prints an error because the amount to remove exceeds the used space.
    }
}


