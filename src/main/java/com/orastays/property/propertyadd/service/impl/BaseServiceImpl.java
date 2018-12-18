package com.orastays.property.propertyadd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.property.propertyadd.converter.AccommodationConverter;
import com.orastays.property.propertyadd.converter.AmenitiesConverter;
import com.orastays.property.propertyadd.converter.AmenitiesTypeConverter;
import com.orastays.property.propertyadd.converter.CancellationSlabConverter;
import com.orastays.property.propertyadd.converter.PGCategorySexConverter;
import com.orastays.property.propertyadd.converter.PriceDropConverter;
import com.orastays.property.propertyadd.converter.PriceTypeConverter;
import com.orastays.property.propertyadd.converter.PropertyConverter;
import com.orastays.property.propertyadd.converter.PropertyTypeConverter;
import com.orastays.property.propertyadd.converter.PropertyVsDescriptionConverter;
import com.orastays.property.propertyadd.converter.PropertyVsDocumentConverter;
import com.orastays.property.propertyadd.converter.PropertyVsGuestAccessConverter;
import com.orastays.property.propertyadd.converter.PropertyVsImageConverter;
import com.orastays.property.propertyadd.converter.PropertyVsNearbyConverter;
import com.orastays.property.propertyadd.converter.PropertyVsPriceDropConverter;
import com.orastays.property.propertyadd.converter.PropertyVsSpaceRuleConverter;
import com.orastays.property.propertyadd.converter.PropertyVsSpecialExperienceConverter;
import com.orastays.property.propertyadd.converter.RoomCategoryConverter;
import com.orastays.property.propertyadd.converter.RoomConverter;
import com.orastays.property.propertyadd.converter.RoomVsAmenitiesConverter;
import com.orastays.property.propertyadd.converter.RoomVsBedConverter;
import com.orastays.property.propertyadd.converter.RoomVsCancellationConverter;
import com.orastays.property.propertyadd.converter.RoomVsHostDiscountConverter;
import com.orastays.property.propertyadd.converter.RoomVsImageConverter;
import com.orastays.property.propertyadd.converter.RoomVsMealConverter;
import com.orastays.property.propertyadd.converter.RoomVsOraDiscountConverter;
import com.orastays.property.propertyadd.converter.RoomVsOraPricePercentageConverter;
import com.orastays.property.propertyadd.converter.RoomVsPriceConverter;
import com.orastays.property.propertyadd.converter.RoomVsSpecialitiesConverter;
import com.orastays.property.propertyadd.converter.SpaceRuleConverter;
import com.orastays.property.propertyadd.converter.SpecialExperienceConverter;
import com.orastays.property.propertyadd.converter.SpecialtiesConverter;
import com.orastays.property.propertyadd.converter.StayTypeConverter;
import com.orastays.property.propertyadd.converter.UserVsAccountConverter;
import com.orastays.property.propertyadd.dao.AccommodationDAO;
import com.orastays.property.propertyadd.dao.AmenitiesDAO;
import com.orastays.property.propertyadd.dao.AmenitiesTypeDAO;
import com.orastays.property.propertyadd.dao.CancellationSlabDAO;
import com.orastays.property.propertyadd.dao.DiscountCategoryOraDAO;
import com.orastays.property.propertyadd.dao.PGCategorySexDAO;
import com.orastays.property.propertyadd.dao.PriceDropDAO;
import com.orastays.property.propertyadd.dao.PriceTypeDAO;
import com.orastays.property.propertyadd.dao.PropertyDAO;
import com.orastays.property.propertyadd.dao.PropertyTypeDAO;
import com.orastays.property.propertyadd.dao.PropertyVsDescriptionDAO;
import com.orastays.property.propertyadd.dao.PropertyVsDocumentDAO;
import com.orastays.property.propertyadd.dao.PropertyVsGuestAccessDAO;
import com.orastays.property.propertyadd.dao.PropertyVsImageDAO;
import com.orastays.property.propertyadd.dao.PropertyVsNearbyDAO;
import com.orastays.property.propertyadd.dao.PropertyVsPriceDropDAO;
import com.orastays.property.propertyadd.dao.PropertyVsSpaceRuleDAO;
import com.orastays.property.propertyadd.dao.PropertyVsSpecialExperienceDAO;
import com.orastays.property.propertyadd.dao.RoomCategoryDAO;
import com.orastays.property.propertyadd.dao.RoomDAO;
import com.orastays.property.propertyadd.dao.RoomVsAmenitiesDAO;
import com.orastays.property.propertyadd.dao.RoomVsBedDAO;
import com.orastays.property.propertyadd.dao.RoomVsCancellationDAO;
import com.orastays.property.propertyadd.dao.RoomVsHostDiscountDAO;
import com.orastays.property.propertyadd.dao.RoomVsImageDAO;
import com.orastays.property.propertyadd.dao.RoomVsMealDAO;
import com.orastays.property.propertyadd.dao.RoomVsOraDiscountDAO;
import com.orastays.property.propertyadd.dao.RoomVsOraPricePercentageDAO;
import com.orastays.property.propertyadd.dao.RoomVsPriceDAO;
import com.orastays.property.propertyadd.dao.RoomVsSpecialitiesDAO;
import com.orastays.property.propertyadd.dao.SpaceRuleDAO;
import com.orastays.property.propertyadd.dao.SpecialExperienceDAO;
import com.orastays.property.propertyadd.dao.SpecialtiesDAO;
import com.orastays.property.propertyadd.dao.StayTypeDAO;
import com.orastays.property.propertyadd.dao.UserVsAccountDAO;
import com.orastays.property.propertyadd.validation.PropertyValidation;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected PropertyValidation propertyValidation;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected PropertyTypeConverter propertyTypeConverter;
	
	@Autowired
	protected StayTypeConverter stayTypeConverter;
	
	@Autowired
	protected StayTypeDAO stayTypeDAO;
	
	@Autowired
	protected AccommodationConverter accommodationConverter;
	
	@Autowired
	protected AccommodationDAO accommodationDAO;
	
	@Autowired
	protected PGCategorySexConverter pgCategorySexConverter;
	
	@Autowired
	protected PGCategorySexDAO pgCategorySexDAO;
	
	@Autowired
	protected AmenitiesTypeConverter amenitiesTypeConverter;
	
	@Autowired
	protected AmenitiesTypeDAO amenitiesTypeDAO;
	
	@Autowired
	protected AmenitiesConverter amenitiesConverter;
	
	@Autowired
	protected AmenitiesDAO amenitiesDAO;
	
	@Autowired
	protected SpecialExperienceConverter specialExperienceConverter;
	
	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;
	
	@Autowired
	protected SpaceRuleConverter spaceRuleConverter;
	
	@Autowired
	protected SpaceRuleDAO spaceRuleDAO;
	
	@Autowired
	protected SpecialtiesConverter specialtiesConverter;
	
	@Autowired
	protected SpecialtiesDAO specialtiesDAO;
	
	@Autowired
	protected RoomCategoryConverter roomCategoryConverter;
	
	@Autowired
	protected RoomCategoryDAO roomCategoryDAO;
	
	@Autowired
	protected PriceTypeConverter priceTypeConverter;
	
	@Autowired
	protected PriceTypeDAO priceTypeDAO;
	
	@Autowired
	protected CancellationSlabConverter cancellationSlabConverter;
	
	@Autowired
	protected CancellationSlabDAO cancellationSlabDAO;
	
	@Autowired
	protected PriceDropDAO priceDropDAO;
	
	@Autowired
	protected PriceDropConverter priceDropConverter;
	
	@Autowired
	protected PropertyConverter propertyConverter;
	
	@Autowired
	protected PropertyDAO propertyDAO;
	
	@Autowired
	protected UserVsAccountConverter userVsAccountConverter;
	
	@Autowired
	protected UserVsAccountDAO userVsAccountDAO;
	
	@Autowired
	protected PropertyVsDescriptionConverter propertyVsDescriptionConverter;
	
	@Autowired
	protected PropertyVsDescriptionDAO propertyVsDescriptionDAO;
	
	@Autowired
	protected PropertyVsDocumentConverter propertyVsDocumentConverter;
	
	@Autowired
	protected PropertyVsDocumentDAO propertyVsDocumentDAO;
	
	@Autowired
	protected PropertyVsSpecialExperienceConverter pVsSpecialExperienceConverter;
	
	@Autowired
	protected PropertyVsSpecialExperienceDAO propertyVsSpecialExperienceDAO;
	
	@Autowired
	protected PropertyVsGuestAccessConverter propertyVsGuestAccessConverter;
	
	@Autowired
	protected PropertyVsGuestAccessDAO propertyVsGuestAccessDAO;
	
	@Autowired
	protected PropertyVsImageConverter propertyVsImageConverter;
	
	@Autowired
	protected PropertyVsImageDAO propertyVsImageDAO;
	
	@Autowired
	protected PropertyVsNearbyConverter propertyVsNearbyConverter;
	
	@Autowired
	protected PropertyVsNearbyDAO propertyVsNearbyDAO;
	
	@Autowired
	protected PropertyVsPriceDropConverter propertyVsPriceDropConverter;
	
	@Autowired
	protected PropertyVsPriceDropDAO propertyVsPriceDropDAO;
	
	@Autowired
	protected PropertyVsSpaceRuleConverter propertyVsSpaceRuleConverter;
	
	@Autowired
	protected PropertyVsSpaceRuleDAO propertyVsSpaceRuleDAO;
	
	@Autowired
	protected RoomConverter roomConverter;
	
	@Autowired
	protected RoomDAO roomDAO;
	
	@Autowired
	protected RoomVsAmenitiesDAO roomVsAmenitiesDAO;
	
	@Autowired
	protected RoomVsAmenitiesConverter roomVsAmenitiesConverter;
	
	@Autowired
	protected RoomVsImageDAO roomVsImageDAO;
	
	@Autowired
	protected RoomVsImageConverter roomVsImageConverter;
	
	@Autowired
	protected RoomVsHostDiscountDAO roomVsHostDiscountDAO;
	
	@Autowired
	protected RoomVsHostDiscountConverter roomVsHostDiscountConverter;
	
	@Autowired
	protected RoomVsOraDiscountConverter roomVsOraDiscountConverter;
	
	@Autowired
	protected RoomVsOraDiscountDAO roomVsOraDiscountDAO;
	
	@Autowired
	protected RoomVsOraPricePercentageConverter roomVsOraPricePercentageConverter;
	
	@Autowired
	protected RoomVsOraPricePercentageDAO roomVsOraPricePercentageDAO;
	
	@Autowired
	protected RoomVsPriceConverter roomVsPriceConverter;
	
	@Autowired
	protected RoomVsPriceDAO roomVsPriceDAO;
	
	@Autowired
	protected RoomVsSpecialitiesConverter roomVsSpecialitiesConverter;
	
	@Autowired
	protected RoomVsSpecialitiesDAO roomVsSpecialitiesDAO;
	
	@Autowired
	protected RoomVsMealConverter roomVsMealConverter;
	
	@Autowired
	protected RoomVsMealDAO roomVsMealDAO;
	
	@Autowired
	protected RoomVsCancellationConverter roomVsCancellationConverter;
	
	@Autowired
	protected RoomVsCancellationDAO roomVsCancellationDAO;
	
	@Autowired
	protected DiscountCategoryOraDAO discountCategoryOraDAO;
	
	@Autowired
	protected RoomVsBedConverter roomVsBedConverter;
	
	@Autowired
	protected RoomVsBedDAO roomVsBedDAO;
	
	
	
}
