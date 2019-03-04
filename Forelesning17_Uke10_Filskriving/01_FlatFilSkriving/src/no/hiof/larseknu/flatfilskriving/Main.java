package no.hiof.larseknu.flatfilskriving;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // Filstien til filen vi ønsker å skrive til
        String filsti = "novelle.txt";
        // Ett string-objekt til å holde på linjene som blir lest (for så å skrive dem)
        String lestTekst = "";

        System.out.println("Skriv tekst ('avslutt' for å avslutte)");

        // Oppretter og instansierer en BufferedReader (slik at vi får bufret lesingen og kan lese en linje av gangen)
        // får info fra InputStreamReader, leser fra InputStream'en som kommer fra System (altså konsollen vår)
        // Oppretter og instansierer også en FileWriter, som vi benytter til å skrive til fil
        // Disse opprettes i "try", som blir kalt "try-with-resources". Dette gjør at de blir lukket til slutt,
        // uavhengig av om det skjer en feil eller ikke.
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                FileWriter filSkriver = new FileWriter(filsti, true);
        ) {
            // Kjør løkken så lenge "avslutt" ikke er skrevet
            while(!lestTekst.equals("avslutt")) {
                // Printer et kolon til konsollen (legg merke til print, fremfor println)
                System.out.print(": ");
                // Leser ut teksten som har blitt skrevet og legger de i "lestTekst"
                lestTekst = bufferedReader.readLine();
                // Skriver linjen til fil (med linjeskift)
                filSkriver.write(lestTekst + "\r\n");
            }
        } catch (IOException ioexc) {
            System.err.println(ioexc.getMessage());
        }
    }
}
