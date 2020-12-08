package com.dublin.parkapi.service.impl;

import com.dublin.parkapi.model.DublinCityPlayArea;
import com.dublin.parkapi.model.DunLaoghaire;
import com.dublin.parkapi.model.FingalCountryPlayArea;
import com.dublin.parkapi.repository.DublinCityPlayAreaRepository;
import com.dublin.parkapi.repository.DunLaoghaireRepository;
import com.dublin.parkapi.repository.FingalCountryPlayAreaRepository;
import com.dublin.parkapi.service.FetchParkDataService;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchParkDataServiceImpl implements FetchParkDataService {

	@Autowired
	private FingalCountryPlayAreaRepository fingalCountryPlayAreaRepository;

	@Autowired
	private DublinCityPlayAreaRepository dublinCityPlayAreaRepository;

	@Autowired
	private DunLaoghaireRepository dunLaoghaireRepository;

	private static Logger logger = LoggerFactory.getLogger(FetchParkDataServiceImpl.class);

	@Override
	public void getFingalCountryCouncilData() {
		String url = "https://data.smartdublin.ie/dataset/3df0c5e3-05e0-477c-904c-9d6afda732a1/resource/dc447994-05e2-4189-b816-fd532d62dab6/download/fccplayareasp20110901-1706.xml";

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(url);

			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName("Play_Areas");

			List<FingalCountryPlayArea> playAreas = new ArrayList<>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					FingalCountryPlayArea playArea = new FingalCountryPlayArea(element.getElementsByTagName("Name").item(0).getTextContent(),
							element.getElementsByTagName("Address1").item(0).getTextContent(),
							element.getElementsByTagName("Address2").item(0).getTextContent(),
							element.getElementsByTagName("Address3").item(0).getTextContent(),
							element.getElementsByTagName("Address4").item(0).getTextContent(),
							element.getElementsByTagName("Phone").item(0).getTextContent(),
							element.getElementsByTagName("Email").item(0).getTextContent(),
							element.getElementsByTagName("Website").item(0).getTextContent(),
							element.getElementsByTagName("Type").item(0).getTextContent(),
							element.getElementsByTagName("Category").item(0).getTextContent(),
							element.getElementsByTagName("Opening_Hours").item(0).getTextContent(),
							element.getElementsByTagName("Directions").item(0).getTextContent(),
							element.getElementsByTagName("Surface_Type").item(0).getTextContent(),
							element.getElementsByTagName("Comments").item(0).getTextContent(),
							element.getElementsByTagName("Accessible_Play_Items").item(0).getTextContent(),
							element.getElementsByTagName("Disabled_Parking").item(0).getTextContent(),
							element.getElementsByTagName("Park_Ranger").item(0).getTextContent(),
							element.getElementsByTagName("Toilets").item(0).getTextContent(),
							element.getElementsByTagName("Disabled_Toilets").item(0).getTextContent(),
							element.getElementsByTagName("Baby_Changing").item(0).getTextContent(),
							element.getElementsByTagName("Seating").item(0).getTextContent(),
							element.getElementsByTagName("Drinking_Water").item(0).getTextContent(),
							element.getElementsByTagName("LAT").item(0).getTextContent(),
							element.getElementsByTagName("LONG").item(0).getTextContent());
					playAreas.add(playArea);
				}
			}
			fingalCountryPlayAreaRepository.saveAll(playAreas);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void getDublinCityData() {

		String commonUrl = "https://www.dublincity.ie/residential/parks/dublin-city-parks/visit-park/";

		try {
			for(int i=0; i<4; i++){
				List<DublinCityPlayArea> dublinCityPlayAreaList = new ArrayList<>();
				org.jsoup.nodes.Document documentMain = Jsoup.connect("https://www.dublincity.ie/residential/parks/dublin-city-parks" +
						"/visit-park?keys=&amp%3Bfacilities=All&amp%3Bpage=4&facilities=All&page="+i).get();

				Elements elements = documentMain.select(".views-row");
				for(int j=0; j<elements.size(); j++){

					org.jsoup.nodes.Element element = elements.get(j);
					Elements parkName = element.select(".search-result__title");
					String parkNameFormatted = parkName.text().replaceAll(" ","-").replaceAll("/","-").toLowerCase();

					org.jsoup.nodes.Document documentSub = Jsoup.connect(commonUrl + parkNameFormatted).get();

					Elements tableElements = documentSub.select(".opening-times").select("table");
					String openingHours = tableElements.text();

					String phoneNo = documentSub.select(".location__contact-details-phone").text();
					String email = documentSub.select(".location__contact-details-email").select("a").text();

					Elements facilityElements = documentSub.select(".full__facilities").select("ul");
					String facilities = facilityElements.text();

					Elements accessibilityElements = documentSub.select(".field--name-field-accessibility-features");
					String accessibility = accessibilityElements.text();

					org.jsoup.nodes.Element addressElements = documentSub.select("p").select(".address").get(0);
					String addressLineOne = addressElements.select(".address-line1").text();
					String dependentLocality = addressElements.select(".dependent-locality").text();
					String locality = addressElements.select(".locality").text();
					String administrativeArea = addressElements.select(".administrative-area").text();
					String postalCode = addressElements.select(".postal-code").text();
					String country = addressElements.select(".country").text();

					DublinCityPlayArea  dublinCityPlayArea = new DublinCityPlayArea(parkName.text(),openingHours,phoneNo,
							email,facilities,accessibility,addressLineOne,dependentLocality,locality,administrativeArea,postalCode,country);
					dublinCityPlayAreaList.add(dublinCityPlayArea);
				}
				dublinCityPlayAreaRepository.saveAll(dublinCityPlayAreaList);
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void getDunLaoghaireData(){
		/*String marlayParkUrl = "https://www.dlrcoco.ie/en/parks-outdoors/parks/marlay-park";*/

		String commonUrl = "https://www.dlrcoco.ie/en/parks/";
		String parkNames[]  = {"peoples-park","cabinteely-park","blackrock-park","shanganagh-park"};
		try {
			/*org.jsoup.nodes.Document documentMarlayPark = Jsoup.connect(marlayParkUrl).get();
			String marlayParkName = documentMarlayPark.select(".page-header").text();
			Elements p = documentMarlayPark.select(".field-name-field-information-description").select(".field-item").select("p");*/

			for(int i=0;i<4;i++){
				org.jsoup.nodes.Document document = Jsoup.connect(commonUrl+parkNames[i]).get();
				String parkName = document.select(".page-header").text();
				Elements openingHoursElements = document.select(".field-name-field-opening-hours");
				String openingHours = openingHoursElements.select(".field-items").text();
				String address = document.select(".field-name-field-address").select(".field-item").text();
				String facilities = document.select(".views-field-field-facility-details").text();

				DunLaoghaire dunLaoghairePark = new DunLaoghaire(parkName,openingHours,facilities,address);
				dunLaoghaireRepository.save(dunLaoghairePark);
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}
}
