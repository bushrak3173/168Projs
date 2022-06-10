
public class Gerontologist extends Doctor {
	private boolean performsHouseCalls = true;
	private double visitFee = 0.0;
	
	public Gerontologist(String a) {
		super(a);
		performsHouseCalls = true;
		visitFee = 0.0;
	}
	
	Gerontologist(String name, boolean performsHouseCalls, double visitFee){
		super(name);
		this.performsHouseCalls = performsHouseCalls;
		this.visitFee = visitFee;
	}
	
	public boolean performsHouseCalls() {
		if (performsHouseCalls) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double getVisitFee() {
		return visitFee;
	}
	
	public void setPerformsHouseCalls(boolean a) {
		performsHouseCalls = a;
	}
	
	public void setVisitFee(double a) {
		visitFee = a;
	}
	
	@Override
	public void addPatient(Patient a ) throws PatientException{
		if (2020 - a.getBirthYear() > 65) {
			super.addPatient(a);
		}
		else {
			throw new PatientException("Age of patient is 65 or below.");
		}
	}
	
	public String toString() {
		String a = super.toString();
		String b = String.format( "\nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
		return a + b;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Gerontologist) {
			Gerontologist a = (Gerontologist)obj;
			if (super.equals(obj) == true) {
				if (this.performsHouseCalls == a.performsHouseCalls && this.visitFee == a.getVisitFee()) {
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