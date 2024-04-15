package com.tdc.app.platform.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.tdc.app.platform.resource.StaffDetailsResourceController;

/*
 * By storing images locally and saving their paths or names in a database,
 *  we strike a balance between performance and scalability, 
 * ensuring a smooth user experience while handling a growing library of images.
 */
@Component
public class ImageSaver {
	
	private Path fileStorageLocation = null;
	
	private Path path= null;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailsResourceController.class);


	  @Autowired
	  public ImageSaver(Environment env) {
	    this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./uploads/files"))
	        .toAbsolutePath().normalize();

	    try {
	    	 this.path = Files.createDirectories(this.fileStorageLocation);
	    	
	    } catch (Exception ex) {
	      throw new RuntimeException(
	          "Could not create the directory where the uploaded files will be stored.", ex);
	    }
	  }

	/*
	 * The saveImageToStorage method generates a unique filename, saves the image to
	 * a specified directory, and returns the filename. The getImage method
	 * retrieves an image by its filename, and the deleteImage method removes an
	 * image from local storage.
	 * 
	 * Save image in a local directory
	 */

	public String saveImageToStorage(MultipartFile imageFile) throws IOException {
		String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

		//Path uploadPath = Path.of(uploadDirectory);
		Path filePath = this.path.resolve(uniqueFileName);
		 LOGGER.info("The file path is {} ",this.path);
    	 LOGGER.info("The file fileStorageLocation is {} ",this.fileStorageLocation);
		if (!Files.exists(this.path)) {
			Files.createDirectories(this.path);
		}

		Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		return uniqueFileName;
	}

	// To view an image
	public byte[] getImage(String imageDirectory, String imageName) throws IOException {
		Path imagePath = Path.of(imageDirectory, imageName);

		if (Files.exists(imagePath)) {
			byte[] imageBytes = Files.readAllBytes(imagePath);
			return imageBytes;
		} else {
			return null; // Handle missing images
		}
	}

	// Delete an image
	public String deleteImage(String imageDirectory, String imageName) throws IOException {
		Path imagePath = Path.of(imageDirectory, imageName);

		if (Files.exists(imagePath)) {
			Files.delete(imagePath);
			return "Success";
		} else {
			return "Failed"; // Handle missing images
		}
	}
}
