package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.CancellationSlabEntity;
import com.orastays.property.propertyadd.model.CancellationSlabModel;

@Component
public class CancellationSlabConverter extends CommonConverter
		implements BaseConverter<CancellationSlabEntity, CancellationSlabModel> {

	private static final long serialVersionUID = -7542630944396995253L;
	private static final Logger logger = LogManager.getLogger(CancellationSlabConverter.class);

	@Override
	public CancellationSlabEntity modelToEntity(CancellationSlabModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CancellationSlabModel entityToModel(CancellationSlabEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CancellationSlabModel> entityListToModelList(List<CancellationSlabEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
