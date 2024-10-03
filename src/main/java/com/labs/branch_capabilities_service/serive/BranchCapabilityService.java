package com.labs.branch_capabilities_service.serive;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.branch_capabilities_service.entity.BranchCapabilityEntity;
import com.labs.branch_capabilities_service.repo.BranchCapabilityRepository;
import com.labs.branch_capabilities_service.response.BranchCapabilityResponse;

import jakarta.transaction.Transactional;

@Service
public class BranchCapabilityService {

	@Autowired
	private BranchCapabilityRepository branchCapabilityRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public BranchCapabilityResponse getBranchCapability(int id) {
		BranchCapabilityEntity response = branchCapabilityRepository.findById(id).get();
		BranchCapabilityResponse output = modelMapper.map(response, BranchCapabilityResponse.class);
		return output;
	}

	@Transactional
	public BranchCapabilityEntity addBranchCapability(BranchCapabilityEntity branchCapabilityEntity) throws Exception {
		Optional<BranchCapabilityEntity> entity = branchCapabilityRepository.addBranchCapability(
				branchCapabilityEntity.getBranchName(), branchCapabilityEntity.getCapabilityName());
		if (entity.isPresent()) {
			throw new Exception("Branch capability with the same name already exists");
		}
		BranchCapabilityEntity output = branchCapabilityRepository.save(branchCapabilityEntity);
		return output;
	}

	@Transactional
	public boolean updateBranch(int id, String branch, String capability) {
		int rowsUpdated = branchCapabilityRepository.updateBranch(id, branch, capability);
		return rowsUpdated > 0; // Return true if update was successful
	}

	public Optional<BranchCapabilityEntity> findById(Integer id) {
		return branchCapabilityRepository.findById(id); // Fetch the updated entity if needed
	}

	@Transactional
	public boolean deleteBranchCapability(int id) {
		int isDeleted = branchCapabilityRepository.deleteBranchCapabilty(id);
		return isDeleted > 0;
	}

	public Optional<BranchCapabilityEntity> findByID(Integer id) {
		return branchCapabilityRepository.findById(id);
	}

}
