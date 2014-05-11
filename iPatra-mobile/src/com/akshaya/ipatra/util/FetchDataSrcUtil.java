package com.akshaya.ipatra.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.akshaya.ipatra.vo.School;

public class FetchDataSrcUtil {

	public static List<School> fetchSchoolList() {
		
		List<School> listSchool =  new ArrayList<School>(); 
		
		School sc1 = new School();
		sc1.setIntentDt(new Date());
		sc1.setSchoolArea("BAGALAGUNT");
		sc1.setSchoolId("SCH01");
		sc1.setTodaysIntent(100);
		sc1.setSchoolName("GHPS-SRIKANTAPURA");
		
		School sc2 = new School();
		sc2.setIntentDt(new Date());
		sc2.setSchoolArea("BAGALAGUNT");
		sc2.setSchoolId("SCH02");
		sc2.setTodaysIntent(200);
		sc2.setSchoolName("GLPS-HANUMANTHA SAGAR");
		
		School sc3 = new School();
		sc3.setIntentDt(new Date());
		sc3.setSchoolArea("BAGALAGUNT");
		sc3.setSchoolId("SCH03");
		sc3.setTodaysIntent(200);
		sc3.setSchoolName("GHPS-HEGGADADEVANAPURA");
		
		
		School sc4 = new School();
		sc4.setIntentDt(new Date());
		sc4.setSchoolArea("BAGALAGUNT");
		sc4.setSchoolId("SCH04");
		sc4.setTodaysIntent(230);
		sc4.setSchoolName("GHS-MAKALI");
		
		
		School sc5 = new School();
		sc5.setIntentDt(new Date());
		sc5.setSchoolArea("BAGALAGUNT");
		sc5.setSchoolId("SCH05");
		sc5.setTodaysIntent(430);
		sc5.setSchoolName("GHPS-SIDDANA HOSAHALLI");
		
		
		listSchool.add( sc1);
		listSchool.add( sc2);
		listSchool.add( sc3);
		listSchool.add( sc4);
		listSchool.add( sc5);
		listSchool.add( sc1);
		listSchool.add( sc2);
		listSchool.add( sc3);
		listSchool.add( sc4);
		listSchool.add( sc5);
		listSchool.add( sc1);
		listSchool.add( sc2);
		listSchool.add( sc3);
		listSchool.add( sc4);
		listSchool.add( sc5);
		listSchool.add( sc1);
		listSchool.add( sc2);
		listSchool.add( sc3);
		listSchool.add( sc4);
		listSchool.add( sc5);
		
		
		
		
		/*
		 * 	"GHPS-SRIKANTAPURA", 
		    		"GLPS-HANUMANTHA SAGAR", 
		    		"GHPS-HEGGADADEVANAPURA",
		    		"GHS-MAKALI", 
		    		"GHPS-SIDDANA HOSAHALLI", 
		    		"GHPS-MADHAVARA", 
		    		"GHS-CHIKKABIDARAKALLU", 
		    		"GHPS-SRIKANTAPURA",
		    		"GLPS-HANUMANTHA SAGAR", 
		    		"GHPS-MADANAYAKANAHALLI", 
		    		"GHS-MAKALI", 
		 */
		
		
		return listSchool;
		
	}

}
