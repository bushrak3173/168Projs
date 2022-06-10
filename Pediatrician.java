

public class Pediatrician extends Doctor {

	private boolean hasPrivatePractice = false;
	private String hospitalName = "";
	
	public Pediatrician(String name) {
		super(name);
		hasPrivatePractice = false;
		hospitalName = "";
	}
	
	public Pediatrician(String name, boolean hasPrivatePractice, String hospitalName) {
		super(name);
		this.hasPrivatePractice = hasPrivatePractice;
		this.hospitalName = hospitalName;
	}
	
	public boolean hasPrivatePractice() {
		if (this.hasPrivatePractice) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String a ) {
		hospitalName = a;
	}
	
	@Override
	public void addPatient(Patient a) throws PatientException{
		if (2020 - a.getBirthYear() < 18) {
			super.addPatient(a);
		}
		else {
			throw new PatientException("Age of patient is 18 or above.");
		}
	}

	
	@Override
	public String toString() {
		String a = super.toString();
		String b = String.format("\nPediatrician: %s | hospital name=%15s", (hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
		return a + b;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj instanceof Pediatrician) {
			Pediatrician a = (Pediatrician)obj;
			if (super.equals(obj) == true) {
				if (hasPrivatePractice == a.hasPrivatePractice && this.hospitalName == a.hospitalName) {
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
		else {
			return false;
		}
	}
}