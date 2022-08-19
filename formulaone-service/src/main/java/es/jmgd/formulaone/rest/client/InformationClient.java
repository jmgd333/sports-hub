package es.jmgd.formulaone.rest.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.jmgd.formulaone.rest.client.fallback.InformationClientFallback;
import es.jmgd.formulaone.rest.model.information.Information;

@FeignClient(name = "info-service", path = "/information", fallback = InformationClientFallback.class)
public interface InformationClient {
	@PostMapping
	public ResponseEntity<Void> addRequestInformation(@Valid @RequestBody Information information);
}