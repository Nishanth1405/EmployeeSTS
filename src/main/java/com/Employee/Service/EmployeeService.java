package com.Employee.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	
	@Autowired
	EmployeeRepository er;

	public String postObject(Employee e) {

		return ed.postObject(e);
	}

	public String postList(List<Employee> e) {

		return ed.postList(e);
	}

	public Employee getSingleObject(int a) {

		return ed.getSingleObject(a);
	}

	public List<Employee> getAllObject() {

		return ed.getAllObject();
	}

	public String update(int n, Employee e) {

		return ed.update(n, e);
	}

	public String delete(int n) {

		return ed.delete(n);
	}

	public String updateName(int n, Employee name) {

		return ed.updateName(n, name);
	}

	public List<Employee> getBtws(int a, int b) {

		return ed.getBtws(a, b);
	}

	public List<Employee> getJp(int a, int b) {

		return ed.getJp(a, b);
	}

	public List<Employee> getJpN(String a) {

		return ed.getJpN(a);
	}

	public List<Employee> getJpC(String c) {

		return ed.getJpC(c);
	}

	public List<Employee> getJpMax() {

		return ed.getJpMax();
	}

	public Employee getJpSMax() {

		return ed.getJpSMax();
	}

	public Employee getJpMin() {
		
		return ed.getJpMin();
	}

	public Double getAvgOfSalary() {
		
		return ed.getAvgOfSalary();
	}

	public List<Employee> getobjectOfGivenName(String d) {
		
		return ed.getobjectOfGivenName(d);
	}

	public List<Employee> getS() {
	
		List<Employee> ee=er.findAll();
		Integer eee=ee.stream().map(x-> x.getSalary()).sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		
	 List<Employee> smax=ee.stream().filter(x-> x.getSalary()==eee).collect(Collectors.toList());
	 return smax;
		
	}

}
