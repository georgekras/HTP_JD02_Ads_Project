package by.htp.ad_project.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "roles")
public class Role extends Entity {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "ID")
	private int ID;
	
	@Column(name = "Role")
    private String Role;

    public Role(int ID, String Role) {
        this.ID = ID;
        this.Role = Role;
    }

    public Role() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ID;
		result = prime * result + ((Role == null) ? 0 : Role.hashCode());
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
		Role other = (Role) obj;
		if (ID != other.ID)
			return false;
		if (Role == null) {
			if (other.Role != null)
				return false;
		} else if (!Role.equals(other.Role))
			return false;
		return true;
	}

    

}

