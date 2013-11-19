package jeckfan.animal;

public class Room {
	private Person first;
	private int size;

	public void showRoom() {
		Person temp = first;

		while (temp != null) {
			System.out.println(temp.getName());
			temp = temp.getRighter();
		}
	}

	// 1
	public void add(Person p, int index) {
		if (index <= size) {
			if (first == null) {
				setFirst(p);
			} else {
				if (index == 0) {
					p.setRighter(first);
					first = p;
				} else {
					Person temp = first;
					Person temp2 = null;
					int x = 0;

					while (temp.getRighter() != null) {
						temp2 = temp;
						temp = temp.getRighter();
						x++;

						if (x == index) {
							p.setRighter(temp);
							temp2.setRighter(p);

						}
					}
				}
			}

		} else {
			System.out.println("想要添加的索引过大，添加失败");
		}

	}

	public void add(Person p) {
		if (first == null) {
			first = p;
			size++;
		} else {
			Person temp = first;
			while (temp.getRighter() != null) {
				temp = temp.getRighter();
			}

			temp.setRighter(p);
			size++;

		}
	}

	public Person getFirst() {
		return first;
	}

	public void setFirst(Person first) {
		this.first = first;
		size++;
	}

	public int getSize() {
		return size;
	}

}
