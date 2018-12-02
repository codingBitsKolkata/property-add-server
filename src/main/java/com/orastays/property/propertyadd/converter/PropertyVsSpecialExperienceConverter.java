package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsSpecialExperienceEntity;
import com.orastays.property.propertyadd.model.PropertyVsSpecialExperienceModel;

@Component
public class PropertyVsSpecialExperienceConverter extends CommonConverter
		implements BaseConverter<PropertyVsSpecialExperienceEntity, PropertyVsSpecialExperienceModel> {

	private static final long serialVersionUID = 4778058926083747281L;
	private static final Logger logger = LogManager.getLogger(PropertyVsSpecialExperienceConverter.class);

	@Override
	public PropertyVsSpecialExperienceEntity modelToEntity(PropertyVsSpecialExperienceModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsSpecialExperienceModel entityToModel(PropertyVsSpecialExperienceEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsSpecialExperienceModel> entityListToModelList(List<PropertyVsSpecialExperienceEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
