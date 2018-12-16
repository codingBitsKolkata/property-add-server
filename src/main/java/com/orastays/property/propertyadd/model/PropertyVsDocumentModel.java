package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class PropertyVsDocumentModel {

	@JsonProperty("userVsDocumentId")
	private Long userVsDocumentId;

	@JsonProperty("documentNumber")
	private String documentNumber;

	@JsonProperty("fileUrl")
	private String fileUrl;

	@JsonProperty("property")
	private PropertyModel propertyModel;
	
	@JsonProperty("document")
	private DocumentModel documentModel;
}
