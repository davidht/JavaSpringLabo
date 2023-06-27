package com.javaspringlabo.monproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import com.javaspringlabo.monproject.dto.MarqueDTO;
import com.javaspringlabo.monproject.model.Marque;
import com.javaspringlabo.monproject.repository.MarqueRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.MethodName.class)
class Test_Architecture {

	private static final Integer MARQUE_ID = 1;
	private static final String MARQUE_NOM = "Java";

	ResultMatcher OK = MockMvcResultMatchers.status().isOk();
	ResultMatcher KO = MockMvcResultMatchers.status().is4xxClientError();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MarqueRepository marqueRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	void Test_01_RepoDataLoad() {
		long total = marqueRepo.count();
		assertEquals(1L, total);
	}

	@Test
	void Test_02_Mapping_to_DTO() {
		Marque marque = new Marque();
		marque.setId(MARQUE_ID);
		marque.setNom(MARQUE_NOM);

		MarqueDTO dto = modelMapper.map(marque, MarqueDTO.class);
		Integer dtoId = dto.getId();
		String dtoNom = dto.getNom();

		assertEquals(MARQUE_ID, dtoId);
		assertEquals(MARQUE_NOM, dtoNom);
	}

	@Test
	void Test_03_Mapping_to_Entity() {
		MarqueDTO dto = new MarqueDTO();
		dto.setId(MARQUE_ID);
		dto.setNom(MARQUE_NOM);

		Marque marque = modelMapper.map(dto, Marque.class);
		Integer id = marque.getId();
		String nom = marque.getNom();

		assertEquals(MARQUE_ID, id);
		assertEquals(MARQUE_NOM, nom);
	}

	@Test
	void Test_04_happy_requests() {

		MockHttpServletRequestBuilder builderRequesOk = MockMvcRequestBuilders.get("/marques");
		try {
			this.mockMvc.perform(builderRequesOk).andExpect(OK);
		} catch (Exception e) {
			Assert.isTrue(false, "Exception: " + e);
		}

		MockHttpServletRequestBuilder builder2 = MockMvcRequestBuilders.get("/marques/1");
		try {
			this.mockMvc.perform(builder2).andExpect(OK).andExpect(jsonPath("$.nom").value(MARQUE_NOM));
		} catch (Exception e) {
			Assert.isTrue(false, "Exception: " + e);
		}

	}

	@Test
	void Test_05_wrong_requests() {
		MockHttpServletRequestBuilder builder3 = MockMvcRequestBuilders.get("/ERROR");
		try {
			this.mockMvc.perform(builder3).andExpect(KO);
		} catch (Exception e) {
			Assert.isTrue(false, "Exception: " + e);
		}
	}
}
