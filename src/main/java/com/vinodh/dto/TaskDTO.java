package com.vinodh.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.vinodh.entity.SpJobEnum;

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String jobId;
	private SpJobEnum taskStatus;
	private String vendor;
	private String model;
	private String deviceName;
	private String deviceIp;
	private String clli;
	private String emsName;
	private String emsIp;
	private String outputFilePath;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public SpJobEnum getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(SpJobEnum taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getEmsName() {
		return emsName;
	}
	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	
	public String getDeviceIp() {
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public String getClli() {
		return clli;
	}
	public void setClli(String clli) {
		this.clli = clli;
	}
	public String getEmsIp() {
		return emsIp;
	}
	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + ((emsName == null) ? 0 : emsName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((outputFilePath == null) ? 0 : outputFilePath.hashCode());
		result = prime * result
				+ ((taskStatus == null) ? 0 : taskStatus.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDTO other = (TaskDTO) obj;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (emsName == null) {
			if (other.emsName != null)
				return false;
		} else if (!emsName.equals(other.emsName))
			return false;
		if (id != other.id)
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (outputFilePath == null) {
			if (other.outputFilePath != null)
				return false;
		} else if (!outputFilePath.equals(other.outputFilePath))
			return false;
		if (taskStatus != other.taskStatus)
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}

}