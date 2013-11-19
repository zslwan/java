import java.util.Calendar;
import java.util.Scanner;


public class Calendar_M {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int year,month;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份：");
		year = scan.nextInt();
		System.out.println("请输入月份：");
		month = scan.nextInt();
		
		Calendar cd = Calendar.getInstance();
		
		//设置日期为某年某月的第一天,得到这一天是星期几，一代表星期天，二代表星期一
		cd.set(year,month-1,1);
		int week = cd.get(Calendar.DAY_OF_WEEK);
		int len = week - 1;
		System.out.println("星期" + week);
		 
		//平年、闰年每月的天数
		int [] dayofP = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int [] dayofR =	new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		
		//当前这个月的总天数
		int dayofMonth;
		
		//判断是否为闰年
		if ((year%400==0) || (year%100!=0) && (year%4==0)){
			dayofMonth = dayofR[month-1];
		}else{
			dayofMonth = dayofP[month-1];
		}
		System.out.println("\t日\t一\t二\t三\t四\t五\t六");
		
		//一直到该月第一天打印\t
		for(int i=1;i<= len;i++){
			System.out.print("\t");
		}
		
		//到周六就换行
		int tmp = len;
		for(int i=1;i <= dayofMonth;i++){
			System.out.print("\t" + i);
			tmp++;
			if(tmp == 7){
				System.out.println();
				tmp = 0;
			}
		}
	}}