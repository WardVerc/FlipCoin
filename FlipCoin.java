import java.text.DecimalFormat; //zorgt ervoor dat ik doubles kan afronden tot op 2 decimalen ipv 10 ofzo
import java.util.Scanner;

public class FlipCoin {
	
			/* Lessons learned with this project:
			- een method begin je blijkbaar met "public static" gevolgd door het datatype
			- een method maak je blijkbaar buiten de main-method? 
			- een method dat niet "void" is moet blijkbaar altijd iets returnen, zonder "return *iets*" gaat hij niet compilen
			- let op hoofdlettergevoeligheid, het is "for", niet "For" voor die loop
			- variabelen die je in een method definieert bestaan enkel in die method, nergens anders in de code kan je die variabelen gebruiken
			definieer je variabelen dus ergens anders (in de main?)
			- als je een berekening maakt met kommagetal (double), zorg dan dat je je variabelen waarmee je de berekening maakt, ook doubles zijn en geen ints :) 
			in dit project heb ik dit opgelost door voor de berekening (maar wel na de loop) nieuwe variabelen (doubes) te creeren en die gelijkstellen aan de ints waarmee ik de
			berekening wil doen
			- 
			*/
			
		
	public static void main (String[] args) {
		
		//Kop of munt definieren
		String[] kopOfMunt = {"kop", "munt"};
		
		//Wat het resultaat van de flip gaat zijn (random)
		//Definieer eerst uw range
		int aantalMogelijkheden = kopOfMunt.length;
		
		//Vragen aan de gebruiker hoeveel we moeten tossen
		System.out.println("Yo fam, zeg keer, hoeveel keer moek smijten? (1-15000)\n");
		Scanner sc = new Scanner(System.in);
		//Dit getal gaan we in een variabele steken
		int aantalFlips = sc.nextInt(); //indien je een string zil gebruiken, vervang nextInt() door nextLine(). En verander het datatype naar string natuurlijk 
		
		//Variabelen dat aantal munt en aantal kop vasthoud 
		int aantalKop = 0;
		int aantalMunt = 0;
		
		//Flip de coin *aantalFlips* keer		
		//Maak een for-loop dat *aantalFlips* keer itereert (herhaalt), dan wordt het resultaat in totaal *aantalFlips* keer geprint
		for (int i = 0; i < aantalFlips; i++) {

			//Uw range van mogelijke resultaten maal iets random tussen 0 en 1
			//Dit kiest een positie van uw array, deze positie noemen we nu "kopOfMuntResultaat"
			int kopOfMuntResultaat = (int) (Math.random() * aantalMogelijkheden);
		
			//Dit is de variabele die het woord gaat vasthouden dat op deze random positie van deze array zit
			String resultaat = kopOfMunt[kopOfMuntResultaat];
			
			//Print het resultaat van elke flip, enkel indien het lager dan 100 flips zijn
			if (aantalFlips < 100) {
				
				System.out.println(resultaat);
			} else {
				//doe niks, aleja ga verder met de code, dit is een lege statement
				;
			} 
			
			//De teller van aantal kop moet eentje naar omhoog indien het kop was (zelfde voor munt)
			if (kopOfMuntResultaat == 0) {
				aantalKop++;
			} else {
				aantalMunt++;
			} 
		}
		
		//Hier print je het *aantalFlips*
		//Hier print je het aantal keer dat het kop was en het aantal keer dat het munt was
		System.out.println("\nAight cava, kzal " + aantalFlips + " keer smijten voor u. \nKheb speciaal voor u exact, ma EXACT " + aantalFlips + " keer gesmeten.\nHet was " +  aantalKop + " keer kop en het was " + aantalMunt + " keer munt. \nZOT HE!!\n");
		
		//Variabelen om de percentages van het resultaat te bewaren. Aangezien het percentage een kommagetal is gaan we eerst de ints in een double steken voor de berekening
		double doubleAantalFlips = aantalFlips;
		double doubleAantalKop = aantalKop;
		double doubleAantalMunt = aantalMunt;
		double percentKop = (doubleAantalKop / doubleAantalFlips) * 100;
		double percentMunt = (doubleAantalMunt / doubleAantalFlips) * 100;
		
		//Hier rond ik de doubles af tot op 2 decimalen (gevonden op stackoverflow)
		DecimalFormat df = new DecimalFormat("#.##");      
		percentKop = Double.valueOf(df.format(percentKop));
		percentMunt = Double.valueOf(df.format(percentMunt));
		
		//Print het percentage van het aantal keer kop en aantal keer munt. Gebruik een nieuwe regel voor percentage van munt.
		System.out.println("In procenten betekent dit dat het " + percentKop + "% kop was. \nEn het was " + percentMunt + "% munt.");
		
		
	}
}