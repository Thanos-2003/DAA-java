// Java implementation of QuickSort using randomly generated numbers
import java.util.Random;
class QuickSort {

	// A utility function to swap two elements
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// This function takes last element as pivot,

	static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];

		// Index of smaller element and indicates
		// the right position of pivot found so far
		int i = (low -1 );

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller than the pivot
			if (arr[j] < pivot) {

				// Increment index of smaller element 
                                //ie skip the element, do nothing
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}


	// arr[] = Array to be sorted,
	// low = Starting index
	// high = Ending index
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			// pi is pivot, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort element before partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	
	public static void printArr(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		int[] arr= new int[20];
		Random random = new Random();
		for(int i=0; i<20; i++)
		{
                        //upper bound is 5000
			int x = random.nextInt(5000);
			arr[i]=x;

		}
		int N = arr.length;
                System.out.println("Given Array");
                printArr(arr);

		//Initial Function call
		quickSort(arr, 0, N - 1);
		System.out.println("\nSorted array:");
		printArr(arr);

        long endTime   = System.nanoTime();
		long runTime = endTime - startTime;
		System.out.println("\n\nExecution time: "+runTime+" ns");
	}
}
