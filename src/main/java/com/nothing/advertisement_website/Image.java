package com.nothing.advertisement_website;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// DEPRECATE
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

	public String getNameOfImage() {
		return nameOfImage;
	}

	public void setNameOfImage(String nameOfImage) {
		this.nameOfImage = nameOfImage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String nameOfImage;
	private String content;
	private String contentType;

	private String image;

	@Override
	public String toString() {
		this.image = getNameOfImage()+"|"+getContent()+"|"+getContentType();
		return this.image;
	}

	public static Image extract(String image) {
		String[] bin = image.split("\\|");
		
		

		if (bin.length == 3) {

			return new Image(bin[0], bin[1], bin[2]);

		}

		return null;

	}

	public Image(String nameOfImage, String content, String contentType) {
		this.nameOfImage = nameOfImage;
		this.content = content;
		this.contentType = contentType;
	}
	
	
//	private File file;
//
//	public void toFile() {
//
//		// create new file.
//		File dst = new File(this.name);
//
//	}
//
//	public String getFile() {
//
//		return "";
//	}

}
