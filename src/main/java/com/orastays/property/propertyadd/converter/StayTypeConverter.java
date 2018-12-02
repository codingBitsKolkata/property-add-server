package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.WishlistEntity;
import com.orastays.property.propertyadd.model.WishlistModel;

@Component
public class StayTypeConverter extends CommonConverter implements BaseConverter<WishlistEntity, WishlistModel> {

	private static final long serialVersionUID = 8570388740658367542L;
	private static final Logger logger = LogManager.getLogger(StayTypeConverter.class);

	@Override
	public WishlistEntity modelToEntity(WishlistModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WishlistModel entityToModel(WishlistEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WishlistModel> entityListToModelList(List<WishlistEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
