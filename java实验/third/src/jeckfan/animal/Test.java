package jeckfan.animal;

public class Test {
	public static void main(String[] args) {
		
		
		Room room = new Room();
		for(long i=0;i<10L;i++){
			room.add(new Person("tom"+i));
		}
		
		
		System.out.println("现在，room中已经有："+room.getSize()+"人！");
		
		
		room.add(new Person("新添加的数据"), 10);
		room.showRoom();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Person p1 = new Person("tom1");
		
		
		
		Person p2 = new Person("tom2");
		Person p3 = new Person("tom3");
		Person p4 = new Person("tom4");
		Person p5 = new Person("tom5");
		
		
		p1.setRighter(p2);
		p2.setRighter(p3);
		p3.setRighter(p4);
		p4.setRighter(p5);
		
		
		String name = p1.getRighter().getRighter().getRighter().getName();
		System.out.println(name);*/
		
	}
}
