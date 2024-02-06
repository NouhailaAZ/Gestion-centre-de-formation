package com.fst.Commantaire.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fst.Commantaire.entities.Formation;
import com.fst.Commantaire.entities.Participant;

@FeignClient(name = "utilisateur-service" ,url ="http://localhost:8081")
public interface FeignParticipant {
	@GetMapping("participant/idParticipant/{idParticipant}") 
	Participant getParticipantById(@PathVariable int idParticipant);
}
