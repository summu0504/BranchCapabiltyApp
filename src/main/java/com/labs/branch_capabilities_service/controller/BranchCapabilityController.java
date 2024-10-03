package com.labs.branch_capabilities_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.branch_capabilities_service.entity.BranchCapabilityEntity;
import com.labs.branch_capabilities_service.response.BranchCapabilityResponse;
import com.labs.branch_capabilities_service.serive.BranchCapabilityService;

@RestController
@RequestMapping("/capabilities")
public class BranchCapabilityController {

	@Autowired
	private BranchCapabilityService branchCapabilityService;

	@GetMapping("/get/capabilities/{id}")
	public ResponseEntity<BranchCapabilityResponse> getBranchCapability(@PathVariable int id) throws Exception {
		if (id == 0) {
			throw new Exception("Id Should not be 0");
		}
		BranchCapabilityResponse branchresponse = branchCapabilityService.getBranchCapability(id);
		return new ResponseEntity<>(branchresponse, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handledException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// add branch_capabilities
	@PostMapping("/add/branch/capability")
	public ResponseEntity<String> addBranchCapability(@RequestBody BranchCapabilityEntity branchCapabilityEntity)
			throws Exception {
		if (branchCapabilityEntity == null) {
			throw new NullPointerException("Data is null");
		}
		BranchCapabilityEntity branchCap = branchCapabilityService.addBranchCapability(branchCapabilityEntity);
		return ResponseEntity.ok("BranchCapability Inserted Successfully");

	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullException(NullPointerException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// update Branch_Capabilities
	@PutMapping("/update/branch/capabilities/{id}/{branch}/{capability}")
	public ResponseEntity<String> updateBranchCapability(@PathVariable int id, @PathVariable String branch,
			@PathVariable String capability) throws Exception {
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid ID: ID must be greater than 0.");
		}
		if (branch == null || branch.isEmpty()) {
			throw new IllegalArgumentException("Branch name cannot be null or empty.");
		}
		if (capability == null || capability.isEmpty()) {
			throw new IllegalArgumentException("Status cannot be null or empty.");
		}
		boolean isUpdated = branchCapabilityService.updateBranch(id, branch, capability);
		if (isUpdated) {
			return ResponseEntity.ok("Branch updated successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch with id " + id + " not found.");
		}
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleException(IllegalArgumentException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// delete Branch_capability
	@DeleteMapping("/delete/capability/{id}")
	public ResponseEntity<String> deleteBranchCapability(@PathVariable int id) throws Exception {
		if (id <= 0) {
			throw new Exception("Invalid ID: Id must be greater than 0");
		}
		boolean isDeleted = branchCapabilityService.deleteBranchCapability(id);
		if (isDeleted) {
			return ResponseEntity.ok("Branch Capability Deleted Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch Capability with id " + id + " not found");
		}
	}

}