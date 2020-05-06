package com.happylife.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="HL_USERS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="userId", updatable = false, nullable = false)
	private long userId;
	
	@Column(name="FNAME", nullable = false)
	private String fname;
	
	@Column(name="LNAME", nullable = false)
	private String lname;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	//@NotBlank(message="Username can not be blank")
	@Column(name="username", nullable = false)
	private String username;
	
	@Size(min=6,message="Password must be atleast 6 characters long")
	@Column(name="PASSWD", nullable = false)
	private String password;
	
	@Column(name="GENDER", nullable = false)
	private String gender;
	
	@Column(name="COUNTRY", nullable = false)
	private String country;
	
	@Column(name="PHONE", nullable = false)
	private String phone;
	
	@Column(name="IMAGE", nullable = true)
	private String image;
	
	@Column(name="POSTAL_CODE", nullable = true)
	private String postalCode;
	
	@Column(name="RESIDENCY_STATUS", nullable = true)
	private String residencyStatus;
	
	@Column(name="HOW_DID_YOU_KNOW_US", nullable = true)
	private String howDidYouKnowUs;
	
	@Column(name="ABOUT_MYSELF", nullable = true)
	private String aboutMe;
	
	@Column(name="LOOKING_FOR", nullable = true)
	private String lookingFor;
	
	@Column(name="PUBLIC_PHOTO", nullable = true)
	private String publicPhoto;
	
	
	public User(){
		super();
	}
	
	public User(long userId, String fname, String lname, String email, String username, String password, String gender,
			String country, String phone, String publicPhoto) {
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
		this.publicPhoto = publicPhoto;
	}	// used in sign up form
	
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
	}	// used in login 
	
	public User(long userId, String fname, String lname, String email, String username, String password, String gender,
			String country, String phone, String image, String aboutMyself, String lookingFor, String publicPhoto) {
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
		this.aboutMe = aboutMyself;
		this.lookingFor = lookingFor;
		this.publicPhoto = publicPhoto;
	}	// used in viewcandid

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
