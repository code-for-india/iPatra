package com.akshaya.ipatra.vo;

import java.io.Serializable;
import java.util.Date;

public class School implements Serializable {

	private String schoolId 	= null;
	
	private String schoolName 	= null;
	private String schoolArea 	= null;
	private int  todaysIntent  	= 0;
	private int yesterdayActual = 0;
	private int tomorrowRequest = 0;
	private Date intentDt   	= null ;
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolArea() {
		return schoolArea;
	}
	public void setSchoolArea(String schoolAread) {
		this.schoolArea = schoolAread;
	}
	public int getTodaysIntent() {
		return todaysIntent;
	}
	public void setTodaysIntent(int todaysIntent) {
		this.todaysIntent = todaysIntent;
	}
	public int getYesterdayActual() {
		return yesterdayActual;
	}
	public void setYesterdayActual(int yesterdayActual) {
		this.yesterdayActual = yesterdayActual;
	}
	public int getTomorrowRequest() {
		return tomorrowRequest;
	}
	public void setTomorrowRequest(int tomorrowRequest) {
		this.tomorrowRequest = tomorrowRequest;
	}
	
	public Date getIntentDt() {
		return intentDt;
	}
	public void setIntentDt(Date intentDt) {
		this.intentDt = intentDt;
	}
}
