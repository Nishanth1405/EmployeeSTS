package com.Institute.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Institute.Entiry.Institute;
import com.Institute.Service.InstituteService;

@RestController
public class InstituteController {
	@Autowired
	InstituteService is;


	@GetMapping(value = "/get")
	public String getmeg() {
		return "Hello Nish";
	}
	
	@GetMapping(value="getprime/{a}/{b}")
	public ArrayList<Integer> getPrime(@PathVariable int a,@PathVariable int b) {
		ArrayList<Integer> n = new ArrayList<>();
		
		for(int i = a;i<=b;i++) {
			boolean isPrime=true;
			for(int j = 2;j<i;j++) {
				if(i%j==0) {
					isPrime=false;
				}
			}
		if(isPrime==true) {
			n.add(i);
		}
		}
		return n;
	}

	@PostMapping(value = "/postobjectI")
	public String postobjectI(@RequestBody Institute i1) {
		return is.postobjectI(i1);
	}

	@PostMapping(value = "/postListI")
	public String postListI(@RequestBody List<Institute> i) {
		return is.postListI(i);
	}

	@GetMapping(value = "/getMax")
	public Institute getMax() {
		return is.getMax();
	}

	@GetMapping(value = "/getvalue/{a}")
	public List<Institute> getValue(@RequestBody List<Institute> i, @PathVariable String a) {

		return is.getValue(a);
	}

	@GetMapping(value = "/getInBtw/{a}/{b}")
	public List<Institute> getInBtw(@RequestBody List<Institute> i, @PathVariable int a, @PathVariable int b) {

		return is.getInBtw(a, b);
	}

	@GetMapping(value = "/getLastchar/{a}")
	public List<Character> getLaC(@RequestBody List<Institute> i, @PathVariable String a) {
		return is.getLaC(a);
	}
	
	@GetMapping(value="/grouping")
	public Map<String, List<Institute>> grouping(@RequestBody List<Institute> i){
		return is.grouping(i);
	}
	@GetMapping (value="/getNames")
	public List<String> getNames(){
		return is.getNames();
	}
	@GetMapping(value="/getM")
	public List<Institute>getM(){
		return is.getM();	
	}
	
	@GetMapping(value="/getAName/{name}")
	public List<Institute> getAName(@PathVariable String name){
		return is.getAName(name);
	}
	
	@GetMapping(value="/getBtwandb/{a}/{b}")
	public List<Institute>getBtwn(@PathVariable int a,@PathVariable int b){
		return is.getBtwn(a,b);
	}
	
	@GetMapping(value= "/getsecM")
	public List<Institute>getsecM(){
		return is.getsecM();
	}


}
