package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.DiscountCategoryOraEntity;
import com.orastays.property.propertyadd.helper.Util;
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
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		DiscountCategoryOraModel discountCategoryOraModel = null;
		
		if(Objects.nonNull(e)){
			discountCategoryOraModel = new DiscountCategoryOraModel();
			discountCategoryOraModel = (DiscountCategoryOraModel) Util.transform(modelMapper, e, discountCategoryOraModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return discountCategoryOraModel;
	}

	@Override
	public List<DiscountCategoryOraModel> entityListToModelList(List<DiscountCategoryOraEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<DiscountCategoryOraModel> discountCategoryOraModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			discountCategoryOraModels = new ArrayList<>();
			for(DiscountCategoryOraEntity discountCategoryOraEntity:es) {
				discountCategoryOraModels.add(entityToModel(discountCategoryOraEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return discountCategoryOraModels;
	}
}
