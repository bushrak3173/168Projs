public class Car extends Vehicle implements Comparable<Car>, Announcements{
	private int numDoors;
	private int numWindows;
	
	public Car(int numDoors, int numWindows) {
		super(2, 2);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public Car(int numDoors, int numWindows, int numSeatsPerRow) {
		super(2, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public boolean canOpenDoor(Person p) {
		if((2 * numberOfRows) > numDoors) {
			for(int i = 0; i < (numberOfRows / 2); i++) {
				for(int j = 0; j < numSeatsPerRow.length; j++) {
					if((p != null) && (p.getAge() > 5)) {
						if(personsOnBoard[i][j] == p) {
							if(j == 0 || i == numSeatsPerRow.length - 1) {
								return true;
							}
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow.length; j++) {
					if ((p != null) && (p.getAge() > 5)) {
						if (personsOnBoard[i][j] == p) {
							if (j == 0 || i == numSeatsPerRow.length - 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	public boolean canOpenWindow(Person p) {
		if((2 * numberOfRows) > numWindows) {
			for(int i = 0; i < (numberOfRows / 2); i++) {
				for(int j = 0; j < numSeatsPerRow.length; j++) {
					if((p != null) && (p.getAge() > 5)) {
						if(personsOnBoard[i][j] == p) {
							if(j == 0 || i == numSeatsPerRow.length - 1) {
								return true;
							}
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow.length; j++) {
					if ((p != null) && (p.getAge() > 2)) {
						if (personsOnBoard[i][j] == p) {
							if (j == 0 || i == numSeatsPerRow.length - 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	public int getNumDoors() {
		return numDoors;
	}
	public int getNumWindows() {
		return numWindows;
	}
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(o instanceof Car) {
			Car otherCar = (Car) o;
			if(getNumDoors() == otherCar.getNumDoors() && getNumWindows() == otherCar.getNumWindows() && this.numberOfRows == otherCar.numberOfRows && this.maxSeatsPerRow == otherCar.maxSeatsPerRow && numSeatsPerRow(otherCar) == true) {
				return true;
			}
		}
		return false;
	}
	public boolean numSeatsPerRow(Car otherCar) {
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(numSeatsPerRow[i] != otherCar.numSeatsPerRow[i]) {
					return false;
				}
			}
		}
		return true;
	}
	public String toString() {
		String s = "";
		s = String.format("Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\n", this.numDoors, this.numWindows, this.numberOfRows, seatString(), personString());
		return s;
	}
	public String seatString() {
		String s = "";
		for(int i = 0; i < numberOfRows; i++) {
			s = s + numSeatsPerRow[i];
		}
		return s;
	}
	public String personString() {
		String s = "";
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					s = s + personsOnBoard[i][j].toString();
				}
				if (i < numberOfRows && j < numSeatsPerRow.length) {
					s = s + ", ";
				}
			}
		}
		return s;
	}
	@Override
	public int compareTo(Car c) {
		int a = 0;
		int b = 0;
		for(int i = 0; i < numberOfRows; i++) {
			a = a + numSeatsPerRow[i];
		}
		for(int i = 0; i < c.numberOfRows; i++) {
			b = b + c.numSeatsPerRow[i];
		}
		if (c != null && c instanceof Car) {
			if (a < b) {
				return -1;
			} else if (a == b) {
				return 0;
			} else {
				return 1;
			}
		}
		return -1;
	}

	@Override
	public boolean loadPassenger(Person p) {
		if(p == null) {
			return false;
		}
		else {
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numSeatsPerRow.length; j++) {
					if ((p.getAge() < 5) || (p.getHeight() < 36) && i == 0) {
						if (personsOnBoard[i + 1][j] == null) {
							personsOnBoard[i + 1][j] = p;
							return true;
						}
					} else {
						if (personsOnBoard[i][j] == null) {
							personsOnBoard[i][j] = p;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int count = 0;
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow.length; j++) {
				if((peeps[i].getAge() < 5) || (peeps[i].getHeight() < 36) && i == 0) {
					if(personsOnBoard[i + 1][j] == null) {
						personsOnBoard[i + 1][j] = peeps[i];
						count++;
					}
				}
				else {
					if(personsOnBoard[i][j] == null) {
						personsOnBoard[i][j] = peeps[i];
						count++;
					}
				}
			}
		}
		
		return count;
	}

	@Override
	public String departure() {
		String s = "All Aboard\n";
		return s;
	}

	@Override
	public String arrival() {
		String s = "Everyone Out\n";
		return s;
	}

	@Override
	public String doNotDisturbTheDriver() {
		String s = "No Backseat Driving\n";
		return s;
	}
	

}