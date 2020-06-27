package com.puvn.servicethree.controller;

import com.puvn.servicethree.entity.Branch;
import com.puvn.servicethree.exception.ExceptionDTO;
import com.puvn.servicethree.lat.Distancer;
import com.puvn.servicethree.repository.BranchRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

	@ApiOperation(value = "Возвращает Branch по его id", notes = "Возвращает Branch")
	@GetMapping(value = "/branches")
	public @ResponseBody
	ResponseEntity<?> getLon(@RequestParam(name = "lat") Double lat, @RequestParam(name = "lon") Double lon) {
		var branches = this.branchRepository.findAll();
		Branch result = null;
		Map<Long, Double> branchesByLat = new HashMap<>();
		Distancer distancer = new Distancer();
		branches.forEach(branch ->
				branchesByLat.put(branch.getId(), distancer.distance(branch.getLat(), lat, branch.getLon(), lon)));
		Map.Entry<Long, Double> minEntry = null;
		for (Map.Entry<Long, Double> entry : branchesByLat.entrySet()) {
			if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
				minEntry = entry;
			}
		}
		var entity = this.branchRepository.findById(minEntry.getKey());
		return ResponseEntity.of(entity);
	}

}