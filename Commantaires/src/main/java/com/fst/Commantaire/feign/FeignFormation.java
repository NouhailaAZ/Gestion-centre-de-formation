package com.fst.Commantaire.feign;

import org.springframework.cloud.openfeign.FeignClient;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.Commantaire.entities.Formation;

@FeignClient(name="formation-service",url="http://localhost:8086")
public interface FeignFormation {
	
	  @GetMapping("/formation/{idFormation}")
	  Formation getFormationById(@PathVariable  int idFormation);
		
}
