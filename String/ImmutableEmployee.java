package com.mypackage;

public final class ImmutableEmployee {              // Step 1 : Make class are final, so that no other class can extend it


	private final int empId;                        // Step 2 : Make all your fields are final , so that we can't modified the fields
	private final String empName;
	private final Address address;
	
	

	public ImmutableEmployee(int empId, String empName, Address address)
	{
		this.empId = empId;
		this.empName = empName;
	
		Address cloneaddress = new Address();                         // Step 4: - when modifying the state of teh class, you must always return a new object of the class
		cloneaddress.setLineNumber(address.getLineNumber());
		cloneaddress.setCity(address.getCity());
		cloneaddress.setZipcode(address.getZipcode());
		this.address = cloneaddress;
		
	}

	public int getEmpId() {                // Step 3 : - Don't expose setters methods
		return empId;
	}

	public String getEmpName() {
		return empName;
	}
	
	public Address getAddress() {        
         	Address cloneaddress = new Address();
		cloneaddress.setLineNumber(this.address.getLineNumber());
		cloneaddress.setCity(this.address.getCity());
		cloneaddress.setZipcode(this.address.getZipcode());
		return cloneaddress;                                           // step 5: - to always return a clone copy of the field and never return the real object instance.
		
		
	}
	
	
public static void main(String[] args) {
	
	Address address = new Address();                
	address.setLineNumber(937);
	address.setCity("NJ");
	address.setZipcode(12345);
	ImmutableEmployee employee = new ImmutableEmployee(514, "sai", address);
	System.out.println("The Employee ID & name:" +employee.getEmpId() + " "  +employee.getEmpName());
	System.out.println("sai address linenumber before modification:" +employee.getAddress().getLineNumber());
	System.out.println("sai address city before modification:" +employee.getAddress().getCity());
	System.out.println("sai address zipcode before modification:" + employee.getAddress().getZipcode());
	address.setLineNumber(723);
	address.setCity("TX");
	address.setZipcode(67893);
	ImmutableEmployee employee1 =new ImmutableEmployee(513, "devi", address);
	System.out.println("The Employee ID & name:" +employee.getEmpId() + " "  +employee.getEmpName());
	System.out.println("sai address linenumber after modification:" +employee.getAddress().getLineNumber());
	System.out.println("sai address city after modification:" +employee.getAddress().getCity());
	System.out.println("sai address zipcode after modification:" + employee.getAddress(). getZipcode());
	
}


}





