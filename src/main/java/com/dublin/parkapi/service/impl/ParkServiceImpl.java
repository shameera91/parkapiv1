package com.dublin.parkapi.service.impl;

import com.dublin.parkapi.dto.DeleteParkDTO;
import com.dublin.parkapi.dto.DublinCityParkUpdateDTO;
import com.dublin.parkapi.dto.DunLaoghaireUpdateDTO;
import com.dublin.parkapi.dto.FingalCountryUpdateDTO;
import com.dublin.parkapi.model.DublinCityPlayArea;
import com.dublin.parkapi.model.DunLaoghaire;
import com.dublin.parkapi.model.FingalCountryPlayArea;
import com.dublin.parkapi.repository.DublinCityPlayAreaRepository;
import com.dublin.parkapi.repository.DunLaoghaireRepository;
import com.dublin.parkapi.repository.FingalCountryPlayAreaRepository;
import com.dublin.parkapi.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkServiceImpl implements ParkService {

	@Autowired
	private DublinCityPlayAreaRepository dublinCityPlayAreaRepository;

	@Autowired
	private FingalCountryPlayAreaRepository fingalCountryPlayAreaRepository;

	@Autowired
	private DunLaoghaireRepository dunLaoghaireRepository;

	@Override
	public List<DublinCityPlayArea> getDublinCityParkDetails() {
		return dublinCityPlayAreaRepository.findAll();
	}

	@Override
	public List<FingalCountryPlayArea> getFingalCountryCouncilData() {
		return fingalCountryPlayAreaRepository.findAll();
	}

	@Override
	public List<DunLaoghaire> getDunLaoghaireData() {
		return dunLaoghaireRepository.findAll();
	}

	@Override
	public void updateDublinCityPark(DublinCityParkUpdateDTO dublinCityParkUpdateDTO) {
		Optional<DublinCityPlayArea> byId = dublinCityPlayAreaRepository.findById(dublinCityParkUpdateDTO.getId());
		DublinCityPlayArea dublinCityPlayArea = byId.get();
		dublinCityPlayArea.setName(dublinCityParkUpdateDTO.getName());
		dublinCityPlayArea.setOpeningHours(dublinCityParkUpdateDTO.getOpeningHours());
		dublinCityPlayArea.setPhoneNumber(dublinCityParkUpdateDTO.getPhoneNumber());
		dublinCityPlayArea.setEmail(dublinCityParkUpdateDTO.getEmail());
		dublinCityPlayArea.setFacilities(dublinCityParkUpdateDTO.getFacilities());
		dublinCityPlayArea.setAccessibility(dublinCityParkUpdateDTO.getAccessibility());
		dublinCityPlayArea.setAddressLineOne(dublinCityParkUpdateDTO.getAddressLineOne());
		dublinCityPlayArea.setDependentLocality(dublinCityParkUpdateDTO.getDependentLocality());
		dublinCityPlayArea.setLocality(dublinCityParkUpdateDTO.getLocality());
		dublinCityPlayArea.setAdministrativeArea(dublinCityParkUpdateDTO.getAdministrativeArea());
		dublinCityPlayArea.setPostalCode(dublinCityParkUpdateDTO.getPostalCode());
		dublinCityPlayArea.setCountry(dublinCityParkUpdateDTO.getCountry());
		dublinCityPlayAreaRepository.save(dublinCityPlayArea);
	}

	@Override
	public void updateFingalCountry(FingalCountryUpdateDTO fingalCountryUpdateDTO) {
		Optional<FingalCountryPlayArea> byId = fingalCountryPlayAreaRepository.findById(fingalCountryUpdateDTO.getId());
		FingalCountryPlayArea fingalCountryPlayArea = byId.get();
		fingalCountryPlayArea.setName(fingalCountryUpdateDTO.getName());
		fingalCountryPlayArea.setAddress1(fingalCountryUpdateDTO.getAddress1());
		fingalCountryPlayArea.setAddress2(fingalCountryUpdateDTO.getAddress2());
		fingalCountryPlayArea.setAddress3(fingalCountryUpdateDTO.getAddress3());
		fingalCountryPlayArea.setAddress4(fingalCountryUpdateDTO.getAddress4());
		fingalCountryPlayArea.setPhone(fingalCountryUpdateDTO.getPhone());
		fingalCountryPlayArea.setEmail(fingalCountryUpdateDTO.getEmail());
		fingalCountryPlayArea.setWebsite(fingalCountryUpdateDTO.getWebsite());
		fingalCountryPlayArea.setType(fingalCountryUpdateDTO.getType());
		fingalCountryPlayArea.setCategory(fingalCountryUpdateDTO.getCategory());
		fingalCountryPlayArea.setOpeningHours(fingalCountryUpdateDTO.getOpeningHours());
		fingalCountryPlayArea.setDirections(fingalCountryUpdateDTO.getDirections());
		fingalCountryPlayArea.setSurfaceType(fingalCountryUpdateDTO.getSurfaceType());
		fingalCountryPlayArea.setComments(fingalCountryUpdateDTO.getComments());
		fingalCountryPlayArea.setAccessiblePlayItems(fingalCountryUpdateDTO.getAccessiblePlayItems());
		fingalCountryPlayArea.setDisabledParking(fingalCountryUpdateDTO.getDisabledParking());
		fingalCountryPlayArea.setParkRanger(fingalCountryUpdateDTO.getParkRanger());
		fingalCountryPlayArea.setToilets(fingalCountryUpdateDTO.getToilets());
		fingalCountryPlayArea.setDisabledToilets(fingalCountryUpdateDTO.getDisabledToilets());
		fingalCountryPlayArea.setBabyChanging(fingalCountryUpdateDTO.getBabyChanging());
		fingalCountryPlayArea.setSeating(fingalCountryUpdateDTO.getSeating());
		fingalCountryPlayArea.setDrinkingWater(fingalCountryUpdateDTO.getDrinkingWater());
		fingalCountryPlayArea.setLatitude(fingalCountryUpdateDTO.getLatitude());
		fingalCountryPlayArea.setLongitude(fingalCountryUpdateDTO.getLongitude());
		fingalCountryPlayAreaRepository.save(fingalCountryPlayArea);
	}

	@Override
	public void updateDunLaoghaire(DunLaoghaireUpdateDTO dunLaoghaireUpdateDTO) {
		Optional<DunLaoghaire> byId = dunLaoghaireRepository.findById(dunLaoghaireUpdateDTO.getId());
		DunLaoghaire dunLaoghaire = byId.get();
		dunLaoghaire.setName(dunLaoghaireUpdateDTO.getName());
		dunLaoghaire.setOpeningHours(dunLaoghaireUpdateDTO.getOpeningHours());
		dunLaoghaire.setFacilities(dunLaoghaireUpdateDTO.getFacilities());
		dunLaoghaire.setAddress(dunLaoghaireUpdateDTO.getAddress());
		dunLaoghaireRepository.save(dunLaoghaire);
	}

	@Override
	public void deleteDublinCityParkDetails(long id) {
		dublinCityPlayAreaRepository.deleteById(id);
	}

	@Override
	public void deleteFingalCountryCouncilDetails(long id) {
		fingalCountryPlayAreaRepository.deleteById(id);
	}

	@Override
	public void deleteDunLaoghaireDetails(long id) {
		dunLaoghaireRepository.deleteById(id);
	}
}
