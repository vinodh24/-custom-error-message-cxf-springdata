package com.vinodh.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the ALARM database table.
 * 
 */
@Entity
@Table(name = "alarm_dummy")
public class ALARM_Dummy implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pooled")
	@GenericGenerator(
			name = "pooled",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "SEQ_ALARM_DUMMY"),
					@Parameter(name = "initial_value", value = "1"),
					@Parameter(name = "increment_size", value = "20000"),
					@Parameter(name = "optimizer", value = "pooled-lo")
			}
			)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "isacknowledged")
	private boolean acknowledged;
	
	@Column(name = "additionaltext")
	private String additionalText;
	
	@Column(name = "alarmsourceid")
	private String alarmSourceId;
	
	@Column(name = "alertidentifier")
	private String alertIdentifier;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "emsId")
	private long emsId;
	
	@Column(name = "emsname")
	private String emsName;
	
	@Column(name = "nodeid")
	private Long nodeId;
	
	@Column(name = "emsip")
	private String emsIp;
	
	@Column(name = "nodeip")
	private String nodeIp;
	
	@Column(name = "nodename")
	private String nodeName;

	@Column(name = "failureobject")
	private String failureObject;
	
	@Column(name = "failureobjectdescription")
	private String failureObjectDescription;
	
	@Column(name = "generatedsource")
	private String generatedSource;
	
	@Column(name = "createtime")
	private Timestamp createTime;

	@Column(name = "modifiedtime")
	private Timestamp modifiedTime;
	
	@Column(name = "occurance")
	private long occurance;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "previousseverity")
	private long previousSeverity;
	
	@Column(name = "probablecause")
	private String probableCause;
	
	@Column(name = "sequencenumber")
	private String sequenceNumber;
	
	@Column(name = "severity")
	private long severity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}

	public String getAdditionalText() {
		return additionalText;
	}

	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}

	public String getAlarmSourceId() {
		return alarmSourceId;
	}

	public void setAlarmSourceId(String alarmSourceId) {
		this.alarmSourceId = alarmSourceId;
	}

	public String getAlertIdentifier() {
		return alertIdentifier;
	}

	public void setAlertIdentifier(String alertIdentifier) {
		this.alertIdentifier = alertIdentifier;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getEmsId() {
		return emsId;
	}

	public void setEmsId(long emsId) {
		this.emsId = emsId;
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}
	
	public String getEmsIp() {
		return emsIp;
	}

	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public String getFailureObject() {
		return failureObject;
	}

	public void setFailureObject(String failureObject) {
		this.failureObject = failureObject;
	}

	public String getFailureObjectDescription() {
		return failureObjectDescription;
	}

	public void setFailureObjectDescription(String failureObjectDescription) {
		this.failureObjectDescription = failureObjectDescription;
	}

	public String getGeneratedSource() {
		return generatedSource;
	}

	public void setGeneratedSource(String generatedSource) {
		this.generatedSource = generatedSource;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public long getOccurance() {
		return occurance;
	}

	public void setOccurance(long occurance) {
		this.occurance = occurance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getPreviousSeverity() {
		return previousSeverity;
	}

	public void setPreviousSeverity(long previousSeverity) {
		this.previousSeverity = previousSeverity;
	}

	public String getProbableCause() {
		return probableCause;
	}

	public void setProbableCause(String probableCause) {
		this.probableCause = probableCause;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public long getSeverity() {
		return severity;
	}

	public void setSeverity(long severity) {
		this.severity = severity;
	}
}