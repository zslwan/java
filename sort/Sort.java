import java.io.*;


public class Sort {
	
	static StreamTokenizer in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {	
		in = new StreamTokenizer(new BufferedReader(new FileReader(new File("in.txt"))));
		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("out.txt"))));
		
		int n = nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();
		
		//在进行排序前系统时间
		long beforeRun = System.currentTimeMillis();
		//排序算法
		//insertionSort(arr, n);
		mergeSort(arr, 0, n - 1);
		//排序后的系统时间
		long afterRun = System.currentTimeMillis();
		//排序话费时间  = (afterRun - beforeRun) 
		long second = (afterRun - beforeRun) / 1000;
		long mill = (afterRun - beforeRun) % 1000;
		System.out.printf("Time: %d.%ds\n", second, mill);
		
		for (int i = 0; i < n; i++)
			out.println(arr[i]);
		out.flush();
	}
	
	static void mergeSort(int[] a, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) >> 1;
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);
		merge(a, start, mid, end);
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
		int nL = mid - start + 1;
		int nR = end - mid;
		int[] left = new int[nL];
		int[] right = new int[nR];
		for (int i = 0; i < nL; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < nR; i++)
			right[i] = arr[mid + 1 + i];
		int indL = 0, indR = 0;
		for (int i = start; i <= end; i++) {
			if (indR == nR || (indL < nL && left[indL] < right[indR])) {
				arr[i] = left[indL];
				indL++;
			} else {
				arr[i] = right[indR];
				indR++;
			}
		}
	}
	
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int key = a[i], j;
			for (j = i - 1; j >= 0 && a[j] > key; j--)
				swap(a, j, j + 1);
			a[j + 1] = key;
		}
	}
	
	static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	static void selectionSort(int[] a, int n) {
		
	}
	
	static int nextInt() throws IOException{
		in.nextToken();
		return (int)in.nval;
	}
}
