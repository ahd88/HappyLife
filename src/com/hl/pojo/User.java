package com.hl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="HL_USERS")
public class User {
	
	// MySql does not support sequence, that is why it is changed into AUTO
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="USER_ID", updatable = false, nullable = false)
	private long userId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="EMAIL")
	private String email;
	
	//@NotBlank(message="Username can not be blank")
	@Column(name="username")
	private String username;
	
	@Size(min=6,message="Password must be atleast 6 characters long")
	@Column(name="PASSWD")
	private String password;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="RESIDENCY_STATUS")
	private String residencyStatus;
	
	@Column(name="HOW_DID_YOU_KNOW_US")
	private String howDidYouKnowUs;
	
	@Column(name="ABOUT_MYSELF")
	private String aboutMe;
	
	@Column(name="LOOKING_FOR")
	private String lookingFor;
	
	@Column(name="PUBLIC_PHOTO")
	private String publicPhoto;
	
	
	public User(){
		super();
	}
	
	public User(long userId, String fname, String lname, String email, String username, String password, String gender,
			String country, String phone, String image, String publicPhoto) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.country = country;
		this.phone = phone;
		this.image = image;
		this.publicPhoto = publicPhoto;
	}

	public long getId() {
		return userId;
	}

	public void setId(long id) {
		this.userId = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getResidencyStatus() {
		return residencyStatus;
	}

	public void setResidencyStatus(String residencyStatus) {
		this.residencyStatus = residencyStatus;
	}

	public String getHowDidYouKnowUs() {
		return howDidYouKnowUs;
	}

	public void setHowDidYouKnowUs(String howDidYouKnowUs) {
		this.howDidYouKnowUs = howDidYouKnowUs;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getPublicPhoto() {
		return publicPhoto;
	}

	public void setPublicPhoto(String publicPhoto) {
		this.publicPhoto = publicPhoto;
	}
	
}
