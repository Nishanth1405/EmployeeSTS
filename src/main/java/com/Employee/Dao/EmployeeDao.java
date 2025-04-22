package com.Employee.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository er;

	public String postObject(Employee e) {

		er.save(e);
		return "Post Single Object Successfully";
	}

	public String postList(List<Employee> e) {
		er.saveAll(e);
		return "Post List of Objects Successfully";
	}

	public Employee getSingleObject(int a) {
		return er.findById(a).get();
	}

	public List<Employee> getAllObject() {

		return er.findAll();
	}

	public String update(int n, Employee a) {

		Employee x = er.findById(n).get();
		x.setName(a.getName());
		x.setSalary(a.getSalary());
		x.setGender(a.getGender());
		x.setEx(a.getEx());
		er.save(x);
		return "Upadates Successfully";
	}

	public String delete(int n) {

		er.deleteById(n);
		return "Deleted Successfully";
	}

	public String updateName(int n, Employee name) {

		Employee x = er.findById(n).get();
		x.setName(name.getName());
		er.save(x);
		return "Updated Successfully";

	}

	public List<Employee> getBtws(int a, int b) {

		return er.getBtws(a, b);
	}

	public List<Employee> getJp(int a, int b) {

		return er.getJp(a, b);
	}

	public List<Employee> getJpN(String a) {

		return er.getJpN(a);
	}

	public List<Employee> getJpC(String c) {

		return er.getJpC(c);
	}

	public List<Employee> getJpMax() {

		return er.getJpMax();
	}

	public Employee getJpSMax() {

		return er.getJpSMax();
	}

	public Employee getJpMin() {
		
		return er.getJpMin();
	}

	public Double getAvgOfSalary() {
		
		return er.getAvgOfSalary();
	}

	public List<Employee> getobjectOfGivenName(String d) {
		
		return er.getobjectOfGivenName(d);
	}
}
