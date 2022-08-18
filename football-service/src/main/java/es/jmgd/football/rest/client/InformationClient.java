package es.jmgd.football.rest.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import es.jmgd.football.rest.model.information.Information;

@FeignClient(name = "info-service")
@RequestMapping(path = "/information")
public interface InformationClient {
	@PostMapping
	public ResponseEntity<Void> addRequestInformation(@Valid @RequestBody Information information);
}
