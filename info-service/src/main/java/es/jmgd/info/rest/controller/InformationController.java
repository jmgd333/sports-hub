package es.jmgd.info.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.jmgd.info.database.entity.Information;
import es.jmgd.info.rest.service.InformationService;

@RestController
@RequestMapping(path = "/information")
public class InformationController {

	@Autowired
	private InformationService informationService;

	@PostMapping
	public ResponseEntity<Boolean> addRequestInformation(@Valid @RequestBody Information information,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getFieldErrors().toString());
		}
		return informationService.addRequestInformation(information);
	}

}
