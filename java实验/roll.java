import java.util.Random;
import java.util.Scanner;
public class roll {
	private static int n1;
	private static int n2;
	private static int n3;
	private static int n4;
	private static int n5;
	private static int n6;
	private static int x1;
	private static int x2;
	private static int x3;
	private static int x4;
	private static int x5;
	private static int x6;
	public void roll1(){
		
		
		Random a=new Random();
		
		n1=a.nextInt(31);
		n2=a.nextInt(31);
		n3=a.nextInt(31);
		n4=a.nextInt(31);
		n5=a.nextInt(31);
		n6=a.nextInt(31);
		System.out.println("开奖数值是: "+n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);
	}
	 public void player(){
		 int i=1,n;
		 Scanner scan1=new Scanner(System.in);
		 System.out.print("Enter the number of players:");
		 n=scan1.nextInt();
		 while(i<=n){
			 Scanner scan2=new Scanner(System.in);
			 System.out.print("player"+i+" Enter your number:");

			 x1=scan2.nextInt();
			 x2=scan2.nextInt();
			 x3=scan2.nextInt();
			 x4=scan2.nextInt();
			 x5=scan2.nextInt();
			 x6=scan2.nextInt();
			
			 int a1,a2,a3,a4,a5,a6;
			    a1=x1-n1;
			    a2=x2-n2;
			    a3=x3-n3;
			    a4=x4-n4;
			    a5=x5-n5;
			    a6=x6-n6;
			    int k1,k2,k3,k4,k5,k6,k;
			    
			    if (a1==0)
			    	k1=0;
			    else 
			    	k1=1;
			    if (a2==0)
			    	k2=0;
			    else 
			    	k2=1;
			    if (a3==0)
			    	k3=0;
			    else 
			    	k3=1;
			    if (a4==0)
			    	k4=0;
			    else 
			    	k4=1;
			    if (a5==0)
			    	k5=0;
			    else 
			    	k5=1;
			    if (a6==0)
			    	k6=0;
			    else 
			    	k6=1;
			   k=(k1+1)*(k2+1)*(k3+1)*(k4+1)*(k5+1)*(k6+1);
			   switch(k){
			   case 1:
			   System.out.println("得分是6");
			   break;
			   case 2:
				   System.out.println("得分是5");
				   break;
			   case 4:
				   System.out.println("得分是4");
				   break;
			   case 8:
				   System.out.println("得分是3");
				   break;
			   case 16:
				   System.out.println("得分是2");
				   break;
			   case 32:
				   System.out.println("得分是1");
				   break;
			   case 64:
				   System.out.println("得分是0");
				   break;}
				  
			i++;	       
		 }
		 
		  
	 }
	
		  
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    roll number;
    number=new roll();
    number.roll1();
    roll player;
    player=new roll();
    player.player();
    
 
    	
  
    
    
    
    
    
     
	}

}
