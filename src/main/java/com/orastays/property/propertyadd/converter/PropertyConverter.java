package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.entity.PropertyEntity;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.PropertyModel;

@Component
public class PropertyConverter extends CommonConverter implements BaseConverter<PropertyEntity, PropertyModel> {

	private static final long serialVersionUID = 1937719597880236169L;
	private static final Logger logger = LogManager.getLogger(PropertyConverter.class);

	@Override
	public PropertyEntity modelToEntity(PropertyModel m) {
		
		PropertyEntity propertyEntity = new PropertyEntity();
		propertyEntity = (PropertyEntity) Util.transform(modelMapper, m, propertyEntity);
		propertyEntity.setStatus(Status.ACTIVE.ordinal());
		propertyEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		propertyEntity.setCreatedDate(Util.getCurrentDateTime());
		
		propertyEntity.setPropertyTypeEntity(propertyTypeDAO.find(Long.parseLong(m.getPropertyTypeModel().getPropertyTypeId())));
		propertyEntity.setPgCategorySexEntity(pgCategorySexDAO.find(Long.parseLong(m.getPgCategorySexModel().getPgcsId())));
		propertyEntity.setStayTypeEntity(stayTypeDAO.find(Long.valueOf(m.getStayTypeModel().getStayTypeId())));
		
		
		
		return propertyEntity;
	}

	@Override
	public PropertyModel entityToModel(PropertyEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyModel propertyModel = new PropertyModel();
		propertyModel = (PropertyModel) Util.transform(modelMapper, e, propertyModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyModel;
	}

	@Override
	public List<PropertyModel> entityListToModelList(List<PropertyEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyModel> propertyModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyModels = new ArrayList<>();
			for(PropertyEntity propertyEntity:es) {
				propertyModels.add(entityToModel(propertyEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyModels;
	}

}
