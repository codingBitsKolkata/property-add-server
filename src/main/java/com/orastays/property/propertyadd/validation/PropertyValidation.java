package com.orastays.property.propertyadd.validation;

import java.util.LinkedHashMap;
import java.util.Map;

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
	
	public void validateLanguageWithUserToken(Object object, String message) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}

		Util.printLog(object, PropertyAddConstant.INCOMING, message, request);
		if (object instanceof CommonModel) {
			CommonModel commonModel = (CommonModel) object;
			validateTokenAndLanguage(commonModel, message);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- End");
		}
	}
	
	private void validateTokenAndLanguage(CommonModel commonModel, String message) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		// Validate User Token
		if(StringUtils.isBlank(commonModel.getUserToken())) {
			exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
		} else {
			getUserDetails(commonModel.getUserToken());
		}
		
		// Validate Language
		if(StringUtils.isBlank(commonModel.getLanguageId())) {
			exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
		} else {
			validateLanguage(commonModel.getLanguageId());
		}
	
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- End");
		}
	}
}