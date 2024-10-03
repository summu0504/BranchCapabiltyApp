package com.labs.branch_capabilities_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "branch_capabilities")
public class BranchCapabilityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cap_ID")
	private int capabilityId;
	@Column(name = "org_id")
	private int orgId;
	@Column(name = "branch_name")
	private String branchName;
	@Column(name = "cap_name")
	private String capabilityName;
	@Column(name = "cap_createdtime")
	private String createdTime;
	@Column(name = "cap_createdby")
	private String creadtedBy;
	@Column(name = "cap_modifiedtime")
	private String modifiedTime;
	@Column(name = "cap_modifiedby")
	private String modifiedBy;
	@Column(name = "cap_status")
	private String status;

	public BranchCapabilityEntity() {

	}

	public BranchCapabilityEntity(int orgId, String branchName, String capabilityName, String createdTime,
			String creadtedBy, String modifiedTime, String modifiedBy, String status) {
		super();
		this.orgId = orgId;
		this.branchName = branchName;
		this.capabilityName = capabilityName;
		this.createdTime = createdTime;
		this.creadtedBy = creadtedBy;
		this.modifiedTime = modifiedTime;
		this.modifiedBy = modifiedBy;
		this.status = status;
	}

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

	@Override
	public String toString() {
		return "BranchCapabilityEntity [capabilityId=" + capabilityId + ", orgId=" + orgId + ", branchName="
				+ branchName + ", capabilityName=" + capabilityName + ", createdTime=" + createdTime + ", creadtedBy="
				+ creadtedBy + ", modifiedTime=" + modifiedTime + ", modifiedBy=" + modifiedBy + ", status=" + status
				+ "]";
	}

}
