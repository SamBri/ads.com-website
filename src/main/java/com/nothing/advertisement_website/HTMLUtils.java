package com.nothing.advertisement_website;

import java.io.File;
import java.util.Base64;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class HTMLUtils {

	public static String createDataUrl(String format, String base64) {
		
		
	

		String dataUrl = "data:image/:format;base64,:base64String";

		dataUrl = dataUrl.replace(":format", format);
		dataUrl = dataUrl.replace(":base64String", base64);

		return dataUrl;
	}

}
