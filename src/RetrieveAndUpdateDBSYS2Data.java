/**
 * Licensee: Sebastian(HTWG Konstanz)
 * License Type: Academic
 */
import org.orm.*;
public class RetrieveAndUpdateDBSYS2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = DBSYS2PersistentManager.instance().getSession().beginTransaction();
		try {
			Vorlesung vorlesung = Vorlesung.loadVorlesungByQuery(null, null);
			// Update the properties of the persistent object
			vorlesung.save();
			Studiengang studiengang = Studiengang.loadStudiengangByQuery(null, null);
			// Update the properties of the persistent object
			studiengang.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateDBSYS2Data retrieveAndUpdateDBSYS2Data = new RetrieveAndUpdateDBSYS2Data();
			try {
				retrieveAndUpdateDBSYS2Data.retrieveAndUpdateTestData();
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
