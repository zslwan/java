package five;
import java.util.Scanner;



public class MyDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("年");
		int year = scan.nextInt();
		
		System.out.println("月");
		int month = scan.nextInt();
		
		System.out.println("日");
		int day = scan.nextInt();
		
		System.out.println("输入\"-1\"来后退      输入\"+1\"来前进      输入\"0\"来计算日期差");
		int m = scan.nextInt();
	    Date date1 = new Date(year,month,day);
	    Date date2;

		switch (m)
		{
			case -1:
			System.out.println("后退天数");
		    int d = scan.nextInt();
		    date2 = date1.rudDate(d);
			System.out.print(date2.getyear()+"-"+date2.getmonth()+"-"+date2.getday());
		    break;
			case +1:
		    System.out.println("前进天数");
			int d1= scan.nextInt();
		    date2 = date1.addDate(d1);
			System.out.print(date2.getyear()+"-"+date2.getmonth()+"-"+date2.getday());
			break;
			case 0:
			System.out.print("年");
			int year0 = scan.nextInt();
			System.out.print("月");
			int month0 = scan.nextInt();
			System.out.print("日");
			int day0 = scan.nextInt();
		    Date date0 = new Date(year0,month0,day0);
		    date1.caldate(date0);
			break;
		}
	}
}
