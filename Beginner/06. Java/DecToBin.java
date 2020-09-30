import java.util.Scanner;

class DecToBin {
    public static void main(String[] args) {
    	int div, num, rem;
        String bin= "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number to be converted to binary: ");
    	num = scan.nextInt();
        div = num;
        while(div != 1){
            rem = div%2;
            if(div%2==1)div--;
            div/=2;
            bin = rem + bin;
    	}
        bin = div + bin;
        System.out.println(bin);
        System.out.println("Celebrate Hacktoberfest");
    }
}