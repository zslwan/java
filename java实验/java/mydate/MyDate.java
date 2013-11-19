import java.util.Scanner;


public class MyDate {
	

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stubScanner scan =new Scanner(System.in);
			int year;
			int month;
			int day;
			int Days;		
			Scanner scan=new Scanner(System.in);
			int[] run={31,29,31,30,31,30,31,31,30,31,30,31};
			int[] ping={31,28,31,30,31,30,31,31,30,31,30,31};
			System.out.println("输入年份：");
			year = scan.nextInt();
			System.out.println("输入月份：");
			month = scan.nextInt();
			System.out.println("输入天份：");
			day = scan.nextInt();
			
			System.out.println("输入前进天数：");
			Days = scan.nextInt();
			while(month>12)
			{
				System.out.println("昵输入的月份有误，请重新输入：");
				month = scan.nextInt();
			}
			if(Days>=0)
			{
			day=day+Days;
		
			while(day>=365)
			{
				if((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
				{
					if(month>2){
					day=day-365;
					year=year+1;}
					else{day=day-366;
					year=year+1;}
				}
				else
				{
					day=day-365;
					year=year+1;
				}
			}
			if((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
			{
				if(day<run[month-1])
				{
								
				}
				else 
				{
			      while(day>run[month-1])
			      {
					day=day-run[month-1];
					month++;
					if(month>12)
					{
						month=month-12;
						year++;
					}
					
				  }		       			
				}				
			}
			if((year % 400 != 0 & (year / 4 != 0 || year / 100 == 0)))
			{
				if(day<=ping[month-1])
				{}
							
				
				else 
				{
			      while(day>ping[month-1])
			      {
					day=day-ping[month-1];
					month++;
					if(month>12)
					{
						month=month-12;
						year++;
					}					
				  }
			   	       			
				}
			}	
			}
			else
			{
				
				day=day+Days;
				while(day<=-365)
				{
					if((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
					{
						day=day+366;
						year=year-1;
					}
					else
					{
						day=day+365;
						year=year-1;
					}
				}
				if((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
				{
				  if(day>0)
				  {
				
				  }
				  else if(day==0)
				  {
					day=run[month-1];
				  }
				  else
				  {
					  while(day<=0)
					  {
						  day=day+run[month-1];
						  month=month-1;
						  if(month<1)
						  {
							  month=month+12;
							  year=year-1;
						  }
					  }					
				  }
			    }
				else{

					if(day>0)
					  {
					
					  }
					  else if(day==0)
					  {
						day=run[month-1];
					  }
					  else
					  {
						  while(day<=0)
						  {
							  day=day+ping[month-1];
							 
							  if(month<1)
							  {
								  month=month+12;
								  year=year-1;
							  } 
							  month=month-1;
						  }					
					  }
				    
				    }
			}																
			
			System.out.println("新日期："+year+"年"+month+"月"+day+"日");
		}
}
						 				
					
				