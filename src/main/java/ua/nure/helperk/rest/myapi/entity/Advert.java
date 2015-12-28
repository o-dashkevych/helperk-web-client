package ua.nure.helperk.rest.myapi.entity;

import org.json.JSONObject;

import java.sql.Timestamp;

/**
 * @author Oleg Dashkevych.
 */
public class Advert {

	private Long id;

	private String titleName;

	private String description;

	private Timestamp startDate;

	private Timestamp endDate;

	private Double price;

	private User creator;

	private User executor;

	private AdvertType type;

	public Advert() {
	}

	public Advert(Long id, String titleName, String description, Timestamp startDate,
				  Timestamp endDate, Double price, User creator, User executor, AdvertType type) {
		this.id = id;
		this.titleName = titleName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.creator = creator;
		this.executor = executor;
		this.type = type;
	}

	public Advert(JSONObject jsonObject) {
		this.id = jsonObject.getLong("id");
		this.titleName = jsonObject.getString("titleName");
		this.description = jsonObject.getString("description");
		this.startDate = new Timestamp(jsonObject.getLong("startDate"));
		this.endDate = new Timestamp(jsonObject.getLong("endDate"));
		this.price = jsonObject.getDouble("price");
		this.creator = new User((JSONObject) jsonObject.get("creator"));
		this.executor = new User((JSONObject) jsonObject.get("executor"));
		this.type = new AdvertType((JSONObject) jsonObject.get("type"));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
