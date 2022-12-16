package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import domain.ConcreteFlight;
import domain.Flight;

public class FlightManager implements FlightManagerInterface{
ArrayList<Flight> flightsDB;

		public FlightManager () {
			flightsDB = new ArrayList<Flight>();
			
			Flight f1 = new Flight("F1","Donostia","Bilbo");
			
			f1.addConcreteFlight("CF1-1",newDate(2023,1,22),1,2,3,"12:00");
			f1.addConcreteFlight("CF1-2",newDate(2023,1,23),3,0,3,"12:00");
			f1.addConcreteFlight("CF1-3",newDate(2023,1,23),1,2,2,"13:00");
			f1.addConcreteFlight("CF1-4",newDate(2023,1,23),3,3,0,"14:00");
			f1.addConcreteFlight("CF1-5",newDate(2023,1,23),3,3,0,"15:00");
			f1.addConcreteFlight("CF1-6",newDate(2023,1,23),3,3,0,"16:00");
			f1.addConcreteFlight("CF1-7",newDate(2023,1,23),3,3,0,"17:00");
					
			Flight f2 = new Flight("F2","Donostia","Madrid");
			
			Flight f3 = new Flight("F3","Barcelona","Madrid");
			Flight f4 = new Flight("F4","Sevilla","Madrid");
			Flight f5 = new Flight("F5","Barcelona","Madrid");

			


			
			Flight f21 = new Flight("F21","Bilbo","Donostia");
			f21.addConcreteFlight("CF21-1",newDate(2023,1,21),3,3,0,"12:00");
			f21.addConcreteFlight("CF21-2",newDate(2023,1,22),3,3,0,"12:00");
			f21.addConcreteFlight("CF21-3",newDate(2023,1,23),3,3,0,"12:00");


			flightsDB.add(f1);
			flightsDB.add(f2);
			flightsDB.add(f3);
			flightsDB.add(f4);
			flightsDB.add(f5);
			

			flightsDB.add(f21);	
			
			System.out.println(getAllDepartingCities());
			System.out.println(getArrivalCitiesFrom("Donostia"));
			
		}
		public Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date) {
				ArrayList<ConcreteFlight> res = new ArrayList<ConcreteFlight>();
				for (Flight a : flightsDB) {
					if ((a.getArrivingCity().equals(arrivingCity))&&(a.getDepartingCity().equals(departingCity)))
						for (ConcreteFlight c : a.getConcreteFlights())
							if (c.getDate().equals(date)) res.add(c);
							
				}
				return res;
				
		}
		
		public List<String> getAllDepartingCities(){

			if (flightsDB.isEmpty()) return new ArrayList<String>();
			//A set is used to avoid duplicates
			SortedSet<String> setDepartingCities = new TreeSet<String>();
			Iterator<Flight> i=flightsDB.iterator();
			while (i.hasNext())
				setDepartingCities.add(i.next().getDepartingCity());
			return new ArrayList<String>(setDepartingCities);			
		}
		
		public List<String> getArrivalCitiesFrom(String departingCity){

			List<String> arrivalCities = new ArrayList<String>();

			Iterator<Flight> i=flightsDB.iterator();
			Flight f;
			while (i.hasNext()) {
				f=i.next();
				if (f.getDepartingCity().compareTo(departingCity)==0)
					arrivalCities.add(f.getArrivingCity());
			}
			Collections.sort(arrivalCities);
			return arrivalCities;
			
		}

		private Date newDate(int year,int month,int day) {

		     Calendar calendar = Calendar.getInstance();
		     calendar.set(year, month, day,0,0,0);
		     calendar.set(Calendar.MILLISECOND, 0);

		     return calendar.getTime();
		}
		
		
		
		
}
