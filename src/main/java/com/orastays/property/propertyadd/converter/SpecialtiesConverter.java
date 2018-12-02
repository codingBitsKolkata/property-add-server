package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsPriceEntity;
import com.orastays.property.propertyadd.model.RoomVsPriceModel;

@Component
public class SpecialtiesConverter extends CommonConverter
		implements BaseConverter<RoomVsPriceEntity, RoomVsPriceModel> {

	private static final long serialVersionUID = -6987883354674730631L;
	private static final Logger logger = LogManager.getLogger(SpecialtiesConverter.class);

	@Override
	public RoomVsPriceEntity modelToEntity(RoomVsPriceModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsPriceModel entityToModel(RoomVsPriceEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsPriceModel> entityListToModelList(List<RoomVsPriceEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
