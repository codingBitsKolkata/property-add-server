package com.orastays.property.propertyadd.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.CommonModel;

@Component
@Transactional
public class PropertyValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(PropertyValidation.class);
	
	public void validateFetchPropertyType(CommonModel commonModel) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateFetchPropertyType -- Start");
		}

		Util.printLog(commonModel, PropertyAddConstant.INCOMING, "Fetch Property Type", request);
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		if(Objects.nonNull(commonModel)) {
			
			// Validate User Token
			if(StringUtils.isBlank(commonModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				getUserDetails(commonModel.getUserToken());
			}
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateFetchPropertyType -- End");
		}
	}
}