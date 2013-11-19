
public class switch1 {
	public int year;
	public int month;
	public int day;
	public int Days;
  

	public String fa1(int year,int month,int day,int Days) {
	
	switch (1)
	{
		case 1:
			if ((day + Days) <= 31)//31
			{
				
				if(month==2)
				{
					int s=day-29;
					if(s>0)
					{
						month=month+1;
						day=s;
					}								
				}
				else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
				{
					day = day + Days;
				}
				else
				{
					if(day + Days==31)
					{
					day = day + Days-1;
					month=month+1;					 
					}
				}
			
				break;
			}
			
			else if (((day + Days) > 31) & ((day + Days) <= 60))//29
			{ 
			
			  if(month==2)
			  {
				day=day+Days;
				int s=day-29;
				if(s>0)
				{
					month = month + 1;
					day=s;
				}  
				
			  }						    
			  if(month>12)
			  {
				month=month-12;
				year=year+1;
			  }
			  else
			  {
				day = day+Days - 31;
				month = month + 1;	
				if(month>12)
				{
					month=month-12;
					year++;
				}
			  }
			   break;
			}
			else if (((day + Days) > 60) & ((day + Days) <= 91))//31
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
			else if(((day + Days)>91)&((day + Days)<=121))//30
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
			else if(((day + Days)>121)&((day + Days)<=152))//31
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
			else if(((day + Days)>152)&((day + Days)<=182))//30
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
			else if(((day + Days)>182)&((day + Days)<=213))//31
			{
				month=month+6;
				if(month>12)
				{
					month=month-12;
					year=year+1;
				}
				
				day=day+Days-182;
				break;
			}else if(((day + Days)>213)&((day + Days)<=244))//31
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
			else if(((day + Days)>244)&((day + Days)<=274))//30
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
			else if(((day + Days)>274)&((day + Days)<=305))//31
			{
				month=month+9;
				if(month>12)
				{
					month=month-12;
				}
				
				day=day+Days-274;
				break;
			}
			else if(((day + Days)>305)&((day + Days)<=335))//30
			{
				month=month+10;
				if(month>12)
				{
					month=month-12;
				}
				
				day=day+Days-305;
				break;
			}
			else if(((day + Days)>335)&((day + Days)<=366))//31
			{
				month=month+11;
				if(month>12)
				{
					month=month-12;
					year=year+1;
				}
				day=day+Days-335;
				break;
			} 
			
			
	}
	return "ĞÂÈÕÆÚ£º"+year+"."+month+"."+day;
	}
	}
