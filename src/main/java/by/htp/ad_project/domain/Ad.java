package by.htp.ad_project.domain;

public class Ad extends Entity {

	private static final long serialVersionUID = 1984566728743718380L;

    private int ID;
    private String Title, SmallDesc, Description;
    private int Price;
    private int users_ID, category_ID;

    public Ad(int ID, String title, String smallDesc, String description, int price, int users_ID, int category_ID) {
        this.ID = ID;
        Title = title;
        SmallDesc = smallDesc;
        Description = description;
        Price = price;
        this.users_ID = users_ID;
        this.category_ID = category_ID;
    }

    public Ad() {
    }

    public Ad(int id) {
    	super(id);
	}

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSmallDesc() {
        return SmallDesc;
    }

    public void setSmallDesc(String smallDesc) {
        SmallDesc = smallDesc;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", SmallDesc='" + SmallDesc + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", users_ID=" + users_ID +
                ", category_ID=" + category_ID +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ID;
		result = prime * result + Price;
		result = prime * result + ((SmallDesc == null) ? 0 : SmallDesc.hashCode());
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		result = prime * result + category_ID;
		result = prime * result + users_ID;
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
		Ad other = (Ad) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (ID != other.ID)
			return false;
		if (Price != other.Price)
			return false;
		if (SmallDesc == null) {
			if (other.SmallDesc != null)
				return false;
		} else if (!SmallDesc.equals(other.SmallDesc))
			return false;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (category_ID != other.category_ID)
			return false;
		if (users_ID != other.users_ID)
			return false;
		return true;
	}
    
    

}
