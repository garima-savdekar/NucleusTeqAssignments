import java.util.Scanner;
public class SortArray {
    public static void BubbleSort(int n, int array[]){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

    }
    public static void SelectionSort(int n,int array[]){
        for(int i=0;i<n-1;i++){
            int minindex=i;
            for(int j=i+1;j<n;j++){
                if(array[j]<array[minindex]){
                    minindex=j;
                }
            }
            int temp=array[minindex];
            array[minindex]=array[i];
            array[i]=temp;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Choose method for sorting the array: \n 1.Bubble Sort \n 2.Selection Sort");
        int choice=sc.nextInt();
        if(choice==1){
            BubbleSort(n,array);
            System.out.println("Sorted array using Bubble Sort");
        }
        else if(choice==2){
            SelectionSort(n,array);
            System.out.println("Sorted array using Selection Sort");
        }
        else{
            System.out.println("Invalid choice enter 1 or 2");
        }

        System.out.println("Sorted array");
        for(int num:array){
            System.out.print(num+ " ");
        }
    }
}
