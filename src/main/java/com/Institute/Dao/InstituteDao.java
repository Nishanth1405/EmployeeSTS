package com.Institute.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Institute.Entiry.Institute;
import com.Institute.Repository.InstituteRepository;

@Repository
public class InstituteDao {
	@Autowired
	InstituteRepository ir;

	public String postListI(List<Institute> i1) {
		
	             ir.saveAll(i1);
	             return "Success";
	}

	public String postobjectI(Institute i) {
		ir.save(i);
		return "Sucess";
	}

	public List<String> getNames() {
		
		return ir.getNames();
	}

	public List<Institute> getM() {
		
		return ir.getM();
	}

	public List<Institute> getAName(String name) {
		
		return ir.getAName(name);
	}

	public List<Institute> getBtwn(int a, int b) {
		
		return ir.getBtwn(a,b);
	}

	public List<Institute> getsecM() {
		
		return ir.getsecM();
	}
	

}
