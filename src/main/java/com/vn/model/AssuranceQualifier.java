package com.vn.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceQualifier {
	
	@Autowired
	private List<ISoftware> software;	
	
	public int getQualityAssurance() {
		int quality = 0;
		
		for (ISoftware s:software) {
			quality += s.quality();
		}
		return quality;
	}
}
