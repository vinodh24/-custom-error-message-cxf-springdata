package com.vinodh.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.vinodh.entity.SpJobEnum;

public class JobDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String jobId;
	private String jobType;
	private String username;
	private SpJobEnum jobStatus;
	private String outputFilePath;
	private Timestamp startTime;
	private Timestamp endTime;
	private String jobName;
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public SpJobEnum getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(SpJobEnum jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result
				+ ((jobStatus == null) ? 0 : jobStatus.hashCode());
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result
				+ ((outputFilePath == null) ? 0 : outputFilePath.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		JobDTO other = (JobDTO) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (jobStatus != other.jobStatus)
			return false;
		if (jobType == null) {
			if (other.jobType != null)
				return false;
		} else if (!jobType.equals(other.jobType))
			return false;
		if (outputFilePath == null) {
			if (other.outputFilePath != null)
				return false;
		} else if (!outputFilePath.equals(other.outputFilePath))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}