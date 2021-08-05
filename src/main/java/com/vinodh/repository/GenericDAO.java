package com.vinodh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;
@NoRepositoryBean
public interface GenericDAO<T> extends JpaRepository<T, Long>, QueryByExampleExecutor<T>,JpaSpecificationExecutor<T>/*,
QuerydslPredicateExecutor<T>,JpaSpecificationExecutor<T>*/ {
	
	/*@Transactional(isolation = Isolation.REPEATABLE_READ)
	List<T> saveAll(List<T> entities);*/
   
    
}
