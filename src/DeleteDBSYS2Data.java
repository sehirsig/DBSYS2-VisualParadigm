/**
 * Licensee: Sebastian(HTWG Konstanz)
 * License Type: Academic
 */
import org.orm.*;
public class DeleteDBSYS2Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = DBSYS2PersistentManager.instance().getSession().beginTransaction();
		try {
			Vorlesung vorlesung = Vorlesung.loadVorlesungByQuery(null, null);
			vorlesung.delete();
			Studiengang studiengang = Studiengang.loadStudiengangByQuery(null, null);
			studiengang.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteDBSYS2Data deleteDBSYS2Data = new DeleteDBSYS2Data();
			try {
				deleteDBSYS2Data.deleteTestData();
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
