package site.zhourui.jasperreportdemo.entity.query;



/**
 * @Description 查询对象
 * @author: bruce
 * @date 2024/06/30
 */
public class Address01Query extends BaseQuery{
    /**
     * 
     */
	private Integer id;

    /**
     * 
     */
	private String firstname;

	private String firstnameFuzzy;

    /**
     * 
     */
	private String lastname;

	private String lastnameFuzzy;

    /**
     * 
     */
	private String street;

	private String streetFuzzy;

    /**
     * 
     */
	private String city;

	private String cityFuzzy;

	public void setId(Integer id) {
        this.id = id;
	}

	public Integer getId() {
        return this.id;
	}

	public void setFirstname(String firstname) {
        this.firstname = firstname;
	}

	public String getFirstname() {
        return this.firstname;
	}

	public void setLastname(String lastname) {
        this.lastname = lastname;
	}

	public String getLastname() {
        return this.lastname;
	}

	public void setStreet(String street) {
        this.street = street;
	}

	public String getStreet() {
        return this.street;
	}

	public void setCity(String city) {
        this.city = city;
	}

	public String getCity() {
        return this.city;
	}

	public void setFirstnameFuzzy(String firstnameFuzzy) {
        this.firstnameFuzzy = firstnameFuzzy;
	}

	public String getFirstnameFuzzy() {
        return this.firstnameFuzzy;
	}

	public void setLastnameFuzzy(String lastnameFuzzy) {
        this.lastnameFuzzy = lastnameFuzzy;
	}

	public String getLastnameFuzzy() {
        return this.lastnameFuzzy;
	}

	public void setStreetFuzzy(String streetFuzzy) {
        this.streetFuzzy = streetFuzzy;
	}

	public String getStreetFuzzy() {
        return this.streetFuzzy;
	}

	public void setCityFuzzy(String cityFuzzy) {
        this.cityFuzzy = cityFuzzy;
	}

	public String getCityFuzzy() {
        return this.cityFuzzy;
	}

}