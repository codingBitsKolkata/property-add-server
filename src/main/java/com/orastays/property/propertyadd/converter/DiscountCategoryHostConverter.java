package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.DiscountCategoryHostEntity;
import com.orastays.property.propertyadd.model.DiscountCategoryHostModel;

@Component
public class DiscountCategoryHostConverter extends CommonConverter
		implements BaseConverter<DiscountCategoryHostEntity, DiscountCategoryHostModel> {

	private static final long serialVersionUID = 4719399804116610845L;
	private static final Logger logger = LogManager.getLogger(DiscountCategoryHostConverter.class);

	@Override
	public DiscountCategoryHostEntity modelToEntity(DiscountCategoryHostModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscountCategoryHostModel entityToModel(DiscountCategoryHostEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscountCategoryHostModel> entityListToModelList(List<DiscountCategoryHostEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
