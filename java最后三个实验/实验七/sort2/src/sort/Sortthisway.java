package sort;

public class Sortthisway {


	public static void select(double[] list) {
			int min=0;double temp;
		for (int index = 0; index < list.length; index++) {
			min = index;
			for (int scan = index + 1; scan < list.length; scan++) {
				if (list[scan]<list[min]) {
					min = scan;
					temp = list[min];
					list[min] = list[index];
					list[index] = temp;
					min--;
				}

			}
		}

	}
}
