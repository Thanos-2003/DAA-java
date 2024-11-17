
public class Bubble_sort {
    public static void main(String [] args)
    {
        int [] arr;
        arr = new int[]{ 4, 9, 5 , 2 };
        int n= arr.length;
        System.out.println("Unsorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        for (int i = 0; i < n; i++) {
            for( int j =0; j< n-i-1;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nSorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

