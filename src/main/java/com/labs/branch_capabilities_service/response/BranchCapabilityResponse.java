package com.labs.branch_capabilities_service.response;

public class BranchCapabilityResponse {

	private int capabilityId;
	private int orgId;
	private String branchName;
	private String capabilityName;
	private String createdTime;
	private String creadtedBy;
	private String modifiedTime;
	private String modifiedBy;
	private String status;

	public int getCapabilityId() {
		return capabilityId;
	}

	public void setCapabilityId(int capabilityId) {
		this.capabilityId = capabilityId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCapabilityName() {
		return capabilityName;
	}

	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreadtedBy() {
		return creadtedBy;
	}

	public void setCreadtedBy(String creadtedBy) {
		this.creadtedBy = creadtedBy;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
