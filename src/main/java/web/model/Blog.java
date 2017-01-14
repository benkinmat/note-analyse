package web.model;


import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import web.service.DateConvertion;

public class Blog {

	private String _id;
	private String category;
	private String promotepic;
	private String author;
	private String header;
	private String description;
	private String content;
	@JsonDeserialize(using = DateConvertion.class)
	private Date date;
	
	public Blog() {
		super();
	}

	private Blog(String _id, String category, String promotepic, String author, String header, String description, String content, Date date) {
		super();
		this._id = _id;
		this.category = category;
		this.promotepic = promotepic;
		this.author = author;
		this.header = header;
		this.description = description;
		this.content = content;
		this.date = date;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static Blog getInstance(String _id, String category, String promotepic, String author, String header, String description, String content, Date date){
		return new Blog(_id, category, promotepic, author, header, description, content, date);
	}

	public String getPromotepic() {
		return promotepic;
	}

	public void setPromotepic(String promotepic) {
		this.promotepic = promotepic;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
