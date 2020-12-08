package com.dublin.parkapi.service;

import com.dublin.parkapi.dto.DeleteParkDTO;
import com.dublin.parkapi.dto.DublinCityParkUpdateDTO;
import com.dublin.parkapi.dto.DunLaoghaireUpdateDTO;
import com.dublin.parkapi.dto.FingalCountryUpdateDTO;
import com.dublin.parkapi.model.DublinCityPlayArea;
import com.dublin.parkapi.model.DunLaoghaire;
import com.dublin.parkapi.model.FingalCountryPlayArea;

import java.util.List;

public interface ParkService {

	List<DublinCityPlayArea> getDublinCityParkDetails();

	List<FingalCountryPlayArea> getFingalCountryCouncilData();

	List<DunLaoghaire> getDunLaoghaireData();

	void updateDublinCityPark(DublinCityParkUpdateDTO dublinCityParkUpdateDTO);

	void updateFingalCountry(FingalCountryUpdateDTO fingalCountryUpdateDTO);

	void updateDunLaoghaire(DunLaoghaireUpdateDTO dunLaoghaireUpdateDTO);

	void deleteDublinCityParkDetails(long id);

	void deleteFingalCountryCouncilDetails(long id);

	void deleteDunLaoghaireDetails(long id);
}
