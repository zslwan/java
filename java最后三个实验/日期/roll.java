package five;

import java.util.Random;
import java.util.Scanner;

public class roll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method s
		int a = 0,b = 0;double n = 1.0;
		Scanner scan = new Scanner(System.in);
		System.out.println("输入筛子的面数");
		int m = scan.nextInt();
		if(6>m||m>30)
		{ 
			System.out.print("对不起，请重新输入：");
		    m = scan.nextInt();
		}
		Random generator = new Random();
		int[] arr = new int[6];
		int arr2[] = new int[6];
		for(int i = 0;i < 6;i++)
			arr[i] = generator.nextInt(m)+1;
		System.out.println("请依次您猜六个筛子的面值");
		for(int i=0;i<6;i++)
			{
			System.out.println("请输入第"+(i+1)+"筛子的面值");
			arr2[i] = scan.nextInt();
			if(arr2[i]>m)
				{
				 System.out.println("对不起，请再次输入");
			     arr2[i] = scan.nextInt();
                 i--;
                 }
            }
		System.out.print("您依次输入了     ");
		  for(int i = 0;i < 6;i++)
			  System.out.print(arr2[i]+"\t");
		      System.out.println();
		System.out.print("筛子的数值依次是      ");
		  for(int i = 0;i < 6;i++)
			System.out.print(arr[i]+"\t");
		    System.out.println();
		for(int i = 0;i<6;i++)
		{if(arr[i]==arr2[i])
			{
			System.out.println("恭喜，您猜对了第"+(i+1)+"筛子的值");
			a++;
			n=n/m;
			}
		else
			{
			System.out.println("对不起，您猜错了第"+(i+1)+"筛子的值");
			b++;
			n=n*(m-1)/m;
			}
		}
		if(a!=0)
		System.out.println("您猜对了"+a+"个筛子的值。\n你的得分是"+(int)(1/n));
		else
			System.out.print("对不起您没有猜对");
		
	}
}
