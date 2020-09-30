/*a program in java to illustrate the use of for each loop by searching an element in the
unsorted array.*/
import java.util.Scanner;

public class LinearSearch 
{
    public static void main(String[] args)
    {Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array ");
        int n=sc.nextInt();
        System.out.println("Enter"+n+" values"); //for size of array
        int i=0;
        int arr[] =new int[n];
        for(i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter value to be searched");
        int v=sc.nextInt();// inputting element to be searched
        for(i=0;i<n;i++) //finding out if element exists in the array
        { if (arr[i]==v)
           {System.out.println("Value found at"+i+" position of the array");
           break;
        }
        if(i==(n-1))
        System.out.println("Value not found");

    }
    }
    
}