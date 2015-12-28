package ua.nure.helperk.rest.myapi.entity;

import org.json.JSONObject;

/**
 * @author Oleg Dashkevych.
 */
public class AdvertType {

	private Long id;

	private String name;

	public AdvertType() {
	}

	public AdvertType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public AdvertType(JSONObject jsonObject) {
		this.id = jsonObject.getLong("id");
		this.name = jsonObject.getString("name");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
