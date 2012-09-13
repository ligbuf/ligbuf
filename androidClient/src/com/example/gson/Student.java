package com.example.gson;
import java.util.ArrayList;

public class Student
{

    String name = new String();
    int age;
    String currentjob = new String();
    ArrayList<String> jobs = new ArrayList<String>();
    boolean isExistGirlFriend = false;
    
    public Student(){
    	
        this.name = "ȫ�浿";
        this.age = 29;
        this.isExistGirlFriend = true;
        this.currentjob ="Programmer";
        this.jobs.add("Student");
        this.jobs.add("Programmer");
        this.jobs.add("Dancer");
    }

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCurrentjob() {
		return currentjob;
	}

	public ArrayList<String> getJobs() {
		return jobs;
	}

	public boolean isExistGirlFriend() {
		return isExistGirlFriend;
	}
    
} 