

public class Doctor implements SeesPatients{
	
	private static int numDoctors = 0;
	private String name;
	private int licenseNumber;
	private Patient[] patients;
	private int numberOfPatients;
	
	public Doctor(String a) {
		name = a;
		patients = new Patient[100];
		licenseNumber = numDoctors + 1;
		numDoctors++;
		numberOfPatients = 0;
	}
	
	public static int getNumDoctors() {
		return numDoctors;
	}
	
	public int getLicenseNumber() {
		return licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	
	@Override
	public String toString() {
		String d = String.format("Doctor: name= %20s | license number= %06d | patients= %s", name, licenseNumber, getPatientsAsString());
		return d;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Doctor) {
			Doctor a = (Doctor)obj;
			if (name == a.name && licenseNumber == a.licenseNumber && patients == a.patients) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Object obj) {
		Doctor e = (Doctor) obj;
		return Integer.compare(this.numberOfPatients, e.numberOfPatients);
	}

	
	@Override
	public void addPatient(Patient a) throws PatientException {
		if (numberOfPatients == 100) {
			throw new PatientException("Cannot accept more than 100 patients.");
		}
		else if (numberOfPatients < 100) {
			patients[numberOfPatients] = a;
			numberOfPatients++;
		}
	
	}

	@Override
	public Patient[] getPatients() {
		return patients;
	}

	@Override
	public String getPatientsAsString() {
		String b = "patients= ";
		if (numberOfPatients > 0) {
			b = b + patients[0].toString();
			for (int i = 1; i<numberOfPatients; i++) {
				b = b + ", " + patients[i].toString();
			}
		}
		return b;
	}

	@Override
	public boolean isPatient(Patient a) {
		for (int i = 0; i<numberOfPatients; i++) {
			if (patients[i].equals(a)) {
				return true;
			}
		}
		return false;
	}

}
