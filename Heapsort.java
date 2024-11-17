import java.util.Random;
import java.util.Arrays;
public class Heapsort{
    public static void heapify(int arr[],int n,int i){
        int largest =i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest])
            largest = left;
        if(right<n&&arr[right]>arr[largest])
            largest =right;
        if(largest!=i){
            swap(arr,i,largest);
            heapify(arr,n,largest);
        }
    }
    public static void heapsort(int arr[], int n ){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
    public static void swap(int arr[],int a,int b){
        int t = arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
    public static void main(String []args){
        int n=10;
        Random ran = new Random();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int x = ran.nextInt(5000);
            arr[i]=x;
        }
        System.out.println(Arrays.toString(arr));
        heapsort(arr,n-1);
        System.out.println(Arrays.toString(arr));
    }
}