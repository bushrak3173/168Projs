public class Person {
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;
	
	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public boolean hasDriverLicense() {
		return hasDriverLicense;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public Person clone() {
		Person clone = new Person(this.name, this.hasDriverLicense, this.age, this.height);
		return clone;
	}
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(o instanceof Person) {
			Person otherPerson = (Person) o;
			if(getName() == otherPerson.getName() && hasDriverLicense() == otherPerson.hasDriverLicense() && getAge() == otherPerson.getAge() && getHeight() == otherPerson.getHeight()) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		String s = "";
		s = String.format("Person [name= %10s | age= %02d | height= %02d | %s]", name, age, height, (hasDriverLicense ? "has license" : "no license"));
		return s;
	}
}