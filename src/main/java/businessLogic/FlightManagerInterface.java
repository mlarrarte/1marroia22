package businessLogic;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import domain.ConcreteFlight;

public interface FlightManagerInterface{
	Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date);
	public List<String> getAllDepartingCities();
	public List<String> getArrivalCitiesFrom(String departingCity);
}