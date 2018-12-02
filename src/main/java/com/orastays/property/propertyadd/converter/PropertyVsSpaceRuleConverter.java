package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsSpaceRuleEntity;
import com.orastays.property.propertyadd.model.PropertyVsSpaceRuleModel;

@Component
public class PropertyVsSpaceRuleConverter extends CommonConverter
		implements BaseConverter<PropertyVsSpaceRuleEntity, PropertyVsSpaceRuleModel> {

	private static final long serialVersionUID = 4884374267851340797L;
	private static final Logger logger = LogManager.getLogger(PropertyVsSpaceRuleConverter.class);

	@Override
	public PropertyVsSpaceRuleEntity modelToEntity(PropertyVsSpaceRuleModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsSpaceRuleModel entityToModel(PropertyVsSpaceRuleEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsSpaceRuleModel> entityListToModelList(List<PropertyVsSpaceRuleEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
