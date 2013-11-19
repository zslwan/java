package sort;

import java.util.Scanner;

public class Square {
	public static void main(String[] arg) {
		double length, width, squares;
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.print("How many rectangles do you have:");
		num=scan.nextInt();
		double[] square =new double[num];
		for (int a = 0; a < num; a++) {
			System.out.print("length:");
			length = scan.nextInt();
			System.out.print("width:");
			width = scan.nextInt();
			squares = length * width;
			System.out.println("square is:" + squares);
			square[a]=squares;
		}
		Sortthisway.select(square);
		for (double sqr : square) {
			num = 1;
			System.out.println("rectangles:" + num + "\t" + sqr);
			num++;
		}
	}
}
