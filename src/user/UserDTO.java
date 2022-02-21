package user;

public class UserDTO {

	String userID;
	String userPassword;
	String userName;
	int userAge;
	String userGender;
	String userEmail;
	String userProfile;

	


	
	public UserDTO(String userID, String userPassword, String userName, int userAge, String userGender,
			String userEmail, String userProfile) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userProfile = userProfile;
	}

	public UserDTO(String userPassword2, String userName2, int userAge2, String userGender2, String userEmail2,
			String userID2) {
		super();
		this.userPassword = userPassword2;
		this.userName = userName2;
		this.userAge = userAge2;
		this.userGender = userGender2;
		this.userEmail = userEmail2;
		this.userID = userID2;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
}
