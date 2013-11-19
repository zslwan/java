import java.util.Scanner;

public class Main {
	int m, n, p[];
	Scanner scan = new Scanner(System.in);

	void run() {
		n = scan.nextInt();
		m = scan.nextInt();
		p = new int[n + 1];
		int max = -1, sum = 0;
		for (int i = 1; i <= n; i++) {
			p[i] = scan.nextInt();
			sum += p[i];
			if (p[i] > max)
				max = p[i];
		}
		int left = max, right = sum, mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (test(mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(mid);
	}

	boolean test(int k) {
		int sum = 0, t = 0;
		for (int i = 1; i <= n; i++) {
			sum += p[i];
			if (sum > k) {
				sum = p[i];
				t++;
			}
		}
		t++;
		return t <= m;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}