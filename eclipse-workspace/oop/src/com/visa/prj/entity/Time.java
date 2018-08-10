package com.visa.prj.entity;

public class Time {
	private int hours;
	private int minutes;
	
	
	
	public Time(int hours, int minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}



	public Time() {
		super();
	}



	public int getHours()
	{
		return(this.hours);
	}

	public int getMin()
	{
		return(this.minutes);
	}
	
	public static Time add(Time t1, Time t2)
	{
	 Time t3=new Time();
	 t3.hours=t1.hours+t2.hours;
	 t3.minutes=t1.minutes+t2.minutes;
	 if(t3.minutes>60)
	 {
		 t3.hours++;
		 t3.minutes=t3.minutes-60;
	 }
	 return t3;
	}
	
	public Time add(Time t2)
	{
		Time t3=new Time();
		t3.hours=this.hours+t2.hours;
		 t3.minutes=this.minutes+t2.minutes;
		 if(t3.minutes>60)
		 {
			 t3.hours++;
			 t3.minutes=t3.minutes-60;
		 }
		 return t3;
		
	}
}
