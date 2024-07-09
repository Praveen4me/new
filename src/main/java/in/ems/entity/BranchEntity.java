package in.ems.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Branch")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branch_Id;

    @NotBlank(message = "Enter proper name")
    @Size(min = 3, message = "Name should be at least 3 characters")
    @Size(max = 20, message = "Name should not be greater than 20 characters")
    @Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$", message = "Name should contain only alphabets with an optional single space")
    private String name;

    @NotBlank(message = "Address name should not be Empty")
    private String address;

    @NotNull(message = "Mobile number must not be null.")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must start with a digit between 6 and 9 and be exactly 10 digits.")
    private String phone_number;
    
	private String createdBy;

	private LocalTime cratedAt;

	private String updateBy;

	private LocalTime updatedAt;
    
    private String status;
    private String parent_organization;
    private String pincode;
    private String state;
    private String districts;
    private String city;
    private String email_id;

    @CreationTimestamp
    private LocalDate createdDate;
    
    @CreationTimestamp
    private LocalTime createdTime;
    
    

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "organization_id")
    private Organization organization;



	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BranchEntity(Integer branch_Id,
			@NotBlank(message = "Enter proper name") @Size(min = 3, message = "Name should be at least 3 characters") @Size(max = 20, message = "Name should not be greater than 20 characters") @Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$", message = "Name should contain only alphabets with an optional single space") String name,
			@NotBlank(message = "Address name should not be Empty") String address,
			@NotNull(message = "Mobile number must not be null.") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must start with a digit between 6 and 9 and be exactly 10 digits.") String phone_number,
			String createdBy, LocalTime cratedAt, String updateBy, LocalTime updatedAt, String status,
			String parent_organization, String pincode, String state, String districts, String city, String email_id,
			LocalDate createdDate, LocalTime createdTime, Organization organization) {
		super();
		this.branch_Id = branch_Id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.createdBy = createdBy;
		this.cratedAt = cratedAt;
		this.updateBy = updateBy;
		this.updatedAt = updatedAt;
		this.status = status;
		this.parent_organization = parent_organization;
		this.pincode = pincode;
		this.state = state;
		this.districts = districts;
		this.city = city;
		this.email_id = email_id;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.organization = organization;
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



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public LocalTime getCratedAt() {
		return cratedAt;
	}



	public void setCratedAt(LocalTime cratedAt) {
		this.cratedAt = cratedAt;
	}



	public String getUpdateBy() {
		return updateBy;
	}



	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}



	public LocalTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getParent_organization() {
		return parent_organization;
	}



	public void setParent_organization(String parent_organization) {
		this.parent_organization = parent_organization;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
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



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public LocalTime getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(LocalTime createdTime) {
		this.createdTime = createdTime;
	}



	public Organization getOrganization() {
		return organization;
	}



	public void setOrganization(Organization organization) {
		this.organization = organization;
	}



}
