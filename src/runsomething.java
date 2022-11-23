import org.orm.PersistentException;

public class runsomething {
    private static final int ROW_COUNT = 100;

    public static void main(String[] args) throws PersistentException {
        try {
            try {
                //aufgabenteilD();
                //aufgabenteilE(); //Muss 32 - 32 rauskommen
                aufgabenteilF();
            }
            finally {
                DBSYS2PersistentManager.instance().disposePersistentManager();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aufgabenteilD() throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery(null, null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(vorlesungs[i].getName() + "|" + vorlesungs[i].getEcts() + "|" + vorlesungs[i].getStudiengang());
        }
    }

    public static void aufgabenteilE() throws PersistentException {
        Studiengang[] studiengangs = Studiengang.listStudiengangByQuery(null, null);
        int length = Math.min(studiengangs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            int sum = getECTSSum(studiengangs[i].getKuerzel());
            System.out.println(studiengangs[i].getName() + " | Summe: " + sum);
        }
    }

    public static int getECTSSum(String Studiengang) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'" + Studiengang + "\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        int ectssum = 0;
        for (int i = 0; i < length; i++) {
            ectssum += vorlesungs[i].getEcts();
        }
        return ectssum;
    }

    public static void aufgabenteilF() throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'AIN\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        printSameStudiengang(vorlesungs);
    }

    public static void printSameStudiengang(Vorlesung[] VorlesungsListe) throws PersistentException {
        Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery("StudiengangKuerzel = \'WIN\'", null);
        int length = Math.min(vorlesungs.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            for (var vorlesung : VorlesungsListe) {
                if (vorlesung.getName().equals(vorlesungs[i].getName())) {
                    System.out.println(vorlesung.getName());
                }
            }
        }
    }

}
