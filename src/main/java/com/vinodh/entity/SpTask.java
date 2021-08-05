package com.vinodh.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * The persistent class for the SP_TASK database table.
 * 
 */


@Entity
@Table(name="SP_TASK")
/*@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
public class SpTask implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_sp_task")
	@SequenceGenerator(name = "seq_gen_sp_task", sequenceName = "SEQ_SP_TASK",allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "jobid")
	private String jobId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "taskstatus")
	private SpJobEnum taskStatus;
	
	@Column(name = "vendor")
	private String vendor;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "devicename")
	private String deviceName;
	
	@Column(name = "clli")
	private String clli;
	
	@Column(name = "deviceIp")
	private String deviceIp;
	
	@Column(name = "emsname")
	private String emsName;
	
	@Column(name = "emsIp")
	private String emsIp;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "outputfilepath")
	private String outputFilePath;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "starttime")
	private Timestamp startTime;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "endtime")
	private Timestamp endTime;
	
	@JsonInclude(Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentjobid")
	private SpJob spJob;

    
    public SpTask(String jobId,SpJobEnum taskStatus,String vendor,String model,String deviceName,String emsName,
    		String outputFilePath){
    	this.jobId=jobId;
    	this.taskStatus=taskStatus;
    	this.vendor=vendor;
    	this.model=model;
    	this.deviceName=deviceName;
    	this.emsName=emsName;
    	this.outputFilePath=outputFilePath;
    }
    
    public SpTask(){
    	
    }
    
	public Long getId() {
		return id;
	}

	public String getJobId() {
		return jobId;
	}

	public SpJobEnum getTaskStatus() {
		return taskStatus;
	}

	public String getVendor() {
		return vendor;
	}

	public String getModel() {
		return model;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getEmsName() {
		return emsName;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public SpJob getSpJob() {
		return spJob;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setTaskStatus(SpJobEnum taskStatus) {
		this.taskStatus = taskStatus;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public void setSpJob(SpJob spJob) {
		this.spJob = spJob;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getEmsIp() {
		return emsIp;
	}

	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}
}