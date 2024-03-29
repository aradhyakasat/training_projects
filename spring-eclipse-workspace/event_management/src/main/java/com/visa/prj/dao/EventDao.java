package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Event;

public interface EventDao {
	
	void addEvent(Event event);
	List<Event> getOpenEvents();
	List<Event> getClosedEvents();
	Event getEventById(int id);

}
