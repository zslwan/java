
import java.util.Scanner;


public class date {
	

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stubScanner scan =new Scanner(System.in);
			int year;
			int month;
			int day;
			Scanner scan=new Scanner(System.in);
			System.out.println("输入年份：");
			year = scan.nextInt();
			System.out.println("输入月份：");
			month = scan.nextInt();
			System.out.println("输入天份：");
			day = scan.nextInt();
			int Days;
			System.out.println("输入前进天数：");
			Days = scan.nextInt();
			if (year % 400 == 0 || (year / 4 == 0 & year / 100 != 0))
				
			{
				int m=1;
				switch (m)
				{
					case 1:
						if ((day + Days) <= 31)
						{
							day = day + Days;
							if(month==2)
							{
								day=day-29;
								if(day>0)
								{
									month=month+1;
								}								
							}
							break;
						}
						
						else if (((day + Days) > 31) & ((day + Days) <= 60))
						{
							month = month + 1;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							day =day+Days - 31;
							break;
						}
						else if (((day + Days) > 60) & ((day + Days) <= 91))
						{
							month = month + 2;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							day =day+Days - 60;
							break;
							
						}
						else if(((day + Days)>91)&((day + Days)<=122))
						{
							month=month+3;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-91;
							break;
						}
						else if(((day + Days)>122)&((day + Days)<=152))
						{
							month=month+4;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-122;
							break;
						
				        }
						else if(((day + Days)>152)&((day + Days)<=183))
						{
							month=month+5;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-152;
							break;
						}
						else if(((day + Days)>183)&((day + Days)<=213))
						{
							month=month+6;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-183;
							break;
						}else if(((day + Days)>213)&((day + Days)<=244))
						{
							month=month+7;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-213;
							break;
						}
						else if(((day + Days)>244)&((day + Days)<=275))
						{
							month=month+8;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-244;
							break;
						}
						else if(((day + Days)>275)&((day + Days)<=305))
						{
							month=month+9;
							if(month>12)
							{
								month=month-12;
							}
							
							day=day+Days-274;
							break;
						}
						else if(((day + Days)>305)&((day + Days)<=335))
						{
							month=month+10;
							if(month>12)
							{
								month=month-12;
							}
							
							day=day+Days-304;
							break;
						}
						else if(((day + Days)>335)&((day + Days)<=365))
						{
							month=month+11;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-334;
							break;
						}
					
						



			}



		}
			else 
			{
				switch (2)
				{
					case 2:
						if ((day + Days) <= 31)
						{
							day = day + Days;
							if(month==2)
							{
								day=day-28;
								if(day>0)
								{
									month=month+1;
								
								}
							}
							break;
						}
						
						else if (((day + Days) > 31) & ((day + Days) <= 59))
						{   int i = 0;
							
							if(month==2)
							{
								day=day+Days-28;
								i = 1;
							}
							    month = month + 1;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							if(i!=1)
								day = day+Days - 31;
							break;
						}
						else if (((day + Days) > 59) & ((day + Days) <= 90))
						{
							month = month + 2;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							day =day+ Days - 59;
							break;
							
						}
						else if(((day + Days)>90)&((day + Days)<=121))
						{
							month=month+3;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-90;
							break;
						}
						else if(((day + Days)>121)&((day + Days)<=151))
						{
							month=month+4;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-121;
							break;
						
				        }
						else if(((day + Days)>151)&((day + Days)<=182))
						{
							month=month+5;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-152;
							break;
						}
						else if(((day + Days)>182)&((day + Days)<=212))
						{
							month=month+6;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-182;
							break;
						}else if(((day + Days)>212)&((day + Days)<=243))
						{
							month=month+7;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-212;
							break;
						}
						else if(((day + Days)>243)&((day + Days)<=274))
						{
							month=month+8;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-243;
							break;
						}
						else if(((day + Days)>274)&((day + Days)<=304))
						{
							month=month+9;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-274;
							break;
						}
						else if(((day + Days)>304)&((day + Days)<=334))
						{
							month=month+10;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-304;
							break;
						}
						else if(((day + Days)>334)&((day + Days)<=364))
						{
							month=month+11;
							if(month>12)
							{
								month=month-12;
								year=year+1;
							}
							
							day=day+Days-334;
							break;
						}
						
					
							
				}
		    }
			System.out.println("新日期："+year+"."+month+"."+day);

	}


}



