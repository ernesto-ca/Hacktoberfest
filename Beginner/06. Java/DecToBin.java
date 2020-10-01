import java.util.Scanner;

class DecToBin {
    public static void main(String[] args) {
    	int div, num, rem;
    	//Stringbuilder doesn't create toomany objects.
        StringBuilder bin= new StringBuilder();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number to be converted to binary: ");
    	num = scan.nextInt();
        div = num;
        while(div != 1){
            rem = div%2;
            if(div%2==1)div--;
            div/=2;
            bin.insert(0, rem);
    	}
        //bin = div + bin;
        bin.insert(0, div);
        System.out.println(bin);
        System.out.println("Celebrate Hacktoberfest");
    }
}