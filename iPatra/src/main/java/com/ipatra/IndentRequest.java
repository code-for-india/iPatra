package com.ipatra;

import java.util.Calendar;

public class IndentRequest {
	int schoolId;
	Calendar forDate;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public Calendar getForDate() {
		return forDate;
	}
	public void setForDate(Calendar forDate) {
		this.forDate = forDate;
	}

}
