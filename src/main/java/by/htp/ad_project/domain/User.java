package by.htp.ad_project.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "users")
public class User extends Entity {

	private static final long serialVersionUID = -1919018243680435461L;

	@Id @GeneratedValue
	@Column(name = "ID")
    private int ID;
	
	@Column(name = "Login")
    private String Login;
	
	@Column(name = "Email")
    private String Email;
	
	@Column(name = "Password")
    private String Password;
	
	@Column(name = "Nickname")
    private String Nickname;
	
	@Column(name = "PhoneNumber")
    private String PhoneNumber;
	
	@Column(name = "roles_ID")
    private int roles_ID;

    public User(int ID, String Login, String Email, String Password, String Nickname, String PhoneNumber, int roles_ID) {
        this.ID = ID;
        this.Login = Login;
        this.Email = Email;
        this.Password = Password;
        this.Nickname = Nickname;
        this.PhoneNumber = PhoneNumber;
        this.roles_ID = roles_ID;
    }

    public User() {
    }
    

    public User(int id) {
		super(id);
	}

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getRoles_ID() {
        return roles_ID;
    }

    public void setRoles_ID(int roles_ID) {
        this.roles_ID = roles_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Nickname='" + Nickname + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", roles_ID=" + roles_ID +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Nickname == null) ? 0 : Nickname.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + roles_ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (ID != other.ID)
			return false;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Nickname == null) {
			if (other.Nickname != null)
				return false;
		} else if (!Nickname.equals(other.Nickname))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (roles_ID != other.roles_ID)
			return false;
		return true;
	}
    
    

}
