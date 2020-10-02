import java.util.Scanner;

class InputData {
    public static void main(String args[]) {

        String Name;
        int Age;
        String address;

        Scanner input = new Scanner(System.in);

        System.out.println("## Please Input Your Data ##");
        System.out.println("=======================");
        System.out.println();

        System.out.print("Name: ");
        Name = input.nextLine();

        System.out.print("Age: ");
        Age = input.nextInt();

        input.nextLine();

        System.out.print("Address: ");
        address = input.nextLine();

        System.out.println("=======================");
        System.out.println();

        System.out.print(Name + " aged " + Age + " years old, ");
        System.out.print("lives in " + address);

    }
}