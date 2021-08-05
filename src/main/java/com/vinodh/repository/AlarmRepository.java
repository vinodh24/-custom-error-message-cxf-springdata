package com.vinodh.repository;

import org.springframework.stereotype.Repository;

import com.vinodh.entity.Alarm;
@Repository
public interface AlarmRepository extends GenericDAO<Alarm> {
	
}
