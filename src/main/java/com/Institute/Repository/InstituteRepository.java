package com.Institute.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Institute.Entiry.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Integer> {

	@Query(value = "select name from insdb.institute", nativeQuery = true)
	List<String> getNames();

	@Query(value = "select*from insdb.institute where fee>=40000", nativeQuery = true)
	List<Institute> getM();

	@Query(value = "select*from insdb.institute where name=?", nativeQuery = true)
	List<Institute> getAName(String name);

	@Query(value="select * from insdb.institute where fee>=? && fee<=?",nativeQuery=true)
	List<Institute> getBtwn(int a, int b);

	              
	@Query(value="select* from insdb.institute where fee=(select max(fee) from insdb.institute  where fee not in (select max(fee) from insdb.institute));",nativeQuery=true)
	List<Institute> getsecM();

}
