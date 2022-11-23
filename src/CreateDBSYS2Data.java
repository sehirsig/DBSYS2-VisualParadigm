/**
 * Licensee: Sebastian(HTWG Konstanz)
 * License Type: Academic
 */
import org.orm.*;
public class CreateDBSYS2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = DBSYS2PersistentManager.instance().getSession().beginTransaction();
		try {
			Studiengang studiengangWIN = Studiengang.createStudiengang();
			studiengangWIN.setName("Wirtschaftsinformatik");
			studiengangWIN.setKuerzel("WIN");
			studiengangWIN.setAbschluss("Bachelor");
			studiengangWIN.save();

			Studiengang studiengangAIN = Studiengang.createStudiengang();
			studiengangAIN.setName("Angewandte Informatik");
			studiengangAIN.setKuerzel("AIN");
			studiengangAIN.setAbschluss("Bachelor");
			studiengangAIN.save();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : vorlesung, kuerzel

			Vorlesung vorlesungAINRechnernetze = Vorlesung.createVorlesung();
			vorlesungAINRechnernetze.setName("Rechnernetze");
			vorlesungAINRechnernetze.setEcts(6);
			vorlesungAINRechnernetze.setSws(4);
			vorlesungAINRechnernetze.setStudiengang(studiengangAIN);
			vorlesungAINRechnernetze.save();

			Vorlesung vorlesungAINDigitaltechnik = Vorlesung.createVorlesung();
			vorlesungAINDigitaltechnik.setName("Digitaltechnik");
			vorlesungAINDigitaltechnik.setEcts(8);
			vorlesungAINDigitaltechnik.setSws(6);
			vorlesungAINDigitaltechnik.setStudiengang(studiengangAIN);
			vorlesungAINDigitaltechnik.save();

			Vorlesung vorlesungAINBetriebssysteme = Vorlesung.createVorlesung();
			vorlesungAINBetriebssysteme.setName("Betriebssysteme");
			vorlesungAINBetriebssysteme.setEcts(6);
			vorlesungAINBetriebssysteme.setSws(4);
			vorlesungAINBetriebssysteme.setStudiengang(studiengangAIN);
			vorlesungAINBetriebssysteme.save();

			Vorlesung vorlesungAINSoftwaremodellierung = Vorlesung.createVorlesung();
			vorlesungAINSoftwaremodellierung.setName("Softwaremodellierung");
			vorlesungAINSoftwaremodellierung.setEcts(6);
			vorlesungAINSoftwaremodellierung.setSws(5);
			vorlesungAINSoftwaremodellierung.setStudiengang(studiengangAIN);
			vorlesungAINSoftwaremodellierung.save();

			Vorlesung vorlesungAINRechnerarchitekturen = Vorlesung.createVorlesung();
			vorlesungAINRechnerarchitekturen.setName("Rechnerarchitekturen");
			vorlesungAINRechnerarchitekturen.setEcts(6);
			vorlesungAINRechnerarchitekturen.setSws(5);
			vorlesungAINRechnerarchitekturen.setStudiengang(studiengangAIN);
			vorlesungAINRechnerarchitekturen.save();


			Vorlesung vorlesungWINRechnungswesen = Vorlesung.createVorlesung();
			vorlesungWINRechnungswesen.setName("Rechnungswesen");
			vorlesungWINRechnungswesen.setEcts(8);
			vorlesungWINRechnungswesen.setSws(6);
			vorlesungWINRechnungswesen.setStudiengang(studiengangWIN);
			vorlesungWINRechnungswesen.save();

			Vorlesung vorlesungWINBetriebswirtschaftslehre = Vorlesung.createVorlesung();
			vorlesungWINBetriebswirtschaftslehre.setName("Betriebswirtschaftslehre");
			vorlesungWINBetriebswirtschaftslehre.setEcts(7);
			vorlesungWINBetriebswirtschaftslehre.setSws(5);
			vorlesungWINBetriebswirtschaftslehre.setStudiengang(studiengangWIN);
			vorlesungWINBetriebswirtschaftslehre.save();

			Vorlesung vorlesungWINSoftwaretechnik1 = Vorlesung.createVorlesung();
			vorlesungWINSoftwaretechnik1.setName("Softwaretechnik 1");
			vorlesungWINSoftwaretechnik1.setEcts(6);
			vorlesungWINSoftwaretechnik1.setSws(4);
			vorlesungWINSoftwaretechnik1.setStudiengang(studiengangWIN);
			vorlesungWINSoftwaretechnik1.save();

			Vorlesung vorlesungWINSoftwaretechnik2 = Vorlesung.createVorlesung();
			vorlesungWINSoftwaretechnik2.setName("Softwaretechnik 2");
			vorlesungWINSoftwaretechnik2.setEcts(5);
			vorlesungWINSoftwaretechnik2.setSws(4);
			vorlesungWINSoftwaretechnik2.setStudiengang(studiengangWIN);
			vorlesungWINSoftwaretechnik2.save();

			Vorlesung vorlesungWINBetriebssysteme = Vorlesung.createVorlesung();
			vorlesungWINBetriebssysteme.setName("Betriebssysteme");
			vorlesungWINBetriebssysteme.setEcts(6);
			vorlesungWINBetriebssysteme.setSws(4);
			vorlesungWINBetriebssysteme.setStudiengang(studiengangWIN);
			vorlesungWINBetriebssysteme.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateDBSYS2Data createDBSYS2Data = new CreateDBSYS2Data();
			try {
				createDBSYS2Data.createTestData();
			}
			finally {
				DBSYS2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
