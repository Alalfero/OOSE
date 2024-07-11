
record Date(int day, int month, int year) {

	int dayOfWeek() {
		if (month() <= 2)
			return (int) (day + (2.6 * ((month + 2) % 12) - 0.2) + (year - 1) % 100 + (((year - 1) % 100) / 4) + (((year - 1) / 100) / 4) - 2 * ((year - 1) / 100)) % 7;
		return (int) (day + (2.6 * ((month + 10) % 12) - 0.2) + year % 100 + ((year % 100) / 4) + ((year / 100) / 4) - 2 * (year / 100)) % 7;

	}

	Date mothersDay() {
		int firstDay = 1;
		Date testDate = new Date(firstDay, 5, year);
		while (testDate.dayOfWeek() != 0) {
			testDate = new Date(firstDay, 5, year);
			testDate.dayOfWeek();
			firstDay++;
		}
		return year < 2000 ? new Date(testDate.day + 7, 5, year) : new Date(testDate.day + 8, 5, year);

	}

}