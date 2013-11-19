import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SortObject {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {	
		in = new Scanner(new File("board.txt"));
		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("out.txt"))));
		
		int n = 20;
		Team[] teams = new Team[n];
		for (int i = 0; i < n; i++) {
			teams[i] = new Team(in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		}
		
		Arrays.sort(teams);f
		//insertionSort(teams, n);
		//mergeSort(teams, 0, n - 1);
		
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
			//Team key = new Team(a[i].name, a[i].win, a[i].draw, a[i].lose, a[i].diff, a[i].points);
			int j;
			for (j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--)
				swap(a, j, j - 1);
		}
	}
	
	static void swap(Team[] a, int i, int j) {
		Team tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static class Team implements Comparable<Team> {
		String name;
		int points, win, draw, lose, diff;
		
		public Team(int points) {
			this.points = points;
		}
		
		public Team(String name, int win, int draw, int lose, int diff, int points) {
			this.name = name;
			this.win = win;
			this.lose = lose;
			this.diff = diff;
			this.points = points;
		}
		
		public int compareTo(Team compare) {
			//每次进行比较计数器count就加1
			if (points == compare.points)
				return compare.diff - diff;
			return compare.points - points;
		}
		
		public String toString() {
			return name + "\t" + win + "\t" + draw + "\t" + lose + "\t" + diff + "\t" + points;
		}
	}
	
}


