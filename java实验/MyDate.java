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
			
			int count=0;
			Scanner scan=new Scanner(System.in);
			int[] run={31,29,31,30,31,30,31,31,30,31,30,31};
			int[] ping={31,28,31,30,31,30,31,31,30,31,30,31};
			System.out.println("������ݣ�");
			year = scan.nextInt();
			System.out.println("�����·ݣ�");
			month = scan.nextInt();
			System.out.println("������ݣ�");
			day = scan.nextInt();
			
			System.out.println("����ǰ��������");
			Days = scan.nextInt();
			day=day+Days;
			while(month>12)
			{
				System.out.println("��������·��������������룺");
				month = scan.nextInt();
			}
			while((year % 400 == 0 || (year / 4 == 0 & year / 100 != 0)))
			{
				if(day<run[month-1])
				{
					if(day>0)
					{
						break;
					}	
					
					else 
					{
					  if(month>1)
					  {
					  month=month-1;
					  day=run[month-2]-Math.abs(day);
					  }	
					}
						
					break;
				
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
			while((year % 400 != 0 & (year / 4 != 0 || year / 100 == 0)))
			{
				if(day<ping[month-1])
				{
					break;				
				}
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
			
																					
			
			System.out.println("�����ڣ�"+year+"��"+month+"��"+day+"��");
		}
}
						 				
					
				