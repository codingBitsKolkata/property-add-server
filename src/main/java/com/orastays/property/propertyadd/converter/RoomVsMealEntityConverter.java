package com.orastays.property.propertyadd.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsMealEntity;

@Component
public class RoomVsMealEntityConverter extends CommonConverter
		implements BaseConverter<RoomVsMealEntity, RoomVsMealModel> {

	private static final Logger logger = LogManager.getLogger(RoomVsMealEntityConverter.class);

}
