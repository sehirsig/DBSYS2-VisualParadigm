/**
 * Licensee: Sebastian(HTWG Konstanz)
 * License Type: Academic
 */
import org.orm.*;
public class CreateDBSYS2DatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(DBSYS2PersistentManager.instance());
			DBSYS2PersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
