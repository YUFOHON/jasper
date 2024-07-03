package site.zhourui.jasperreportdemo.entity.po;

import java.io.Serializable;



/**
 * @Description 
 * @author: bruce
 * @date 2024/06/30
 */
public class Address01 implements Serializable {
    /**
     * 
     */
	private Integer id;

    /**
     * 
     */
	private String firstname;

    /**
     * 
     */
	private String lastname;

    /**
     * 
     */
	private String street;

    /**
     * 
     */
	private String city;

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

	@Override
	public String toString(){
        return "id:"+ (id == null?"空":id)+","+"firstname:"+ (firstname == null?"空":firstname)+","+"lastname:"+ (lastname == null?"空":lastname)+","+"street:"+ (street == null?"空":street)+","+"city:"+ (city == null?"空":city);
	}
}