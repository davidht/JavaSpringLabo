package com.javaspringlabo.monproject.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringlabo.monproject.dto.PrixDTO;
import com.javaspringlabo.monproject.model.Prix;
import com.javaspringlabo.monproject.service.IPrixService;

@RestController
@RequestMapping("/prix")
public class PrixController {

	@Autowired
	private IPrixService prixService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<PrixDTO>> getAll() {

		List<Prix> prices = prixService.findAll();

		List<PrixDTO> pricesDtos = prices.stream().map(this::convertToDto).toList();

		return ResponseEntity.ok(pricesDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PrixDTO> getById(@PathVariable Integer id) {

		Prix price = prixService.getById(id);

		return ResponseEntity.ok(convertToDto(price));
	}

	@GetMapping("/{idBrand}/{date}")
	public ResponseEntity<PrixDTO> getByIdBrandIdProduct(@PathVariable Integer marqueId,
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
		
		Date dateUTC = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		
		Prix prix = prixService.findPrixByMarqueIdAndDate(marqueId, dateUTC);

		return ResponseEntity.ok(convertToDto(prix));
	}
	
	private PrixDTO convertToDto(Prix price) {
		return modelMapper.map(price, PrixDTO.class);
	}
}