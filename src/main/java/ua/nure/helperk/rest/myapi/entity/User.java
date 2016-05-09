package ua.nure.helperk.rest.myapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
@Data
@NoArgsConstructor
public class User implements Serializable {

	private Long id;

	private String email;

	private String name;

	private String password;

	private UserRole role;

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
}