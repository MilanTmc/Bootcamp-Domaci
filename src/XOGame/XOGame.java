package XOGame;

import java.util.Scanner;

public class XOGame {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String var1 = "";
            String var2 = "";
            int brojac = 0;

            String[] polja = new String[9];

            //Korisnik odabira X ili O.
            while (true) {
                System.out.println("Unesite X ili O: ");
                var1 = scan.nextLine();
                var1 = var1.toUpperCase();
                if (var1.equals("X") || var1.equals("O"))
                    break;
                else System.out.println("Neispravan unos.");
            }

            if (var1.equals("X"))
                var2 = "O";
            else
                var2 = "X";

            //Korisnik igra.
            while (true) {
                System.out.println("Unesite broj pozicije od 1 do 9: ");
                int potezKorisnika = scan.nextInt();
                if (potezKorisnika < 1 || potezKorisnika > 9) {
                    System.out.println("Unesena vrednost mora biti od 1 do 9.");
                    continue;
                } else if (polja[potezKorisnika - 1] != null) {
                    System.out.println("Ova pozicija je zauzeta! Odaberite slobodnu poziciju.");
                    continue;
                } else if (polja[potezKorisnika - 1] == null) {
                    polja[potezKorisnika - 1] = var1;
                    brojac++;
                }

                if (brojac == polja.length) {
                    System.out.println("Igra je zavrsena!");
                    break;

                }

                //Racunar igra.
                while (true) {
                    int potezRacunara = (int) (Math.random() * 9);
                    if (polja[potezRacunara] == null) {
                        polja[potezRacunara] = var2;
                        brojac++;
                        break;
                    }
                }

                //Ispisivanje tabele.

                for (int i = 0; i < polja.length; i++) {
                    System.out.print(polja[i] + " ");
                    if ((i + 1) % 3 == 0)
                        System.out.println();
                }

                System.out.println();

            }
        }
    }
