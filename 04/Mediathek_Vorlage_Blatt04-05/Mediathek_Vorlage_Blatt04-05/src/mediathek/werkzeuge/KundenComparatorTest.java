package mediathek.werkzeuge;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import mediathek.fachwerte.Kundennummer;
import mediathek.materialien.Kunde;

import org.junit.Before;
import org.junit.Test;

/**
 * Testklasse für den KundenComparator
 * 
 * @author SE2-Team
 * 
 */
public class KundenComparatorTest
{
    private KundenComparator _comparator;
    private Kunde _kunde1;
    private Kunde _kunde2;
    private Kunde _kunde3;

    @Before
    public void setUp()
    {
        _kunde1 = new Kunde(new Kundennummer(111111), "Hans", "Meier");
        _kunde2 = new Kunde(new Kundennummer(543453), "Heidi", "Klum");
        _kunde3 = new Kunde(new Kundennummer(432343), "Lara", "Klum");
        _comparator = new KundenComparator();
    }

    @Test
    public void testCompare()
    {
        assertTrue(_comparator.compare(_kunde1, _kunde2) > 0);
        assertTrue(_comparator.compare(_kunde2, _kunde1) < 0);
        assertEquals(0, _comparator.compare(_kunde2, _kunde3));
    }

}
