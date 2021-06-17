import java.util.Random;
import java.util.Scanner;

public class Unit5Task1 {
    public static void main(String[] args) {
        Computer computer = new Computer(3, 16, 1000, 2);
        System.out.println(computer.description());
        computer.turnOn();
    }

    public static class Computer {
        double processor;
        int ram;
        int hdd;
        int resource;
        int count = 0;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        public Computer(double processor, int ram, int hdd, int resource) {
            this.processor = processor;
            this.ram = ram;
            this.hdd = hdd;
            this.resource = resource;
        }

        public String description() {
            return "Computer:\n" +
                    "  Processor: " + processor + " GHz\n" +
                    "  RAM: " + ram + " GB\n" +
                    "  HDD: " + hdd + " GB\n" +
                    "  resource of full work cycles: " + resource;
        }

        public void turnOn() {
            System.out.println("Enter 0 or 1 for to turn on the computer: ");
            int n = scan.nextInt();
            int s = rand.nextInt(2);
            if (n == s && count < resource) {
                System.out.println(s);
                System.out.println("Computer ON");
                turnOff();
            } else if (n != s) {
                System.out.println(s);
                System.out.println("Computer is burned out");
            } else {
                System.out.println("Computer is burned out. The resource limit has been exceeded!");
            }
        }

        public void turnOff() {
            System.out.println("Enter 0 or 1 to turn off the computer: ");
            int n = scan.nextInt();
            int s = rand.nextInt(2);
            if (n == s) {
                System.out.println(s);
                System.out.println("Computer OFF");
                count++;
                System.out.println("Number of complete work cycles: " + count);
                turnOn();
            } else {
                System.out.println(s);
                System.out.println("Computer is burned out");
            }

        }
    }
}