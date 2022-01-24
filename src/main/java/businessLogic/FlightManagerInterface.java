package businessLogic;

import java.util.Collection;
import java.util.Date;

import domain.ConcreteFlight;

public interface FlightManagerInterface{
	Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date);
}