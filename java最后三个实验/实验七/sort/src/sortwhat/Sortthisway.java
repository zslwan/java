package sortwhat;

public class Sortthisway {
	public static void select(Content[] list) {
		int min;
		Content temp;
		for (int index = 0; index < list.length; index++) {
			min = index;
			for (int scan = index + 1; scan < list.length; scan++) {
				if (list[scan].compareTo(list[min]) < 0) {
					min = scan;
					temp = list[min];
					list[min] = list[index];
					list[index] = temp;
					min--;
				}
			}

		}
	}

	public static void select2(Content[] list) {
		int min;
		Content temp;
		for (int index = 0; index < list.length; index++) {
			min = index;
			for (int scan = index + 1; scan < list.length; scan++) {
				if (list[scan].compareTo2(list[min]) < 0) {
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
