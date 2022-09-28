package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ThisIsEntity;
import com.example.demo.service.ThisService;
@Repository
public interface ThisIsRepository extends JpaRepository<ThisIsEntity, String>{
	@Transactional
	@Modifying
	@Query(value="insert into newhand (ename,phone)  values (?1,?2) ",nativeQuery=true)
	void saveid(String ename, String phone);

	@Query(value="select * from newhand where ename=?1",nativeQuery=true)
	List<Map<ThisService, Object>> findename(String ename);

	@Query(value="select * from newhand ",nativeQuery=true)
	List<Map<ThisService, Object>> findAllname(String all);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM newhand WHERE ename=?1 ",nativeQuery=true)
	void deletebyename(String ename);

	@Transactional
	@Modifying
	@Query(value="UPDATE newhand SET phone = ?2 WHERE ename = ?1  ",nativeQuery=true)
	void update(String ename, String phone);
}
