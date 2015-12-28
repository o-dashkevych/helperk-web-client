package ua.nure.helperk.rest.myapi.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {

	private Long id;

	private String email;

	private String name;

	private String password;

	private UserRole role;

	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(JSONObject jsonObject) {
		try {
			this.id = jsonObject.getLong("id");
			this.email = jsonObject.getString("email");
			this.name = jsonObject.getString("name");
			this.password = jsonObject.getString("password");
			this.role = new UserRole((JSONObject) jsonObject.get("role"));

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}