package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;
import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Memory;
import cz.czechitas.ukol3.model.Processor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
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
        }
    }


