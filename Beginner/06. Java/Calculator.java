import java.util.Scanner;
public class Calculator {
    int num1,num2,num3,choice;
    public void getdata(){
        Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice from the following menu:");
            System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
            System.out.print("Your Choice: ");
			choice = sc.nextInt();
			if(choice!=5){
				System.out.println("Enter the first number");
				num1=sc.nextInt();
				System.out.println("Enter the second number");
                num2=sc.nextInt();
                sc.close();
            }
            else
                System.exit(0);
            
    }
    public void calc(){
        switch(choice)
			{
				case 1:System.out.println("Addition of "+num1+" and "+num2+" is "+(num1+num2));
					break;
				case 2:System.out.println("Subtraction of "+num1+" and "+num2+" is "+(num1-num2));
					break;
				case 3:System.out.println("Multiplication of "+num1+" and "+num2+" is "+(num1*num2));
					break;
				case 4:	if(num2==0)
						System.out.println("Error!!! In Division denominator cannot be 0!");
					else{
					System.out.println("In division of "+num1+" by "+num2+" quotient is "+(num1/num2)+" and remainder is "+(num1%num2));} 
					break;
				case 5: break;
				default: System.out.println("Invalid choice");
			}
    }
    public static void main(String[] args) {
        System.out.println("Calculator");
        Calculator c = new Calculator();
        c.getdata();
        c.calc();
    }
}
