package sortwhat;

@SuppressWarnings("rawtypes")
public class Content implements Comparable {
	private String thefirst, thelast, theID;

	public Content(String first, String last, String ID) {
		thefirst = first;
		thelast = last;
		theID = ID;
	}

	public boolean equals(Object staff) {
		return (thelast.equals(((Content) staff).getThelast()) && thefirst
				.equals(((Content) staff).getThefirst()));
	}

	public int compareTo(Object staff) {
		int result;
		String stafffirst = ((Content) staff).getThefirst();
		String stafflast = ((Content) staff).getThelast();
		if (thelast.equals(stafflast))
			result = thefirst.compareTo(stafffirst);
		else
			result = thelast.compareTo(stafflast);
		return result;
	}

	public int compareTo2(Object staff) {
		int result;
		String staffID = ((Content) staff).getTheID();
		result = theID.compareTo(staffID);
		return result;
	}

	public String getThefirst() {
		return thefirst;
	}

	public String getThelast() {
		return thelast;
	}

	public String getTheID() {
		return theID;
	}

	public String toString() {
		return thefirst + "\t" + thelast + "\t" + theID;
	}

}
