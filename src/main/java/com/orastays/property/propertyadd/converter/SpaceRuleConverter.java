package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.SpaceRuleEntity;
import com.orastays.property.propertyadd.model.SpaceRuleModel;

@Component
public class SpaceRuleConverter extends CommonConverter implements BaseConverter<SpaceRuleEntity, SpaceRuleModel> {

	private static final long serialVersionUID = 2903501634398417294L;
	private static final Logger logger = LogManager.getLogger(SpaceRuleConverter.class);

	@Override
	public SpaceRuleEntity modelToEntity(SpaceRuleModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpaceRuleModel entityToModel(SpaceRuleEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpaceRuleModel> entityListToModelList(List<SpaceRuleEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
