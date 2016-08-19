package de.goeuro.entity;

import de.goeuro.utilites.Constants;
import de.goeuro.utilites.Utility;

public class City {

	private long _id;

	private String name;

	private String type;

	private GeoPosition geo_position;

	public City() {
		// default constructor
	}

	public City(long _id, String name, String type, GeoPosition geo_position) {
		super();
		this._id = _id;
		this.name = name;
		this.type = type;
		this.geo_position = geo_position;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GeoPosition getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}

	@Override
	public String toString() {
		return get_id() + Constants.SEPARATOR + Utility.appendDQ(getName()) + Constants.SEPARATOR
				+ Utility.appendDQ(getType()) + Constants.SEPARATOR + getGeo_position().getLatitude()
				+ Constants.SEPARATOR + getGeo_position().getLongitude();

	}

}
