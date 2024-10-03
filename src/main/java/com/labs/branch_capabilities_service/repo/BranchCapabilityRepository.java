package com.labs.branch_capabilities_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.labs.branch_capabilities_service.entity.BranchCapabilityEntity;

import jakarta.transaction.Transactional;

public interface BranchCapabilityRepository extends JpaRepository<BranchCapabilityEntity, Integer> {

	@Query("SELECT b FROM BranchCapabilityEntity b WHERE b.branchName = :branchName AND b.capabilityName = :capabilityName AND b.status = 'ENABLE'")
	Optional<BranchCapabilityEntity> addBranchCapability(@Param("branchName") String branchName,
			@Param("capabilityName") String capabilityName);

	@Transactional
	@Modifying
	@Query("UPDATE BranchCapabilityEntity b set b.capabilityName = :capability WHERE b.branchName = :branch AND b.capabilityId = :id")
	int updateBranch(@Param("id") int id, @Param("branch") String branch, @Param("capability") String capability);

	@Transactional
	@Modifying
	@Query("DELETE FROM BranchCapabilityEntity b WHERE b.capabilityId = :id")
	int deleteBranchCapabilty(@Param("id") int id);

}
