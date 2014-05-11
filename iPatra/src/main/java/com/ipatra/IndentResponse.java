package com.ipatra;

public class IndentResponse {

	String menuName;
	int requestedServingQty;
	int previousDayRequestedServingQty;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getRequestedServingQty() {
		return requestedServingQty;
	}
	public void setRequestedServingQty(int requestedServingQty) {
		this.requestedServingQty = requestedServingQty;
	}
	public int getPreviousDayRequestedServingQty() {
		return previousDayRequestedServingQty;
	}
	public void setPreviousDayRequestedServingQty(int previousDayRequestedServingQty) {
		this.previousDayRequestedServingQty = previousDayRequestedServingQty;
	}
	
}
