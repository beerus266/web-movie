package Model;

public class Person {
	public   String Name;
	public String Country;
	public String Birthday;
	public int id;
	public  boolean Sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSex() {
		return Sex;
	}

	public void setSex(boolean sex) {
		Sex = sex;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
}
