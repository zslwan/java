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
		System.out.println("����ɸ�ӵ�����");
		int m = scan.nextInt();
		if(6>m||m>30)
		{ 
			System.out.print("�Բ������������룺");
		    m = scan.nextInt();
		}
		Random generator = new Random();
		int[] arr = new int[6];
		int arr2[] = new int[6];
		for(int i = 0;i < 6;i++)
			arr[i] = generator.nextInt(m)+1;
		System.out.println("��������������ɸ�ӵ���ֵ");
		for(int i=0;i<6;i++)
			{
			System.out.println("�������"+(i+1)+"ɸ�ӵ���ֵ");
			arr2[i] = scan.nextInt();
			if(arr2[i]>m)
				{
				 System.out.println("�Բ������ٴ�����");
			     arr2[i] = scan.nextInt();
                 i--;
                 }
            }
		System.out.print("������������     ");
		  for(int i = 0;i < 6;i++)
			  System.out.print(arr2[i]+"\t");
		      System.out.println();
		System.out.print("ɸ�ӵ���ֵ������      ");
		  for(int i = 0;i < 6;i++)
			System.out.print(arr[i]+"\t");
		    System.out.println();
		for(int i = 0;i<6;i++)
		{if(arr[i]==arr2[i])
			{
			System.out.println("��ϲ�����¶��˵�"+(i+1)+"ɸ�ӵ�ֵ");
			a++;
			n=n/m;
			}
		else
			{
			System.out.println("�Բ������´��˵�"+(i+1)+"ɸ�ӵ�ֵ");
			b++;
			n=n*(m-1)/m;
			}
		}
		if(a!=0)
		System.out.println("���¶���"+a+"��ɸ�ӵ�ֵ��\n��ĵ÷���"+(int)(1/n));
		else
			System.out.print("�Բ�����û�в¶�");
		
	}
}
