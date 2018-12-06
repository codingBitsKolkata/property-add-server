package com.orastays.property.propertyadd.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.orastays.property.propertyadd.dao.PropertyTypeDAO;
import com.orastays.property.propertyadd.dao.SpecialExperienceDAO;
import com.orastays.property.propertyadd.helper.MessageUtil;

public class CommonConverter {

	@Autowired
	protected ModelMapper modelMapper;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected MessageUtil messageUtil;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;
}
