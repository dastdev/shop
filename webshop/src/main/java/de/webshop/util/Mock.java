//package de.webshop.util;
//
////import java.lang.invoke.MethodHandles;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import de.webshop.artikelverwaltung.domain.Artikel;
//import de.webshop.artikelverwaltung.domain.Artikel.Kategorie;
//import de.webshop.bestellverwaltung.domain.Bestellung;
//import de.webshop.bestellverwaltung.domain.Position;
//import de.webshop.kundenverwaltung.domain.Adresse;
//import de.webshop.kundenverwaltung.domain.Adresse.Land;
//import de.webshop.kundenverwaltung.domain.Kunde;
//import de.webshop.kundenverwaltung.domain.Kundentyp;
//
////import org.jboss.logging.Logger;
//
//public final class Mock {
//	
//	// private static final Logger logger =
//	
//	private static final int MAX_ID = 99;
//	private static final int MAX_KUNDEN = 8;
//	private static final int MAX_BESTELLUNGEN = 4;
//	
//	public static Position findPositionById(Long id) {
//		if (id > MAX_ID) {
//			return null;
//		}
//		
//		final Position position = new Position();
//		position.setAnzahl(new Integer(2));
//		
//		position.setArtikel(Mock.findArtikelById(id));
//		position.setID(id);
//		
//		return position;
//	}
//	
//	public static Artikel findArtikelById(Long id) {
//		final Artikel artikel = new Artikel();
//		artikel.setID(id);
//		artikel.setArtikelnummer("R2D2uC3PO");
//		artikel.setBezeichnung("Robobike");
//		artikel.setKurzBeschreibung("Das Robobike weiss wohin ...");
//		artikel.setBeschreibung("Lange Robobikebeschreibu...........");
//		artikel.setKategorie(Kategorie.KOMPLETTRAEDER);
//		final Integer tempLaBe = new Integer(13);
//		artikel.setLagerbestand(tempLaBe);
//		final BigDecimal tempPreis = new BigDecimal(1300.50);
//		artikel.setPreis(tempPreis);
//		
//		return artikel;
//	}
//
//	public static List<Position> findPositionenByBestellung(Bestellung bestellung) {
//		final List<Position> positionen = bestellung.getPositionen();
//		return positionen;
//	}
//	
//	public static Kunde findKundeById(Long id) {
//		if (id > MAX_ID) {
//			return null;
//		}
//		
//		final Kunde kunde = new Kunde();
//		kunde.setID(id);
//		kunde.setName("Nachname" + id);
//		kunde.setEmail("" + id + "@hska.de");
//		
//		final Adresse adresse = new Adresse();
//		
//		if (id % 2 == 0) {
//			adresse.setHausnummer("L4D");
//			adresse.setID(id + 1);
//			adresse.setLand(Land.DE);
//			adresse.setPlz("76133");
//			adresse.setStadt("Megashophausen");
//			adresse.setStrasse("Bikestrasse");
//			adresse.setKunde(kunde);
//		}
//		else {
//			adresse.setHausnummer("B2B");
//			adresse.setID(id + 1);
//			adresse.setLand(Land.AT);
//			adresse.setPlz("1885");
//			adresse.setStadt("Weizen");
//			adresse.setStrasse("Naturtruebweg");
//			adresse.setKunde(kunde);
//		}
//		kunde.setAdresse(adresse);
//		
//		return kunde;
//	}
//	
//	public static List<Kunde> findAllKunden() {
//		final int anzahl = MAX_KUNDEN;
//		final List<Kunde> kunden = new ArrayList<>(anzahl);
//		for (int i = 1; i <= anzahl; i++) {
//			final Kunde kunde = findKundeById(Long.valueOf(i));
//			kunden.add(kunde);
//		}
//		return kunden;
//	}
//	
//	public static List<Kunde> findKundenByNachname(String nachname) {
//		final int anzahl = nachname.length();
//		final List<Kunde> kunden = new ArrayList<>(anzahl);
//		for (int i = 1; i <= anzahl; i++) {
//			final Kunde kunde = findKundeById(Long.valueOf(i));
//			kunde.setName(nachname);
//			kunden.add(kunde);
//		}
//		return kunden;
//	}
//	
//	public static Kunde findKundeByEmail(String email) {
//		if (email.startsWith("x")) {
//			return null;
//		}
//		
//		final Kunde kunde = new Kunde();
//		kunde.setID(Long.valueOf(email.length()));
//		kunde.setName("Nachname");
//		kunde.setVorname("Vorname");
//		kunde.setEmail(email);
//		kunde.setTyp(Kundentyp.PRIVATKUNDE);
//		// final GregorianCalendar seitCal = new GregorianCalendar(JAHR, MONAT,
//		// TAG);
//		// final Date seit = seitCal.getTime();
//		// kunde.setSeit(seit);
//		
//		final Adresse adresse = new Adresse();
//		adresse.setID(kunde.getID() + 1); // andere ID fuer die Adresse
//		adresse.setPlz("12345");
//		adresse.setStadt("Testort");
//		adresse.setKunde(kunde);
//		kunde.setAdresse(adresse);
//		
//		return kunde;
//	}
//	
//	public static Bestellung createBestellung(Bestellung bestellung, long kundeId) {
//		System.out.printf("Neue Bestellung: %s fuer Kunde: %d\n", bestellung, kundeId);
//		return bestellung;
//	}
//	
//	public static List<Bestellung> findBestellungenByKunde(Kunde kunde) {
//		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
//		final int anzahl = kunde.getID().intValue() % MAX_BESTELLUNGEN + 1;
//		// 1 2 3 oder 4 Bestellungen
//		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
//		for (int i = 1; i <= anzahl; i++) {
//			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
//			bestellung.setKunde(kunde);
//			bestellungen.add(bestellung);
//		}
//		
//		return bestellungen;
//	}
//	
//	public static Bestellung findBestellungById(Long id) {
//		if (id > MAX_ID) {
//			return null;
//		}
//		
//		final Kunde kunde = findKundeById(id + 1); // andere ID fuer den
//													// Kunden
//		
//		final Bestellung bestellung = new Bestellung();
//		bestellung.setID(id);
//		bestellung.setKunde(kunde);
//		final Date tempBestDatum = new Date(1234567890);
//		bestellung.setBestelldatum(tempBestDatum);
//	
//		final List<Position> positionen = new ArrayList<Position>();
//		positionen.add(findPositionById(1L));
//		positionen.add(findPositionById(2L));
//		bestellung.setPositionen(positionen);
//		
//		return bestellung;
//	}
//	
//	public static Kunde createKunde(Kunde kunde) {
//		// Neue IDs fuer Kunde und zugehoerige Adresse
//		// Ein neuer Kunde hat auch keine Bestellungen
//		final String nachname = kunde.getName();
//		kunde.setID(Long.valueOf(nachname.length() ^ kunde.hashCode()));
//		
//		
//		final Adresse adresse = kunde.getAdresse();
//		adresse.setID((Long.valueOf(nachname.length())) + 1);
//		adresse.setKunde(kunde);
//		
//		System.out.printf("Neuer Kunde: %s" , kunde);
//		return kunde;
//	}
//	
//	public static void updateKunde(Kunde kunde) {
//		System.out.printf("Aktualisierter Kunde: %s" , kunde);
//	}
//	
//	public static void deleteKunde(Long kundeId) {
//		System.out.println("Delete Kunde");
//	}
//	
//	public static Position createPosition(Position position, Bestellung bestellung) {
//		if (position == null) {
//			position = new Position();
//			System.out.println("uebergebene Position ungueltig");
//		}
//		else {
//			System.out.println(String.format("Create Position %d", position.getID()));
//		}
//		
//		final Long tempId = new Long(12);
//		position.setID(tempId);
//		return position;
//	}
//	
//	public static void updatePosition(Position position) {
//		// gespeicherte Position finden
//		// gesp. Position mir Werten aus Parameter ueberschreiben
//		
//		if (position == null) {
//			System.out.println("Update fehlgeschlagen");
//		}
//		else {
//			System.out.println(String.format("Update position %d", position.getID()));
//		}
//	}
//	
//	public static void deletePosition(long positionId) {
//		System.out.println(String.format("Delete Position %d", positionId));
//	}
//	
//	private Mock() { /**/
//	}
//	
//	public static Artikel updateArtikel(Artikel artikel) {
//		if (artikel == null) {
//			System.out.println("Update fehlgeschlagen");
//			
//			artikel = new Artikel();
//		}
//		else {
//			System.out.println(String.format("Update artikel %d", artikel.getID()));
//		}
//		
//		return artikel;
//	}
//	
//	public static Artikel createArtikel(Artikel artikel) {
//		if (artikel == null) {
//			System.out.println("Create fehlgeschlagen");
//			
//			artikel = new Artikel();
//		}
//		else {
//			System.out.println("Create artikel");
//		}
//		
//		final Long tempId = new Long(13);
//		artikel.setID(tempId);
//		
//		return artikel;
//	}
//	
//}
