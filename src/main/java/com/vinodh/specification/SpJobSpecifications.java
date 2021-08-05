package com.vinodh.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vinodh.entity.SpJob;

public class SpJobSpecifications implements Specification<SpJob>{

	private static final long serialVersionUID = -8732995461205989003L;
	
	private SpJob spJob;
	
	public SpJobSpecifications(SpJob spJob){
		super();
		this.spJob=spJob;
	}
	
	@Override
	public Predicate toPredicate(Root<SpJob> root, CriteriaQuery<?> cq,
			CriteriaBuilder cb) {
		Predicate p = cb.disjunction();
		if (spJob.getJobName() != null) {
			p.getExpressions().add(cb.like(root.get("jobName"), spJob.getJobName()));
		}
				
		if(spJob.getStartTime() !=null){
			p.getExpressions().add(cb.lessThanOrEqualTo(root.<Date>get("startTime"), spJob.getStartTime()));
		}
		
		if (spJob.getId() != null && spJob.getJobId()!= null) {
			p.getExpressions().add(cb.and(
						cb.equal(root.get("id"), spJob.getId()),
						cb.equal(root.get("jobId"), spJob.getJobId())
					));
		}	
		return p;
	}

}
