
public class switch2 {
	public int year;
	public int month;
	public int day;
	public int Days;
	switch1 abc=new switch1();
  public String fa2(int year,int month,int day,int Days){
	
	  switch (2)
	{
		case 2:
			if ((day + Days) <= 31)//һ��31
			{
				day = day + Days;
				if(month==2)
				{
					int s=day-28;
					if(s>0)
					{
						month=month+1;
						day=s;
					}
					
				}
				break;
			}						
			else if (((day + Days) > 31) & ((day + Days) <= 59))//����28
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
			else if (((day + Days) > 59) & ((day + Days) <= 90))//����31
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
			else if(((day + Days)>90)&((day + Days)<=120))//����30
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
			else if(((day + Days)>120)&((day + Days)<=151))//����31
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
			else if(((day + Days)>151)&((day + Days)<=181))//����30
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
			else if(((day + Days)>182)&((day + Days)<=212))//����31
			{
				month=month+6;
				if(month>12)
				{
					month=month-12;
					year=year+1;
				}							
				day=day+Days-182;
				break;
			}else if(((day + Days)>212)&((day + Days)<=243))//����31
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
			else if(((day + Days)>243)&((day + Days)<=273))//����30
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
			else if(((day + Days)>273)&((day + Days)<=304))//ʮ��31
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
			else if(((day + Days)>304)&((day + Days)<=334))//ʮһ��30
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
			else if(((day + Days)>334)&((day + Days)<=365))//ʮ����31
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
	  return "�����ڣ�"+year+"."+month+"."+day;
	  }
  }