package com.oatech.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class Contact implements Serializable{
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
