package five;
public class Date {
	private int year;
	private int month;
	private int day;
	private int M[];
	private static int d0;
	private static Date date = new Date(d0, d0, d0);

	public Date(int a, int b, int c) {
		year = a;
		month = b;
		day = c;
	}

	public void caldate(Date date) {
		this.judge();
		date.judge();
		if (year - date.year == 0) {
			if (month - date.month == 0) {
				System.out.println("相差的天数" + Math.abs(day - date.day));
			} else {
				int calmonth = 0;
				if (month > date.month) {
					for (int i = date.month + 1; i <= month - 1; i++)
						calmonth = date.M[i] + calmonth;
					System.out.println("相差的天数"
							+ (calmonth + date.M[date.month] - date.day + day));
				}
				else {
					for (int i = month + 1; i <= date.month - 1; i++)
						calmonth = date.M[i] + calmonth;
					System.out.println("相差的天数"
							+ (calmonth + M[month] - day + date.day));
				}
			}
		} else {
			int calyear = 0;
			if (year > date.year) {
				for (int i = date.year + 1; i <= year - 1; i++) {
					date.year = i;
					calyear = cal(date) + calyear;
				}
				int calmonth = 0;
				for (int i = date.month + 1; i <= 12; i++)
					calmonth = date.M[i] + calmonth;
				for (int i = 1; i <= month - 1; i++)
					calmonth = M[i] + calmonth;
				System.out
						.println("相差的天数"
								+ (calyear + calmonth + date.M[date.month]
										- date.day + day));
			} 
			else {
				for (int i = year + 1; i <= date.year - 1; i++) {
					year = i;
					calyear = cal(this) + calyear;
				}
				int calmonth = 0;
				for (int i = month + 1; i <= 12; i++)
					calmonth = date.M[i] + calmonth;
				for (int i = 1; i <= date.month - 1; i++)
					calmonth = M[i] + calmonth;
				System.out.println("相差的天数"
						+ (calyear + calmonth + M[month] - day + date.day));
			}
		}
	}

	public int cal(Date date) {
		date.judge();
		int a = 365;
		int b = 366;
		int c = 0;
		if (date.M[2] == 28)
			c = a;
		if (date.M[2] == 29)
			c = b;
		return c;
	}

	public int getyear() {
		return this.year;
	}

	public int getmonth() {
		return this.month;
	}

	public int getday() {
		return this.day;
	}

	private int[] judge() {
		int i = year % 400;
		int j = year % 4;
		int k = year % 100;
		int M1[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int M2[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((k == 0 & i == 0) || (i != 0 & j == 0)) {
			M = M2;
			return M2;
		} else {
			M = M1;
			return M1;
		}
	}

	public Date rudDate(int d) {
		this.judge();
		if (d <= this.day) {
			date.day = day - d;
			date.month = month;
			date.year = year;
		} else {
			rud(d);
		}
		return date;
	}

	private void add(int d) {
		int leaday = -day;
		int j = 0;
		for (int i = month; i <= 12; i++, j++) {
			leaday = M[this.month + j] + leaday;
			if (d <= leaday) {
				date.month = month + j;
				date.day = M[i] - (leaday - d);
				date.year = year;
				i = 13;
			}
		}
		if (d > leaday) {
			for (int i = 1; d > leaday; i++) {
				date.year = this.year + i;
				date.judge();
				for (int o = 1; d > leaday && o != 13; o++) {
					leaday = leaday + date.M[o];
					if (d <= leaday) {
						date.day = date.M[o] - (leaday - d);
						date.month = o;
					}
				}

			}
		}
	}

	public Date addDate(int d) {
		this.judge();
		if (d <= M[month] - day) {
			date.day = day + d;
			date.month = month;
			date.year = year;
		} else {
			this.add(d);
		}
		return date;
	}

	private void rud(int d) {
		int leaday = day;
		int j = 1;
		for (int i = month - 1; i >= 1; i--, j++) {
			int k = d - leaday;
			leaday = M[month - j] + leaday;
			if (d <= leaday) {
				date.month = month - j;
				date.day = M[i] - k;
				date.year = year;
				i = 0;
			}
		}
		if (d > leaday) {
			for (int i = 1; d > leaday; i++) {
				date.year = year - i;
				date.judge();
				for (int o = 12; d > leaday && o != 0; o--) {
					int k = d - leaday;
					leaday = leaday + date.M[o];
					if (d <= leaday) {
						date.day = date.M[o] - k;
						date.month = o;
					}
				}

			}
		}

	}

}
