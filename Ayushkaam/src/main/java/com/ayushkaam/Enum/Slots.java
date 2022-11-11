package com.ayushkaam.Enum;
import javax.persistence.Entity;

	public enum Slots {

		Slot1{		
			@Override
		    public String timeslot() {	    	
		    	return "9:00-12:00";
		    }
		},	
		
		Slot2{		
			@Override
		    public String timeslot() {	    	
		    	return "1:00-3:00";
		    }
		},	
		
		Slot3{		
			@Override
		    public String timeslot() {	    	
		    	return "4:00-6:00";
		    }
		};
		
		
		public String timeslot() {
			return null;
		}
	}
	
	
	

