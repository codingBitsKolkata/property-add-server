package com.orastays.property.propertyadd.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class PropertyVsImageModel extends CommonModel {

	@JsonProperty("propertyImageId")
	private String propertyImageId;
	
	@JsonProperty("imageURL")
	private String imageURL;
	
	@JsonProperty("images")
	private List<MultipartFile> multipartFiles;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
}
