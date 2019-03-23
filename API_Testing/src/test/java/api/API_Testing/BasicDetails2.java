package api.API_Testing;

public class BasicDetails2 {

	private String FirstName;
	private String LastName;
	private int Age;
	private EmpDetails2 EmpDet;
	private Address2 Adr[];
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
	public EmpDetails2 getEmpDet() {
		return EmpDet;
	}
	public void setEmpDet(EmpDetails2 empDet) {
		EmpDet = empDet;
	}
	public Address2[] getAdr() {
		return Adr;
	}
	public void setAdr(Address2[] adr) {
		Adr = adr;
	}
		
}
