package ua.nure.helperk.rest.myapi.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author Oleg Dashkevych.
 */
public class UserRole implements Serializable {

	private Long id;

	private String name;

	public UserRole() {
	}

	public UserRole(String name) {
		this.name = name;
	}

	public UserRole(JSONObject jsonObject) {
		try {
			this.id = jsonObject.getLong("id");
			this.name = jsonObject.getString("name");
		} catch (JSONException e) {
			e.printStackTrace();
		}
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
