package in.ems.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organizationId;

	@NotBlank(message = "Name is mandatory")
	@Size(max = 100, min = 3, message = "Name can have a maximum of 255 characters")
	private String name;

	private String status;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updatedAt;
	
	
	@OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
	 @JsonManagedReference
	private Set<BranchEntity> branches;


	public int getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Set<BranchEntity> getBranches() {
		return branches;
	}


	public void setBranches(Set<BranchEntity> branches) {
		this.branches = branches;
	}

	
	

}
