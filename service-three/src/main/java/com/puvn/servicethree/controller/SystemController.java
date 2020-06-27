package com.puvn.servicethree.controller;

import com.puvn.servicethree.exception.ExceptionDTO;
import com.puvn.servicethree.repository.BranchRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Системный контроллер приложения.
 *
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 07.06.2020.
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemController {

	private final BranchRepository branchRepository;

	@Autowired
	public SystemController(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}

	@ApiOperation(value = "Возвращает Branch по его id", notes = "Возвращает Branch")
	@GetMapping(value = "branches/{id}")
	public @ResponseBody
	ResponseEntity<?> getTestEntityByLocalId(@PathVariable("id") long id) {
		var entity = this.branchRepository.findById(id);
		if (entity.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO());
		} else {
			return ResponseEntity.of(entity);
		}
	}

}