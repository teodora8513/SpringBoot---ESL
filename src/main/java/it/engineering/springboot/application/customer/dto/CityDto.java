package it.engineering.springboot.application.customer.dto;

import java.io.Serializable;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class CityDto implements Serializable, MyDto {
	//@NotNull(message = "City code can not be null.")
	private Long cityCode;
	
	//@NotEmpty(message = "City name can not be empty.")
	//@Size(min = 3, max = 50, message = "City name must contains between 3 and 50 characters")
	private String cityName;

	public CityDto() {
	}

	public CityDto(Long cityCode, String cityName) {
		super();
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public Long getCityCode() {
		return cityCode;
	}

	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityDto [cityCode=" + cityCode + ", cityName=" + cityName + "]";
	}
	
}
