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
			int count=0;
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
			
						 				
					
				
				while((day+Days)>=365)
				{
						 
				   if((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
					  { 
				    	int q=day+Days;
				    	    day=q-366;
				    	    Days=0;
				    	    year++;
				    	    if(day>366)
				    	    {
   				    	    count++;
   				    	    }
				      }
				   else
				   {
					   int q=day+Days;
					   day=q-365;
					   Days=0;
					   year++;
					   if(day>365)
					   {
					   count++;
					   }
				   }
			    }
				if((year%400==0||(year/4==0&year/100!=0)))
				{
					day=day-count;
					m=abc.fa1(year, month, day, Days);
				}
				else
				{   
					day=day-count+1;
					m=ABC.fa2(year, month, day, Days);
				}
				
				    																																																		
				
		
			
			System.out.print(m);	
}}
