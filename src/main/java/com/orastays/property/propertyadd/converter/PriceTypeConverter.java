package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PriceTypeEntity;
import com.orastays.property.propertyadd.model.PriceTypeModel;

@Component
public class PriceTypeConverter extends CommonConverter implements BaseConverter<PriceTypeEntity, PriceTypeModel> {

	private static final long serialVersionUID = 8908736000853319703L;
	private static final Logger logger = LogManager.getLogger(PriceTypeConverter.class);

	@Override
	public PriceTypeEntity modelToEntity(PriceTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceTypeModel entityToModel(PriceTypeEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PriceTypeModel> entityListToModelList(List<PriceTypeEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
