package in.ems.serviceImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ems.binding.BranchForm;
import in.ems.entity.BranchEntity;
import in.ems.entity.Organization;
import in.ems.repository.BranchRepository;
import in.ems.repository.OrganizationRepository;
import in.ems.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	  public String saveBranch(Integer organizationId, BranchForm form) {
	        Optional<Organization> optionalOrganization = organizationRepository.findById(organizationId);
	        if (!optionalOrganization.isPresent()) {
	            return "Organization not found";
	        }
	        if (branchRepository.findByPhone_number(form.getPhone_number()).isPresent()) {
	            return "Phone number already registered";
	        }

	        Organization organization = optionalOrganization.get();
	        for (BranchEntity branch : organization.getBranches()) {
	            if (branch.getName().equalsIgnoreCase(form.getName())) {
	                return "Branch already exists with this organization";
	            }
	        }
	        BranchEntity entities= new BranchEntity();
	        BeanUtils.copyProperties(form, entities);
	        entities.setOrganization(organization);
	        branchRepository.save(entities);
	        return "Branch saved successfully";
	    }

	@Override
	 public List<BranchForm> getAllBranches() {
	        List<BranchEntity> branches = branchRepository.findAll();
	        return branches.stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    private BranchForm mapToDTO(BranchEntity branch) {
	    	BranchForm branchDTO = new BranchForm();
	    	 branchDTO.setBranch_Id(branch.getBranch_Id());
	    	branchDTO.setCity(branch.getCity());
	    	branchDTO.setDistricts(branch.getDistricts());
	    	branchDTO.setState(branch.getState());
	    	branchDTO.setEmail_id(branch.getEmail_id());
	    	branchDTO.setPincode(branch.getPincode());
	    	branchDTO.setParent_organization(branch.getOrganization().getName());
	        branchDTO.setName(branch.getName());
	        branchDTO.setAddress(branch.getAddress());
	        branchDTO.setPhone_number(branch.getPhone_number());
	        branchDTO.setStatus(branch.getStatus());
	        branchDTO.setOrganizationId(branch.getOrganization().getOrganizationId());
	        return branchDTO;
	    }

	   public BranchEntity updateBranch(Integer id, BranchEntity branchDetails) throws Exception {
	        Optional<BranchEntity> optionalBranch = branchRepository.findById(id);

	        if (optionalBranch.isPresent()) {
	            BranchEntity existingBranch = optionalBranch.get();

	            if (branchDetails.getName() != null) {
	                existingBranch.setName(branchDetails.getName());
	            }
	            if (branchDetails.getAddress() != null) {
	                existingBranch.setAddress(branchDetails.getAddress());
	            }
	            if (branchDetails.getPhone_number() != null) {
	                existingBranch.setPhone_number(branchDetails.getPhone_number());
	            }
	            if (branchDetails.getStatus() != null) {
	                existingBranch.setStatus(branchDetails.getStatus());
	            }
	            existingBranch.setUpdatedAt(LocalTime.now());
	            return branchRepository.save(existingBranch);
	        } else {
	            throw new Exception("Branch not found with id " + id);
	        }
	    }

	    public BranchForm getBranchById(Integer branchId) {
	        Optional<BranchEntity> optionalBranch = branchRepository.findById(branchId);
	        if (optionalBranch.isPresent()) {
	            BranchEntity branch = optionalBranch.get();
	            BranchForm branchDTO = new BranchForm();
	            branchDTO.setBranch_Id(branch.getBranch_Id());
		    	branchDTO.setCity(branch.getCity());
		    	branchDTO.setDistricts(branch.getDistricts());
		    	branchDTO.setState(branch.getState());
		    	branchDTO.setEmail_id(branch.getEmail_id());
		    	branchDTO.setPincode(branch.getPincode());
		    	branchDTO.setParent_organization(branch.getOrganization().getName());
		        branchDTO.setName(branch.getName());
		        branchDTO.setAddress(branch.getAddress());
		        branchDTO.setPhone_number(branch.getPhone_number());
		        branchDTO.setStatus(branch.getStatus());
		        branchDTO.setOrganizationId(branch.getOrganization().getOrganizationId());
		        return branchDTO;
	        }
	        return null;
	    }


	

}
