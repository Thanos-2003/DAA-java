import java.util.Random;
public class MergeSort {
       /* Function to merge the subarrays of a[] */
        void merge(int a[], int beg, int mid, int end)
        {
            int i, j, k;
            int n1 = mid - beg + 1;
            int n2 = end - mid;

            /* temporary Arrays */
            int LeftArray[] = new int[n1];
            int RightArray[] = new int[n2];

            /* copy data to temp arrays */
            for (i = 0; i < n1; i++)
                LeftArray[i] = a[beg + i];
            for (j = 0; j < n2; j++)
                RightArray[j] = a[mid + 1 + j];

            i = 0; /* initial index of first sub-array */
            j = 0; /* initial index of second sub-array */
            k = beg;  /* initial index of merged sub-array */

            while (i < n1 && j < n2)
            {
                if(LeftArray[i] <= RightArray[j])
                {
                    a[k] = LeftArray[i];
                    i++;
                }
                else
                {
                    a[k] = RightArray[j];
                    j++;
                }
                k++;
            }
            while (i<n1)
            {
                a[k] = LeftArray[i];
                i++;
                k++;
            }

            while (j<n2)
            {
                a[k] = RightArray[j];
                j++;
                k++;
            }
        }

        void mergeSort(int a[], int beg, int end)
        {
            if (beg < end)
            {
                int mid = (beg + end) / 2;
                mergeSort(a, beg, mid);
                mergeSort(a, mid + 1, end);
                merge(a, beg, mid, end);
            }
        }

        /* Function to print the arra y */
        void printArray(int a[], int n)
        {
            int i;
            for (i = 0; i < n; i++)
                System.out.print(a[i] + " ");
        }
        public static void main(String[] args) {
            long startTime = System.nanoTime();
            int[] arr= new int[20];
            Random random = new Random();
            for(int i=0; i<20; i++)
            {
                //upper bound is 5000
                int x = random.nextInt(5000);
                arr[i]=x;

            }
            int n = arr.length;
            MergeSort m1 = new MergeSort();
            System.out.println("\nBefore sorting array elements are - ");
            m1.printArray(arr, n);
            m1.mergeSort(arr, 0, n - 1);
            System.out.println("\nAfter sorting array elements are - ");
            m1.printArray(arr, n);
            System.out.println("");
            long endTime   = System.nanoTime();
            long runTime = endTime - startTime;
            System.out.println("\n\nExecution time: "+runTime+" ns");
        }
}