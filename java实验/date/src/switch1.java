
public class switch1 {
	public int year;
	public int month;
	public int day;
	public int Days;
  

	public String fa1(int year,int month,int day,int Days) {
	
	switch (1)
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
			else{
			int n=0;
			while((day+Days)>365){
				{ 						
				  n=(day+Days)-36;	
					year++;											 
				 day = n;Days=0;
				}
				break;
			}	
			}
	}
	return "�����ڣ�"+year+"."+month+"."+day;
	}
	}
