package com.Employee.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/postObject")

	public String postObject(@RequestBody Employee e) {
		return es.postObject(e);

	}

	@PostMapping(value = "/postList")
	public String postList(@RequestBody List<Employee> e) {
		return es.postList(e);
	}

	@GetMapping(value = "/getSingleObject/{a}")
	public Employee getSingleObject(@PathVariable int a) {
		return es.getSingleObject(a);
	}

	@GetMapping(value = "/getAllObject")
	public List<Employee> getAllObject() {
		return es.getAllObject();
	}

	@PutMapping(value = "/updateObject/{n}")
	public String update(@PathVariable int n, @RequestBody Employee e) {
		return es.update(n, e);
	}

	@DeleteMapping(value = "delete/{n}")
	public String delete(@PathVariable int n) {
		return es.delete(n);
	}

	@PatchMapping(value = "updateName/{n}")
	public String updateName(@PathVariable int n, @RequestBody Employee name) {
		return es.updateName(n, name);
	}

	@GetMapping(value = "getBtws/{a}/{b}")
	public List<Employee> getBtws(@PathVariable int a, @PathVariable int b) {

		return es.getBtws(a, b);
	}

	@GetMapping(value = "getJpQ/{a}/{b}")
	public List<Employee> getJp(@PathVariable int a, @PathVariable int b) {

		return es.getJp(a, b);
	}

	@GetMapping(value = "getJpN/{a}")
	public List<Employee> getJpN(@PathVariable String a) {
		return es.getJpN(a);
	}

	@GetMapping(value = "getJpC/{c}")
	public List<Employee> getJpC(@PathVariable String c) {

		return es.getJpC(c);
	}

	@GetMapping(value = "getJpMax")
	public List<Employee> getJpMax() {
		return es.getJpMax();
	}

	@GetMapping(value = "getJpSMax")
	public Employee getJpSMax() {
		return es.getJpSMax();
	}

	@GetMapping(value = "getJpMin")
	public Employee getJpMin() {
		return es.getJpMin();
	}

	@GetMapping(value = "/getAvgOfSalary")
	public Double getAvgOfSalary() {
		return es.getAvgOfSalary();
	}

	@GetMapping(value = "/getObjectOfgivenName/{d}")
	public List<Employee> getobjectOfGivenName(@PathVariable String d) {
		return es.getobjectOfGivenName(d);
	}

	@GetMapping(value = "/getSecMax")
	public List<Employee> getS() {

		return es.getS();
	}
}
