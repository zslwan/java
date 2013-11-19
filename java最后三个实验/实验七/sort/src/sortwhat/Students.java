package sortwhat;

import java.util.Scanner;

public class Students {
	public static void main(String[] arg) {
		String first, last, ID;
		Scanner scan = new Scanner(System.in);
		System.out.print("The students of the list:");
		int num = scan.nextInt();
		Content[] stu = new Content[num];
		for (int a = 0; a < num; a++) {
			System.out.print("student" + (a + 1) + "\t" + "firstname:");
			first = scan.next();
			System.out.print("student" + (a + 1) + "\t" + "lastname:");
			last = scan.next();
			System.out.print("student" + (a + 1) + "\t" + "ID:");
			ID = scan.next();
			stu[a] = new Content(first, last, ID);
		}
		System.out
				.print("What kind of ording do you prefer?(1-name 2-ID number):");
		int choose = scan.nextInt();
		if (choose == 1)
			Sortthisway.select(stu);
		if (choose == 2)
			Sortthisway.select2(stu);
		for (Content student : stu)
			System.out.println(student);
	}
}
