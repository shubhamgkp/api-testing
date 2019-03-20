package api.API_Testing;

public class BasicDetails {

	private String FirstName;
	private String LastName;
	private int Age;
	private EmpDetails EmpDet;
	private Address Adr;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public EmpDetails getEmpDet() {
		return EmpDet;
	}
	public void setEmpDet(EmpDetails empDet) {
		EmpDet = empDet;
	}
	public Address getAdr() {
		return Adr;
	}
	public void setAdr(Address adr) {
		Adr = adr;
	}
}
