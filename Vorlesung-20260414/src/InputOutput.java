import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class InputOutput {
    public static void schreibenAufKonsole() { //Ausgabe auf Konsole
        PrintWriter writer = new PrintWriter(System.out, true); //Printwriter zeigt auf die Konsole mit System.out
        schreiben(writer);
    }

    public static void lesenVonKonsoleMitSystemIn() { //Konsoleneingabe mit Sytem.in
        try {
            int i = System.in.read(); //Gibt ASCII-Wert zurück
            System.out.println("Gelesenes Zeichen: " + (char) i); //Wird dann in char umgewandelt
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lesenVonKonsoleMitScanner() { //Konsoleneingabe mit Scanner
        Scanner scanner = new Scanner(System.in); //Scanner ist komfortabler
        System.out.print("Geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine(); //Liest ganze Zeile ein
        System.out.println("Hallo, " + name + "!");
        scanner.close();
    }

    public static void lesenAusDatei() { //Datei lesen mit BufferedReader & GUI
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Test.txt")); //öffnet die Datei Test.txt mit einem BufferedReader und einem FileReader
            String line = "";
            while (line != null) {
                line = reader.readLine(); //Liest die erste Zeile
                if (line != null) {
                    System.out.println(line); //Gibt sie aus
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int zahlLesenVonKonsole() { //Konsoleneingabe
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Geben Sie eine Zahl ein: ");
            try {
                String s = reader.readLine();
                int i = Integer.parseInt(s);
                validInput = true;
                return i;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahl eingegeben.");
            }
        }
        return 0; //Schleife endet immer mit return i, return 0 existiert nur für den Compiler
    }

    public static void lesenVonKonsoleMitBufferedReader() { //Konsoleneingabe
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader); //nutzt einen BufferedReader, der um einen InputStreamReader gewickelt ist, effizienter bei größeren Datenmengen
        System.out.print("Geben Sie Ihren Namen ein: ");
        try {
            String name = reader.readLine(); //reader.readLine() liest ebenfalls eine ganze Zeile
            System.out.println("Hallo, " + name + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lesenMitGui() { //GUI
        String s = JOptionPane.showInputDialog("Bitte Zahl eingeben"); //Zeigt Popup-Fester
        int i = Integer.parseInt(s);
        System.out.println("Ergebnis i*i: " + i * i);
    }

    public static void inDateiSchreiben() { //Ausgabe
        PrintWriter writer;
        try {
            writer = new PrintWriter("Test.txt"); //Erstellt Printwriter der direkt auf die Dateil Text.text zeigt
            schreiben(writer);
        } catch (FileNotFoundException e) { //Wenn die Datein nicht gefunden wird, wird eine Exception abgefangen
            e.printStackTrace(); //e ist das Objekt der Exception die die Informationen hält und dann auf der konsole ausgibt
        }
    }

    private static void schreiben(PrintWriter writer) { //ist die eigentliche Methode die chreibt und wird von den anderen beiden aufgerufen
        writer.println("Hello, World! \nWas für ein schöner Tag!"); //println() einen Text 
        writer.printf("The value of pi is approximately %.2f%n", Math.PI); //Mit printf() einen formatierten Wert für PI
        writer.close();
    }

}
