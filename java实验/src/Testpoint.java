

public class Testpoint{
      public static void main(String[] args){
	  point p=new point(1.0,2.0,3.0);
	  point p1=new point(0.0,0.0,0.0);
	  System.out.println(p.getDistance(p1));
	  p.setx(5.0);
	  System.out.println(p.getDistance(new point(2.0,2.0,2.0)));
	  }
	}


