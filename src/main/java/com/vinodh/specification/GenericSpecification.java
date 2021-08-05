package com.vinodh.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T>{
	
	private static final long serialVersionUID = 4364333247254788524L;

	public GenericSpecification(){
		
	}
	
	public static ExampleMatcher getMatcher() {
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		return matcher;
	}
	
	public static ExampleMatcher getMatcherWithId() {
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
		        .withIgnorePaths("id")
		        .withIgnorePaths("taskCount").withIgnorePaths("completedTasks")
		        .withIgnorePaths("successTasks") .withIgnorePaths("failureTasks");
		return matcher;
	}

	@Override
	public Predicate toPredicate(Root<T> arg0, CriteriaQuery<?> cq,
			CriteriaBuilder cb) {
		return null;
	}
	
}
