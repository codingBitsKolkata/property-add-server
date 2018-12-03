package com.orastays.property.propertyadd.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.service.PropertyService;

@Service
@Transactional
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {

	private static final Logger logger = LogManager.getLogger(PropertyServiceImpl.class);
	
	@Override
	public List<PropertyTypeModel> fetchAllPropertyTypeByLanguage(String languageId) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAllPropertyTypeByLanguage -- START");
		}
		
		List<PropertyTypeModel> propertyTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<String, String>();
			innerMap1.put("status", "1");
			innerMap1.put("languageId", languageId);
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<String, Map<String, String>>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<String, Map<String, Map<String, String>>>();
			alliasMap.put(entitymanagerPackagesToScan+".PropertyTypeEntity", outerMap1);
	
			propertyTypeModels = propertyTypeConverter.entityListToModelList(propertyTypeDAO.fetchListBySubCiteria(alliasMap));
			
		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAllPropertyTypeByLanguage -- END");
		}
		
		return propertyTypeModels;
	}

}
