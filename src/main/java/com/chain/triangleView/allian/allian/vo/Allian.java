package com.chain.triangleView.allian.allian.vo;

import java.util.Date;

public class Allian {
	private Date allianStartDate;
	private Date allianEndDate;
	private int allianWriter;
	private String coorLink;
	
	public Allian(){}

	public Allian(Date allianStartDate, Date allianEndDate, int allianWriter, String coorLink) {
		super();
		this.allianStartDate = allianStartDate;
		this.allianEndDate = allianEndDate;
		this.allianWriter = allianWriter;
		this.coorLink = coorLink;
	}

	public Date getAllianStartDate() {
		return allianStartDate;
	}

	public Date getAllianEndDate() {
		return allianEndDate;
	}

	public int getAllianWriter() {
		return allianWriter;
	}

	public String getCoorLink() {
		return coorLink;
	}

	public void setAllianStartDate(Date allianStartDate) {
		this.allianStartDate = allianStartDate;
	}

	public void setAllianEndDate(Date allianEndDate) {
		this.allianEndDate = allianEndDate;
	}

	public void setAllianWriter(int allianWriter) {
		this.allianWriter = allianWriter;
	}

	public void setCoorLink(String coorLink) {
		this.coorLink = coorLink;
	}

	@Override
	public String toString() {
		return "Allian [allianStartDate=" + allianStartDate + ", allianEndDate=" + allianEndDate + ", allianWriter="
				+ allianWriter + ", coorLink=" + coorLink + "]";
	}

	
	
	

}
