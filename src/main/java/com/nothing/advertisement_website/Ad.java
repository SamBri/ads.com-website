package com.nothing.advertisement_website;

import java.io.File;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID adId;

	private String name;

	private String details;

	private String amount;

	private String location;

	private String type;

	@Lob
	private File photoFile;

	@Lob
	private String photoImg;

	private String contact;

}
