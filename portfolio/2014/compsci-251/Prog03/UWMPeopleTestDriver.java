

public class UWMPeopleTestDriver {

	public static void main(String[] args) {
		boolean passedAllTests = true;
		int r = (int)(Math.random() * 100);
		int r2 = (int)(Math.random() * 10);
		double gpa = Math.random() * 4;
		UWMPerson p = new UWMPerson(r, ""+(r+r2), ""+(r*r2));
		UWMStudent s = new UWMStudent(r+1, ""+(r+r2+1), ""+(r*r2+1), gpa);
		UWMStaff f = new UWMStaff(r+2, ""+(r+r2+2), ""+(r*r2+2));
		
		if(p.getUwmId() != r) {
			passedAllTests = false;
			System.out.println("UWMPerson not assigning or getting id appropriately");
		}
		
		if(!p.getFirstName().equals(""+(r+r2))) {
			passedAllTests = false;
			System.out.println("UWMPerson not assigning or getting first name appropriately");
		}
		
		if(!p.getLastName().equals(""+(r*r2))) {
			passedAllTests = false;
			System.out.println("UWMPerson not assigning or getting last name appropriately");
		}
		
		if(!("[UWMPerson = uwmId: " + r + ", name: " + (r+r2) + " " + (r*r2) + "]").equals(p.toString())) {
			passedAllTests = false;
			System.out.println("UWMPerson toString method not working correctly");
		}
		
		if(!p.equals(p) || !p.equals(new UWMPerson(r, ""+(r+r2), ""+(r*r2))) || !p.equals(new UWMPerson(r, "", "")) || p.equals(new UWMPerson(r+1, ""+(r+r2), ""+(r*r2)))) {
			passedAllTests = false;
			System.out.println("UWMPerson equals method not working correctly");
		}
		
		if(!(s instanceof UWMPerson)) {
			passedAllTests = false;
			System.out.println("UWMStudent should inherit from UWMPerson");
		}

		if(!(f instanceof UWMPerson)) {
			passedAllTests = false;
			System.out.println("UWMStaff should inherit from UWMPerson");
		}
		
		UWMPerson s2 = s;
		
		if(s2.getUwmId() != r+1) {
			passedAllTests = false;
			System.out.println("UWMStudent not assigning or getting id appropriately");
		}
		
		if(!s2.getFirstName().equals(""+(r+r2+1))) {
			passedAllTests = false;
			System.out.println("UWMStudent not assigning or getting first name appropriately");
		}
		
		if(!s2.getLastName().equals(""+(r*r2+1))) {
			passedAllTests = false;
			System.out.println("UWMStudent not assigning or getting last name appropriately");
		}
		
		if(s.getGpa() != gpa) {
			passedAllTests = false;
			System.out.println("UWMStudent not assigning or getting gpa appropriately");
		}
		
		if(!("[UWMStudent = uwmId: " + (r+1) + ", name: " + (r+r2+1) + " " + (r*r2+1) + ", gpa: " + gpa + "]").equals(s.toString())) {
			passedAllTests = false;
			System.out.println("UWMStudent toString method not working correctly");
		}
		
		if(!s.equals(s) || !s.equals(new UWMStudent(r+1, ""+(r+r2+1), ""+(r*r2+1), gpa)) || !s.equals(new UWMStudent(r+1, "", "", gpa-1)) || s.equals(new UWMStudent(r, ""+(r+r2+1), ""+(r*r2+1), gpa))) {
			passedAllTests = false;
			System.out.println("UWMStudent equals method not working correctly");
		}
		
		UWMPerson f2 = f;
		
		if(f2.getUwmId() != r+2) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting id appropriately");
		}
		
		if(!f2.getFirstName().equals(""+(r+r2+2))) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting first name appropriately");
		}
		
		if(!f2.getLastName().equals(""+(r*r2+2))) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting last name appropriately");
		}
		
		f.setTitle(""+(r*r));
		if(!f.getTitle().equals(""+(r*r))) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting title appropriately");
		}
		
		f.setHourlyPay(gpa*3);
		if(f.getHourlyPay() != gpa*3) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting hourly pay appropriately");
		}
		
		f.setHoursPerWeek(gpa*10);
		if(f.getHoursPerWeek() != gpa*10) {
			passedAllTests = false;
			System.out.println("UWMStaff not assigning or getting last name appropriately");
		}
		
		if(!("[UWMStaff = uwmId: " + (r+2) + ", name: " + (r+r2+2) + " " + (r*r2+2) + ", title: " + (r*r) + 
				", hourly pay: " + (gpa*3) + ", hours/week: " + (gpa*10) + "]").equals(f.toString())) {
			passedAllTests = false;
			System.out.println("UWMStaff toString method not working correctly");
		}
		
		if(!f.equals(f) || !f.equals(new UWMStaff(r+2, ""+(r+r2+2), ""+(r*r2+2))) || !f.equals(new UWMStaff(r+2, "", "")) || f.equals(new UWMStaff(r, ""+(r+r2+2), ""+(r*r2+2)))) {
			passedAllTests = false;
			System.out.println("UWMStaff equals method not working correctly");
		}
		
		if(passedAllTests) {
			System.out.println("Your code passed all tests! (However, you should test UWMPeopleDriver manually)");
		}
	}

}
