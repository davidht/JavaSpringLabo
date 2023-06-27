package com.javaspringlabo.monproject.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringlabo.monproject.dto.MarqueDTO;
import com.javaspringlabo.monproject.model.Marque;
import com.javaspringlabo.monproject.service.IMarqueService;

@RestController
@RequestMapping("/marques")
public class MarqueController {

	@Autowired
	private IMarqueService marqueService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<MarqueDTO>> getAll() {

		List<Marque> marques = marqueService.findAll();

		List<MarqueDTO> marquesDtos = marques.stream().map(this::convertToDto).toList();

		return ResponseEntity.ok(marquesDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MarqueDTO> getById(@PathVariable Integer id) {

		Marque brand = marqueService.getById(id);

		return ResponseEntity.ok(convertToDto(brand));
	}

	private MarqueDTO convertToDto(Marque brand) {
		return modelMapper.map(brand, MarqueDTO.class);
	}
}