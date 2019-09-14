package com.quinnox.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dguser")
@Entity
public class DGUser implements Serializable {
	@Id
	@Column(name = "user_id")
	private long id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_password")
	private String userPassword;

	public long getId() {
		return id;
	}

	public DGUser setId(long id) {
		this.id = id;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public DGUser setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public DGUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public DGUser setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public DGUser setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		return this;
	}

	@Override
	public String toString() {
		return "DGUser [id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DGUser other = (DGUser) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

}
