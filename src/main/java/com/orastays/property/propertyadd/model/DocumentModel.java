package com.orastays.property.propertyadd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentModel {

	@JsonProperty("documentId")
	private Long documentId;

	@JsonProperty("documentName")
	private String documentName;

	@JsonProperty("propertyVsDocuments")
	private List<PropertyVsDocumentModel> propertyVsDocumentModels;
}
