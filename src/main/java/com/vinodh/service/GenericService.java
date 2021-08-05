package com.vinodh.service;

import java.util.ArrayList;
import java.util.List;

import com.vinodh.dto.JobDTO;
import com.vinodh.dto.TaskDTO;
import com.vinodh.entity.SpJob;
import com.vinodh.entity.SpTask;

public class GenericService {

	public static List<JobDTO> getResponseForJob(List<SpJob> jobsList) {
		List<JobDTO> jobDTOs = new ArrayList<JobDTO>();
		for (SpJob job : jobsList) {
			jobDTOs.add(getDTOFromSpJob(job));
		}
		return jobDTOs;
	}

	public static JobDTO getDTOFromSpJob(SpJob job) {
		JobDTO dto = new JobDTO();
		dto.setId(job.getId());
		dto.setJobId(job.getJobId());
		dto.setEndTime(job.getEndTime());
		dto.setJobStatus(job.getJobStatus());
		dto.setJobType(job.getJobType());
		dto.setJobName(job.getJobName());
		dto.setOutputFilePath(job.getOutputFilePath());
		dto.setStartTime(job.getStartTime());
		dto.setUsername(job.getUsername());
		dto.setFileName(job.getFileName());
		return dto;
	}
	
	public static List<TaskDTO> getResponseForSpTask(List<SpTask> jobsList) {
		List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
		for(SpTask job : jobsList) {
			taskDTOs.add(getDTOFromSpTask(job));
		}		
		return taskDTOs;
	}
	
	public static TaskDTO getDTOFromSpTask(SpTask task) {
		TaskDTO dto = new TaskDTO();
		dto.setId(task.getId());
		dto.setJobId(task.getJobId());
		dto.setOutputFilePath(task.getOutputFilePath());
		dto.setTaskStatus(task.getTaskStatus());
		dto.setVendor(task.getVendor());
		dto.setModel(task.getModel());
		dto.setDeviceName(task.getDeviceName());
		dto.setEmsName(task.getEmsName());
		dto.setClli(task.getClli());
		dto.setDeviceIp(task.getDeviceIp());
		dto.setEmsIp(task.getEmsIp());
		dto.setStartTime(task.getStartTime());
		dto.setEndTime(task.getEndTime());
		return dto;
	}
	
}
