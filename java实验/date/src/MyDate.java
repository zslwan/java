import java.util.Scanner;


public class MyDate {
	

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stubScanner scan =new Scanner(System.in);
			int year;
			int month;
			int day;String m="";
			Scanner scan=new Scanner(System.in);
			switch1 abc=new switch1();
			switch2 ABC=new switch2();
			System.out.println("输入年份：");
			year = scan.nextInt();
			System.out.println("输入月份：");
			month = scan.nextInt();
			System.out.println("输入天份：");
			day = scan.nextInt();
			int Days;
			System.out.println("输入前进天数：");
			Days = scan.nextInt();
			if(month<=12)
			{
			    if (year % 400 == 0 || (year / 4 == 0 & year / 100 != 0))
				{
				m=abc.fa1(year,month,day,Days);
				}
			
			    else 
			    {
				m=ABC.fa2(year,month,day,Days);
				}
													
			}	
				System.out.print(m);		 					
						 				
			}
			
		}
		
