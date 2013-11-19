import java.io.*;

public class SortCount {
	
	static StreamTokenizer in;
	static PrintWriter out;
	static int count;
	
	public static void main(String[] args) throws IOException {	
		in = new StreamTokenizer(new BufferedReader(new FileReader(new File("in.txt"))));
		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("out.txt"))));
		
		int n = nextInt();
		Team[] teams = new Team[n];
		for (int i = 0; i < n; i++) {
			teams[i] = new Team(nextInt());
		}
		
		//在进行排序前系统时间
		long beforeRun = System.currentTimeMillis();
		//排序算法
		count = 0;
		//insertionSort(teams, n);
		mergeSort(teams, 0, n - 1);
		//排序后的系统时间
		long afterRun = System.currentTimeMillis();
		//排序话费时间  = (afterRun - beforeRun) 
		long second = (afterRun - beforeRun) / 1000;
		long mill = (afterRun - beforeRun) % 1000;
		System.out.printf("Time: %d.%ds\n", second, mill);
		System.out.printf("running %d times comparation\n", count);
		
		for (int i = 0; i < n; i++)
			out.println(teams[i]);
		out.flush();
	}
	
	static void mergeSort(Team[] a, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) >> 1;
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);
		merge(a, start, mid, end);
	}
	
	static void merge(Team[] arr, int start, int mid, int end) {
		int nL = mid - start + 1;
		int nR = end - mid;
		Team[] left = new Team[nL];
		Team[] right = new Team[nR];
		for (int i = 0; i < nL; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < nR; i++)
			right[i] = arr[mid + 1 + i];
		int indL = 0, indR = 0;
		for (int i = start; i <= end; i++) {
			if (indR == nR || (indL < nL && left[indL].compareTo(right[indR]) < 0)) {
				arr[i] = left[indL];
				indL++;
			} else {
				arr[i] = right[indR];
				indR++;
			}
		}
	}
	
	static void insertionSort(Team[] a, int n) {
		for (int i = 1; i < n; i++) {
			Team key = new Team(a[i].points);
			int j;
			for (j = i - 1; j >= 0 && a[j].compareTo(key) > 0; j--)
				swap(a, j, j + 1);
			a[j + 1] = key;
		}
	}
	
	static void swap(Object[] a, int i, int j) {
		Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	static int nextInt() throws IOException{
		in.nextToken();
		return (int)in.nval;
	}
	
	static String nextString() throws IOException {
		in.nextToken();
		return in.sval;
	}
	
	private static class Team {
		String name;
		int points, win, draw, lose, diff;
		
		public Team(int points) {
			this.points = points;
		}

		public int compareTo(Team compare) {
			//每次进行比较计数器count就加1
			count++;
			return points - compare.points;
		}
		
		public String toString() {
			return String.valueOf(points);
		}
	}
	
}


