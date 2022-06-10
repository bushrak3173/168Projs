public abstract class Vehicle {
	protected Person[][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int[] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatsPerRow) {
		this.numberOfRows = numRows;
		this.numSeatsPerRow = new int[numSeatsPerRow];
		personsOnBoard = new Person[numberOfRows][numSeatsPerRow];
	}
	public Vehicle(int[] numSeatsPerRow) {
		this.numberOfRows = numSeatsPerRow.length;
		this.numSeatsPerRow = numSeatsPerRow;
		for(int i = 0; i < numSeatsPerRow.length; i++) {
			personsOnBoard = new Person[numberOfRows][numSeatsPerRow[i]];
		}
	}
	public Vehicle(Person driver, int[] numSeatsPerRow) {
		this.numberOfRows = numSeatsPerRow.length;
		this.numSeatsPerRow = numSeatsPerRow;
		for(int i = 0; i < numSeatsPerRow.length; i++) {
			personsOnBoard = new Person[numberOfRows][numSeatsPerRow[i]];
		}
		if(driver.hasDriverLicense() == true) {
			personsOnBoard[0][0] = driver;
		}
	}
	public abstract boolean loadPassenger(Person p);
	public abstract int loadPassengers(Person[] peeps);
	
	public void setDriver(Person p) throws InvalidDriverException {
		if(p.hasDriverLicense() == true) {
			personsOnBoard[0][0] = p;
		}
		else if(p.hasDriverLicense() == false){
			throw new InvalidDriverException("Person must have a driver license in order to drive.");
		}
		else {
			throw new InvalidDriverException();
		}
	}
	public Person getDriver() {
		if (personsOnBoard[0][0] != null) {
			return personsOnBoard[0][0];
		}
		else {
			return null;
		}
	}
	public boolean hasDriver() {
		if (personsOnBoard[0][0] != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getNumberOfAvailableSeats() {
		int count = 0;
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] == null) {
					count++;
				}
			}
		}
		return count;
	}
	public int getNumberOfAvailableSeatsInRow(int row) {
		int count = 0;
		if(row < 0 || row > numberOfRows) {
			return -1;
		}
		for(int i = row; i < row; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] == null) {
					count++;
				}
			}
		}
		return count;
	}
	public int getNumberOfPeopleOnBoard() {
		int count = 0;
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow.length; j++) {
				if(personsOnBoard[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}
	public int getNumberOfPeopleInRow(int row) {
		int count = 0;
		if(row < 0 || row > numberOfRows) {
			return -1;
		}
		for(int i = row; i < row; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}
	public Person getPersonInSeat(int row, int col) {
		if (personsOnBoard[row][col] != null) {
			return personsOnBoard[row][col];
		}
		else {
			return null;
		}
	}
	public int[] getLocationOfPersonInVehicle(Person p) {
		int[] c = new int[1];
		boolean found = false;
		int i = 0;
		int j = 0;
		for(i = 0; i < numberOfRows; i++) {
			for(j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					if(personsOnBoard[i][j] == p) {
						c[0] = i;
						c[1] = j;
						found = true;
					}
				}
			}
		}
		if((i == numberOfRows && j == numSeatsPerRow.length) && found == false) {
			c[0] = -1;
			c[1] = -1;
		}
		return c;
	}
	public Person[] getPeopleInRow(int row) {
		Person[] p = new Person[row];
		for(int i = row; i < row; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					p[j] = personsOnBoard[i][j];
				}
			}
		}
		return p;
	}
	public Person[][] getPeopleOnBoard() {
		Person[][] clone = new Person[numberOfRows][numSeatsPerRow.length];
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					if(personsOnBoard[i][j] != null) {
						clone[i][j] = personsOnBoard[i][j];
					}
				}
			}
		}
		return clone;
	}
	public boolean isPersonInVehicle(Person p) {
		for(int i = 0; i < numberOfRows; i++) {
			for(int j = 0; j < numSeatsPerRow[i]; j++) {
				if(personsOnBoard[i][j] != null) {
					if(personsOnBoard[i][j] == p) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean isPersonDriver(Person p) {
		if(p != null && personsOnBoard[0][0] == p) {
			return true;
		}
		else {
			return false;
		}
	}
}