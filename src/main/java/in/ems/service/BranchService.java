package in.ems.service;

import java.util.List;

import in.ems.binding.BranchForm;
import in.ems.entity.BranchEntity;

public interface BranchService {
	
	  public String saveBranch(Integer organizationId, BranchForm form);
	
	  public List<BranchForm> getAllBranches();
	
	  public BranchEntity updateBranch(Integer id, BranchEntity branchDetails) throws Exception;
	
	    public BranchForm getBranchById(Integer branchId);

	
	
}
