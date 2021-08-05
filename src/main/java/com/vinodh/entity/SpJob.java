package com.vinodh.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The persistent class for the SP_JOB database table.
 * 
 */

/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "namedAsCallOne",
			procedureName = "callOne",
			parameters = {
					@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
			}
	)})*/


@Entity
@Table(name = "SP_JOB")
/*@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
*/public class SpJob implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_sp_job")
	@SequenceGenerator(name = "seq_gen_sp_job", sequenceName = "SEQ_SP_JOB", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "jobid")
	private String jobId;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "jobtype")
	private String jobType;

	@Column(name = "userName")
	private String username;

	@Column(name = "jobname")
	private String jobName;
	
	@Column(name = "fileName")
	private String fileName;

	@Column(name = "jobstatus")
	@Enumerated(EnumType.STRING)
	private SpJobEnum jobStatus;

	@Column(name = "taskcount")
	private Long taskCount;

	@Column(name = "completedtasks")
	private Long completedTasks;

	@Column(name = "successtasks")
	private Long successTasks;

	@Column(name = "failuretasks")
	private Long failureTasks;

	@Column(name = "outputfilepath")
	private String outputFilePath;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "starttime")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp startTime;

	@Column(name = "endtime")
	private Timestamp endTime;

	// bi-directional many-to-one association to SpTask
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "spJob", cascade = CascadeType.ALL)
	private Set<SpTask> spTasks = new HashSet<SpTask>();

	public void addSpTask(SpTask spTask) {
		this.spTasks.add(spTask);
		spTask.setSpJob(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public SpJobEnum getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(SpJobEnum jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Long getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}

	public Long getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(Long completedTasks) {
		this.completedTasks = completedTasks;
	}

	public Long getSuccessTasks() {
		return successTasks;
	}

	public void setSuccessTasks(Long successTasks) {
		this.successTasks = successTasks;
	}

	public Long getFailureTasks() {
		return failureTasks;
	}

	public void setFailureTasks(Long failureTasks) {
		this.failureTasks = failureTasks;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Set<SpTask> getSpTasks() {
		return spTasks;
	}

	public void setSpTasks(Set<SpTask> spTasks) {
		this.spTasks = spTasks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SpJob(Long id, String jobId,String userName,SpJobEnum jobStatus,Date startTime,Date endTime,String outputFilePath){
		this.id=id;
		this.jobId=jobId;
		this.username=userName;
		this.jobStatus=jobStatus;
		this.startTime=(Timestamp) startTime;
		this.endTime=(Timestamp) endTime;
		this.outputFilePath=outputFilePath;
	}
	
	public SpJob() {
	}

	@Override
	public String toString() {
		return "SpJob [id=" + id + ", jobId=" + jobId + ", jobType=" + jobType + ", username=" + username
				+ ", jobStatus=" + jobStatus + ", taskCount=" + taskCount + ", completedTasks=" + completedTasks
				+ ", successTasks=" + successTasks + ", failureTasks=" + failureTasks + ", outputFilePath="
				+ outputFilePath + ", remarks=" + remarks + ", startTime=" + startTime + ", endTime=" + endTime;
	}
}