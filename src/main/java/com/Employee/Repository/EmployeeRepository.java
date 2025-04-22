package com.Employee.Repository;

import java.util.List;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from empdb.employee where salary between ? and ?", nativeQuery = true)
	List<Employee> getBtws(int a, int b);

	@Query(value = "select e from Employee e where e.salary between :a and :b")
	List<Employee> getJp(@Param("a") int a, @Param("b") int b);

	@Query(value = "select e from Employee e where e.name = :a")
	List<Employee> getJpN(@Param("a") String a);

	@Query(value = "select e from Employee e where e.name like concat( '%',:c  )") // concat( :c,'%' ) - startWith
	List<Employee> getJpC(@Param("c") String c);

	@Query(value = "select e from Employee e where e.salary=(select max(e.salary) from Employee e)")
	List<Employee> getJpMax();

	@Query(value = "select e from Employee e where e.salary =(select max(e.salary) from Employee e  where e.salary not in (select max(e.salary) from Employee e))")
	Employee getJpSMax();

	@Query(value = "select e from Employee e where e.salary =(select min(e.salary) from Employee e  where e.salary not in (select min(e.salary) from Employee e))")
	Employee getJpSMin();

	@Query(value = "select e from Employee e where e.salary=(select min(e.salary) from Employee e)")
	Employee getJpMin();

	@Query("select avg(e.salary) from Employee e")
	public Double getAvgOfSalary();

	@Query("select e from Employee e where lower(e.name)=lower(:d)")
	public List<Employee> getobjectOfGivenName(@Param("d") String d);

}
