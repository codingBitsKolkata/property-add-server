package com.orastays.property.propertyadd.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.orastays.property.propertyadd.exceptions.FormExceptions;

@Component
public class AzureFileUpload {

	private static final Logger logger = LogManager.getLogger(AzureFileUpload.class);
	
	
	@Autowired
	protected MessageUtil messageUtil;
	
	public String uploadFileByAzure(MultipartFile multipartFileInput,HttpServletRequest request) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("uploadFileByAzure -- START");
		}
		
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container=null;
		File sourceFile = null; 
		File downloadedFile = null;
		String uploadImageUrl = StringUtils.EMPTY;
		
		try {    
			// Parse the connection string and create a blob client to interact with Blob storage
			storageAccount = CloudStorageAccount.parse(messageUtil.getBundle("storage.connection.string"));
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference(messageUtil.getBundle("web.blob.dev.key"));
			container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());		    

			// construct the complete absolute path of the file
			
			sourceFile = Util.convertMultipartToFile(multipartFileInput);
			
			Writer output = new BufferedWriter(new FileWriter(sourceFile));
			output.close();
			CloudBlockBlob blob = container.getBlockBlobReference(sourceFile.getName());
			blob.uploadFromFile(sourceFile.getAbsolutePath());
			//Listing contents of container
			
			for (ListBlobItem blobItem : container.listBlobs()) {
				uploadImageUrl =  blobItem.getUri().toString();
		    }

		} 
		catch (StorageException ex)
		{
			if (logger.isDebugEnabled()) {
				logger.debug("StorageException in uploadFileByAzure=>"+String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
			}
			
			exceptions.put(messageUtil.getBundle("file.upload.failed.code"), new Exception(messageUtil.getBundle("file.upload.failed.message")));
		}
		catch (Exception ex) 
		{
			if (logger.isDebugEnabled()) {
				logger.debug("Exception in uploadFileByAzure=>"+ex.getMessage());
			}
			
			exceptions.put(messageUtil.getBundle("file.upload.failed.code"), new Exception(messageUtil.getBundle("file.upload.failed.message")));
		}
		finally 
		{
			//Pausing for input
			Scanner sc = new Scanner(System.in);
			sc.nextLine();

			try {
				if(container != null)
					container.deleteIfExists();
			} 
			catch (StorageException ex) {
				
				if (logger.isDebugEnabled()) {
					logger.debug("uploadFileByAzure=>"+String.format("Service error. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
				}
				exceptions.put(messageUtil.getBundle("file.upload.failed.code"), new Exception(messageUtil.getBundle("file.upload.failed.message")));
			}

			if(downloadedFile != null)
				downloadedFile.deleteOnExit();

			if(sourceFile != null)
				sourceFile.deleteOnExit();

			//Closing scanner
			sc.close();
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("uploadFileByAzure -- END");
		}
		
		return uploadImageUrl;
		
	}
	
	 
}
