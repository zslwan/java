
public class Year {
    private int year;
	private int M[];
	public Year(int _year)
	{
		year = _year; 
	}

   public void judge() {
		int i = year % 400;
		int j = year % 4;
		int k = year % 100;
		int M1[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int M2[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((k == 0 & i == 0) || (i != 0 & j == 0)) {
			M = M2;
		} else {
			M = M1;
		}
	}
	public void cal(){
		 int m = ((year-1)+((year-1)/4-(year-1)/100+(year-1)/400))%7+1;
		 
		 for(int k = 1;k<=12;k++)
		 {
	      System.out.println(year+"-"+k);
		  System.out.println("日\t一\t二\t三\t四\t五\t六");
		  if(m!=7)
		  for(int j = 0;j<m;j++)
		  {
			    System.out.print(" \t");
		   }
		  for(int i = 1;i<=M[k];i++,m++)
		  {
			 System.out.print(i+"\t");
			 if(m==6||m==13)
				 {
				 System.out.println();
				 m=-1;
				 } 
		 }
		 System.out.println();
		 }
	}
}
