package com.ielab.ieotel_springboot.models;

import java.util.Date;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Client")
public class Client {

	@Id
	private String id;
	private String code;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String tel;
	private String email;
	private String adress;
	private Date deletedAt;
    private Date updatedAt;
	private Date createdAt;
	private boolean deleted;

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", code='" + code + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthday=" + birthday +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", adress='" + adress + '\'' +
				", deletedAt=" + deletedAt +
				", updatedAt=" + updatedAt +
				", createdAt=" + createdAt +
				", deleted=" + deleted +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}

