import java.util.Scanner;


public class zhouchar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String information;
		System.out.println("enter you information:");
		information=scan.nextLine();
		int count=0,number=0;
		int n=information.length();
		
		for(int i=0;i<n;i++)
		{
	    char m=information.charAt(i);
		 		
		  if(m=='.'||m=='!'||m=='?')
		  {count++;
		  }
		
		char s=information.charAt(i);
		  if(s==' '||s=='!'||s=='?'||s=='.')
		  {number++;
		  }
		}
								
		
		
		System.out.println("the sentence has:"+count);
		System.out.println("the length is :"+n);
        System.out.println("the number is:"+number);

	}

}
