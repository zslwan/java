import java.util.Calendar;
import java.util.Scanner;


public class Calendar_M {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int year,month;
		Scanner scan = new Scanner(System.in);
		System.out.println("��������ݣ�");
		year = scan.nextInt();
		System.out.println("�������·ݣ�");
		month = scan.nextInt();
		
		Calendar cd = Calendar.getInstance();
		
		//��������Ϊĳ��ĳ�µĵ�һ��,�õ���һ�������ڼ���һ���������죬����������һ
		cd.set(year,month-1,1);
		int week = cd.get(Calendar.DAY_OF_WEEK);
		int len = week - 1;
		System.out.println("����" + week);
		 
		//ƽ�ꡢ����ÿ�µ�����
		int [] dayofP = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int [] dayofR =	new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		
		//��ǰ����µ�������
		int dayofMonth;
		
		//�ж��Ƿ�Ϊ����
		if ((year%400==0) || (year%100!=0) && (year%4==0)){
			dayofMonth = dayofR[month-1];
		}else{
			dayofMonth = dayofP[month-1];
		}
		System.out.println("\t��\tһ\t��\t��\t��\t��\t��");
		
		//һֱ�����µ�һ���ӡ\t
		for(int i=1;i<= len;i++){
			System.out.print("\t");
		}
		
		//�������ͻ���
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