import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MakeData {
	
	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		in = new Scanner(System.in);
		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("in.txt"))));
		int n = in.nextInt();
		out.println(n);
		for (int i = 0; i < n; i++)
			out.println(Math.abs(rand.nextInt()));
		out.flush();
	}

}
