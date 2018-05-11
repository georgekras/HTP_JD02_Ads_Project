package by.htp.ad_project.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "category")
public class Category extends Entity {

	private static final long serialVersionUID = -6226794434941096791L;

	@Id @GeneratedValue
	@Column(name = "ID")
    private int ID;
	
	@Column(name = "Name")	
    private String Name;

    public Category(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public Category() {
    }

    public Category(int id) {
		super(id);
	}

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    
    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
		Category other = (Category) obj;
		if (ID != other.ID)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
    
    

}
