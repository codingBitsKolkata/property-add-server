package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.DiscountCategoryOraEntity;
import com.orastays.property.propertyadd.model.DiscountCategoryOraModel;

@Component
public class DiscountCategoryOraConverter extends CommonConverter
		implements BaseConverter<DiscountCategoryOraEntity, DiscountCategoryOraModel> {

	private static final long serialVersionUID = 5418480658817209636L;
	private static final Logger logger = LogManager.getLogger(DiscountCategoryOraConverter.class);

	@Override
	public DiscountCategoryOraEntity modelToEntity(DiscountCategoryOraModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscountCategoryOraModel entityToModel(DiscountCategoryOraEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscountCategoryOraModel> entityListToModelList(List<DiscountCategoryOraEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}
}
