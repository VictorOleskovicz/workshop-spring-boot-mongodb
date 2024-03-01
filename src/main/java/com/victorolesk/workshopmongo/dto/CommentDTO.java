package com.victorolesk.workshopmongo.dto;

import java.util.Date;

public class CommentDTO {
	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public CommentDTO() {
		
	}
	

	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}



	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	

}
