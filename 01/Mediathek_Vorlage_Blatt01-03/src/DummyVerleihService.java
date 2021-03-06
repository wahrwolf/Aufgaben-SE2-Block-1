import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse implementiert das Interface VerleihService. Es handelt sich
 * lediglich um eine Dummy-Implementation, um die GUI zu testen.
 * 
 * @author GUI-Team
 * @version SoSe 2015
 */
class DummyVerleihService extends AbstractObservableService implements
        VerleihService
{
    // Generator für Zufallszahlen und zufällige boolsche Werte
    private static final Random RANDOM = new Random();

    // Beispiel-Medium
    private static final CD MEDIUM = new CD("Titel", "Kommentar", "Interpret",
            70);
    //Beispiel-Daten
    private static final Kundennummer KUNDENNUMMER = new Kundennummer(123456);
    private static final Kunde ENTLEIHER = new Kunde(KUNDENNUMMER, "Vorname",
            "Nachname");
    private static final Verleihkarte VERLEIHKARTE = new Verleihkarte(
            ENTLEIHER, MEDIUM, Datum.heute());

    public DummyVerleihService(KundenstammService kundenstamm,
            MedienbestandService medienbestand,
            List<Verleihkarte> initialBestand)
    {
    }

    
    
    /**
     * Gibt eine Liste mit einem Item zurück (siehe MEDIUM)
     * 
     * @param kunde Der Parameter wird ignoriert
     * @return ergebnisListe enthaelt einen Eintrag
     */
    @Override
    public List<Medium> getAusgelieheneMedienFuer(Kunde kunde)
    {
        List<Medium> ergebnisListe = new ArrayList<Medium>();
        ergebnisListe.add(MEDIUM);
        return ergebnisListe;
    }

    
    /**
     * Gibt einen Dummy Kunden zurück
     * @param medium wird ignoriert
     * @return gibt immer VERLEIHER zurück
     */
    @Override
    public Kunde getEntleiherFuer(Medium medium)
    {
        return ENTLEIHER;
    }

    /**
     * Gibt eine Dummy Verleihkarte zurück
     * @param medium wird ignoriert
     * @return gibt immer VERLEIHKARTE zurück 
     */
    @Override
    public Verleihkarte getVerleihkarteFuer(Medium medium)
    {
        return VERLEIHKARTE;
    }

    
    /**
     * Gibt eine Liste mit einem Item zurück
     * @return ergebnisListe mit VERLEIHKARTE
     */
    @Override
    public List<Verleihkarte> getVerleihkarten()
    {
        List<Verleihkarte> ergebnisListe = new ArrayList<Verleihkarte>();
        ergebnisListe.add(VERLEIHKARTE);
        return ergebnisListe;
    }

    
    /**
     * Gibt einen zufälligen Wahrheitswert zurück
     * @param medium wird ignoriert
     * @return zufälliger Wahrheitswert (true, false)
     */
    @Override
    public boolean istVerliehen(Medium medium)
    {
        return RANDOM.nextBoolean();
    }

    
    /**
     * Dummy
     * @param medien wird ignoriert
     * @param rueckgabeDatum wird ignoriert
     */
    @Override
    public void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
    {
    }

    /**
     * 
     * Gibt einen zufälligen Wahrheitswert zurück
     * @param medien wird ignoriert
     * @return zufälliger Wahrheitswert (true, false)
     */
    @Override
    public boolean sindAlleNichtVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * 
     * Gibt einen zufälligen Wahrheitswert zurück
     * @param medien wird ignoriert
     * @return zufälliger Wahrheitswert (true, false)
     */
    @Override
    public boolean sindAlleVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * Dummy
     * @param kunde wird ignoriert
     * @param medien wird ignoriert
     * @param ausleihDatum wird ignoriert
     */
    @Override
    public void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
    {
    }

    /**
     * prüft ob Kunde ENTLEIHER entspricht
     * @param kunde Der zu prüfende Kunde
     * @return gibt true zurück wenn kunde ENTLEIHER ist
     */
    @Override
    public boolean kundeImBestand(Kunde kunde)
    {
        return ENTLEIHER.equals(kunde);
    }


    /**
     * prüft ob medium MEDIUM entspricht
     * @param medium das zu prüfende Medium
     * @return gibt true zurück wenn medium MEDIUM entspricht
     */
    @Override
    public boolean mediumImBestand(Medium medium)
    {
        return MEDIUM.equals(medium);
    }

    /**
     * prüft ob alle Medien in der Liste im Bestand vorhanden sind
     * @param medien die zu überprüfende Liste
     * @return gibt false zurück wenn min ein Medium nicht im Bestand ist
     */
    @Override
    public boolean medienImBestand(List<Medium> medien)
    {
        boolean result = true;
        for (Medium medium : medien)
        {
            if (!mediumImBestand(medium))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * gibt eine Liste mit einem Item zurück
     * @param kunde wird ignoriert
     * @return gibt eine Liste mit VERLEIHKARTE zurück
     */
    @Override
    public List<Verleihkarte> getVerleihkartenFuer(Kunde kunde)
    {
        List<Verleihkarte> result = new ArrayList<Verleihkarte>();
        result.add(VERLEIHKARTE);
        return result;
    }

    /**
     * Dummy
     * @param kunde wird ignoriert
     * @param medien wird ignoriert
     * @return gibt false zurück
     */
    @Override
    public boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien)
    {
        return false;
    }
}
