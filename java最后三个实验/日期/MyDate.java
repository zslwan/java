package five;
import java.util.Scanner;



public class MyDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��");
		int year = scan.nextInt();
		
		System.out.println("��");
		int month = scan.nextInt();
		
		System.out.println("��");
		int day = scan.nextInt();
		
		System.out.println("����\"-1\"������      ����\"+1\"��ǰ��      ����\"0\"���������ڲ�");
		int m = scan.nextInt();
	    Date date1 = new Date(year,month,day);
	    Date date2;

		switch (m)
		{
			case -1:
			System.out.println("��������");
		    int d = scan.nextInt();
		    date2 = date1.rudDate(d);
			System.out.print(date2.getyear()+"-"+date2.getmonth()+"-"+date2.getday());
		    break;
			case +1:
		    System.out.println("ǰ������");
			int d1= scan.nextInt();
		    date2 = date1.addDate(d1);
			System.out.print(date2.getyear()+"-"+date2.getmonth()+"-"+date2.getday());
			break;
			case 0:
			System.out.print("��");
			int year0 = scan.nextInt();
			System.out.print("��");
			int month0 = scan.nextInt();
			System.out.print("��");
			int day0 = scan.nextInt();
		    Date date0 = new Date(year0,month0,day0);
		    date1.caldate(date0);
			break;
		}
	}
}
