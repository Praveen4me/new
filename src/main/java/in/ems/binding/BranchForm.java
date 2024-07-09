package in.ems.binding;

public class BranchForm {
	 private Integer branch_Id;
	private String name;
	
	private String address;
	
	private String phone_number;
	
	 private String pincode;
	   private String parent_organization;
	 
	    private String state;
	    private String districts;
	    private String city;
	    private String email_id;
	    private String status;
	    private Integer organizationId;
	    
	    
		public BranchForm() {
			super();
			// TODO Auto-generated constructor stub
		}


		public BranchForm(Integer branch_Id, String name, String address, String phone_number, String pincode,
				String parent_organization, String state, String districts, String city, String email_id, String status,
				Integer organizationId) {
			super();
			this.branch_Id = branch_Id;
			this.name = name;
			this.address = address;
			this.phone_number = phone_number;
			this.pincode = pincode;
			this.parent_organization = parent_organization;
			this.state = state;
			this.districts = districts;
			this.city = city;
			this.email_id = email_id;
			this.status = status;
			this.organizationId = organizationId;
		}


		public Integer getBranch_Id() {
			return branch_Id;
		}


		public void setBranch_Id(Integer branch_Id) {
			this.branch_Id = branch_Id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getPhone_number() {
			return phone_number;
		}


		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}


		public String getPincode() {
			return pincode;
		}


		public void setPincode(String pincode) {
			this.pincode = pincode;
		}


		public String getParent_organization() {
			return parent_organization;
		}


		public void setParent_organization(String parent_organization) {
			this.parent_organization = parent_organization;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getDistricts() {
			return districts;
		}


		public void setDistricts(String districts) {
			this.districts = districts;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getEmail_id() {
			return email_id;
		}


		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public Integer getOrganizationId() {
			return organizationId;
		}


		public void setOrganizationId(Integer organizationId) {
			this.organizationId = organizationId;
		}
		
		
}
