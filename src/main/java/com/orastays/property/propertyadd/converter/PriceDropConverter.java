package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PriceDropEntity;
import com.orastays.property.propertyadd.model.PriceDropModel;

@Component
public class PriceDropConverter extends CommonConverter implements BaseConverter<PriceDropEntity, PriceDropModel> {

	private static final long serialVersionUID = 776600662250519034L;
	private static final Logger logger = LogManager.getLogger(PriceDropConverter.class);

	@Override
	public PriceDropEntity modelToEntity(PriceDropModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PriceDropModel entityToModel(PriceDropEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PriceDropModel> entityListToModelList(List<PriceDropEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
