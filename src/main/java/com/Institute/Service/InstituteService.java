package com.Institute.Service;

import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Institute.Dao.InstituteDao;
import com.Institute.Entiry.Institute;
import com.Institute.Repository.InstituteRepository;

@Service
public class InstituteService {

	@Autowired
	InstituteDao di;

	@Autowired
	InstituteRepository ir;

	public String postListI(List<Institute> i1) {

		return di.postListI(i1);
	}

	public String postobjectI(Institute i) {

		return di.postobjectI(i);
	}

	public Institute getMax() {
		List<Institute> y = ir.findAll();
		Institute a = y.stream().max(Comparator.comparing(Institute::getFee)).get();
		return a;
	}

	public List<Institute> getValue(String a) {

		List<Institute> y = ir.findAll();

		List<Institute> b = y.stream().filter(x -> x.getName().toLowerCase().equalsIgnoreCase(a.toLowerCase()))
				.toList();
		return b;

	}

	public List<Institute> getInBtw(int a, int b) {

		List<Institute> q = ir.findAll();
		List<Institute> c = q.stream().filter(x -> x.getFee() >= a && x.getFee() <= b).toList();
		return c;
	}

	public List<Character> getLaC(String a) {
		List<Institute> e = ir.findAll();
		List<Character> l = e.stream().filter(x -> x.getName().toLowerCase().equals(a.toLowerCase()))
				.map(y -> y.getName().charAt(y.getName().length() - 1)).toList();
		return l;

	}

	public Map<String, List<Institute>> grouping(List<Institute> i) {
		List<Institute> e1 = ir.findAll();
		Map<String, List<Institute>> g = e1.stream().collect(Collectors.groupingBy(Institute::getCourse));
		return g;
	}

	public List<String> getNames() {
		
		return di.getNames();
	}

	public List<Institute> getM() {
		
		return di.getM();
	}

	public List<Institute> getAName(String name) {
		
		return di.getAName(name);
	}

	public List<Institute> getBtwn(int a, int b) {
		
		return di.getBtwn(a,b);
	}

	public List<Institute> getsecM() {
		
		return di.getsecM();
	}

}
