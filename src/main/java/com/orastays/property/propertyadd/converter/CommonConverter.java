package com.orastays.property.propertyadd.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.orastays.property.propertyadd.dao.AccommodationDAO;
import com.orastays.property.propertyadd.dao.AmenitiesDAO;
import com.orastays.property.propertyadd.dao.CancellationSlabDAO;
import com.orastays.property.propertyadd.dao.DiscountCategoryHostDAO;
import com.orastays.property.propertyadd.dao.DiscountCategoryOraDAO;
import com.orastays.property.propertyadd.dao.DocumentDAO;
import com.orastays.property.propertyadd.dao.MealCategoryDAO;
import com.orastays.property.propertyadd.dao.MealDaysDAO;
import com.orastays.property.propertyadd.dao.MealPlanCatVsMealPlanDAO;
import com.orastays.property.propertyadd.dao.MealPriceCategoryDAO;
import com.orastays.property.propertyadd.dao.MealTypeDAO;
import com.orastays.property.propertyadd.dao.PGCategorySexDAO;
import com.orastays.property.propertyadd.dao.PriceDropDAO;
import com.orastays.property.propertyadd.dao.PriceTypeDAO;
import com.orastays.property.propertyadd.dao.PropertyTypeDAO;
import com.orastays.property.propertyadd.dao.RoomCategoryDAO;
import com.orastays.property.propertyadd.dao.RoomStandardDAO;
import com.orastays.property.propertyadd.dao.SpaceRuleDAO;
import com.orastays.property.propertyadd.dao.SpecialExperienceDAO;
import com.orastays.property.propertyadd.dao.SpecialtiesDAO;
import com.orastays.property.propertyadd.dao.StayTypeDAO;
import com.orastays.property.propertyadd.dao.UserVsAccountDAO;
import com.orastays.property.propertyadd.helper.MessageUtil;

public class CommonConverter {

	@Autowired
	protected ModelMapper modelMapper;

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected MessageUtil messageUtil;

	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;

	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;

	@Autowired
	protected PGCategorySexDAO pgCategorySexDAO;

	@Autowired
	protected StayTypeDAO stayTypeDAO;
	
	@Autowired
	protected UserVsAccountDAO userVsAccountDAO;
	
	@Autowired
	protected DocumentDAO documentDAO;
	
	@Autowired
	protected PriceDropDAO priceDropDAO;
	
	@Autowired
	protected SpaceRuleDAO spaceRuleDAO;
	
	@Autowired
	protected AccommodationDAO accommodationDAO;
	
	@Autowired
	protected RoomCategoryDAO roomCategoryDAO;
	
	@Autowired
	protected RoomStandardDAO roomStandardDAO;
	
	@Autowired
	protected AmenitiesDAO amenitiesDAO;
	
	@Autowired
	protected CancellationSlabDAO cancellationSlabDAO;
	
	@Autowired
	protected DiscountCategoryHostDAO discountCategoryHostDAO;
	
	@Autowired
	protected MealCategoryDAO mealCategoryDAO;
	
	@Autowired
	protected MealDaysDAO mealDaysDAO;
	
	@Autowired
	protected MealPlanCatVsMealPlanDAO mealPlanCatVsMealPlanDAO;
	
	@Autowired
	protected MealPriceCategoryDAO mealPriceCategoryDAO;
	
	@Autowired
	protected MealTypeDAO mealTypeDAO; 
	
	@Autowired
	protected DiscountCategoryOraDAO discountCategoryOraDAO;
	
	@Autowired
	protected PriceTypeDAO priceTypeDAO;
	
	@Autowired
	protected SpecialtiesDAO specialtiesDAO;
	
	@Autowired
	protected PropertyTypeConverter propertyTypeConverter;
	
	@Autowired
	protected PGCategorySexConverter pgCategorySexConverter;
	
	@Autowired
	protected StayTypeConverter stayTypeConverter;
	
	@Autowired
	protected UserVsAccountConverter userVsAccountConverter;
	
	@Autowired
	protected PropertyVsDocumentConverter propertyVsDocumentConverter;
	
	@Autowired
	protected PropertyVsDescriptionConverter propertyVsDescriptionConverter;
	
	@Autowired
	protected PropertyVsGuestAccessConverter propertyVsGuestAccessConverter;
	
	@Autowired
	protected PropertyVsImageConverter propertyVsImageConverter;
	
	@Autowired
	protected PropertyVsNearbyConverter propertyVsNearbyConverter;
	
	@Autowired
	protected PropertyVsPriceDropConverter propertyVsPriceDropConverter;
	
	@Autowired
	protected PropertyVsSpaceRuleConverter propertyVsSpaceRuleConverter;
	
	@Autowired
	protected PropertyVsSpecialExperienceConverter vsSpecialExperienceConverter;
	
	@Autowired
	protected DocumentConverter documentConverter;
	
	@Autowired
	protected PriceDropConverter priceDropConverter;
	
	@Autowired
	protected SpaceRuleConverter spaceRuleConverter;
	
	@Autowired
	protected SpecialExperienceConverter specialExperienceConverter;

	@Autowired
	protected RoomConverter roomConverter;
	
	@Autowired
	protected AccommodationConverter accommodationConverter;
	
	@Autowired
	protected DiscountCategoryOraConverter discountCategoryOraConverter;
	
	@Autowired
	protected RoomCategoryConverter roomCategoryConverter;
	
	@Autowired
	protected RoomStandardConverter roomStandardConverter;
	
	@Autowired
	protected RoomVsBedConverter roomVsBedConverter;
	
	@Autowired
	protected RoomVsAmenitiesConverter roomVsAmenitiesConverter;
	
	@Autowired
	protected AmenitiesConverter amenitiesConverter;
	
	@Autowired
	protected RoomVsCancellationConverter roomVsCancellationConverter;
	
	@Autowired
	protected CancellationSlabConverter cancellationSlabConverter;
	
	@Autowired
	protected RoomVsImageConverter roomVsImageConverter;
	
	@Autowired
	protected RoomVsPriceConverter roomVsPriceConverter;
	
	@Autowired
	protected PriceTypeConverter priceTypeConverter;
	
	@Autowired
	protected RoomVsHostDiscountConverter roomVsHostDiscountConverter;
	
	@Autowired 
	protected DiscountCategoryHostConverter discountCategoryHostConverter;
	
	@Autowired
	protected RoomVsOraDiscountConverter roomVsOraDiscountConverter;
	
	@Autowired
	protected RoomVsOraPricePercentageConverter roomVsOraPricePercentageConverter;
	
	@Autowired
	protected RoomVsSpecialitiesConverter roomVsSpecialitiesConverter;
	
	@Autowired
	protected SpecialtiesConverter specialtiesConverter;
	
	@Autowired
	protected RoomVsMealConverter roomVsMealConverter;
	
	@Autowired
	protected MealCategoryConverter mealCategoryConverter;
	
	@Autowired
	protected MealDaysConverter mealDaysConverter;
	
	@Autowired
	protected MealPlanCatVsMealPlanConverter mealPlanCatVsMealPlanConverter;
	
	@Autowired
	protected MealPlanCategoryConverter mealPlanCategoryConverter;
	
	@Autowired
	protected MealPlanConverter mealPlanConverter;
	
	@Autowired
	protected MealPriceCategoryConverter mealPriceCategoryConverter;
	
	@Autowired
	protected MealTypeConverter mealTypeConverter;
}
