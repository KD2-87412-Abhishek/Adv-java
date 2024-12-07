package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

 public class Result {
	 private List<Candidate>Candlist=new ArrayList<Candidate>();

	public Result(List<Candidate> candlist) {
		
		Candlist = candlist;
	}
public Result() {
		
	}
public List<Candidate> getCandlist() {
	return Candlist;
}
public void setCandlist(List<Candidate> candlist) {
	Candlist = candlist;
}

public  void fetchCandidate() {
	try(CandidateDao canDao=new CandidateDaoImpl()){
		this.Candlist=canDao.findAll();
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	
			
}
	
	

}
