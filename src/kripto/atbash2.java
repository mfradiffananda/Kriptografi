/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.util.Scanner;

/**
 *
 * @author Radif
 */
public class atbash2 {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.print("1. enkrip\n2. dekrip\nchoose(1,2): ");
        int choice = in.nextInt();
        in.nextLine();

        if (choice == 1) {
            System.out.println("--enkrip--");
            chiperEncryption();
        } else if (choice == 2) {
            System.out.println("--dekrip--");
            chiperDecryption();
        } else {
            System.out.println("salah");
        }
    }

    private static void chiperEncryption() {
        String alpa = "abcdefghijklmnopqrstuvwxyz";
        String reverseAlpa = "";

        //reversing alphabets atbash
        for (int i = alpa.length() - 1; i > -1; i--) {
            reverseAlpa += alpa.charAt(i);
        }
        System.out.println("masukan pesan : ");
        String message = in.nextLine();
        in.nextLine();

        message = message.toUpperCase();

        String encryText = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == (char) 32) {
                encryText += " ";
            } else {
                int count = 0;
                for (int j = 0; j < alpa.length(); j++) {
                    if (message.charAt(i) == alpa.charAt(j)) {
                        encryText += reverseAlpa.charAt(j);
                        break;
                    }
                }
            }
        }
        System.out.println("enkripsi : " + encryText);
    }

    private static void chiperDecryption() {

        String alpa = "abcdefghijklmnopqrstuvwxyz";
        String reverseAlpa = "";

        //reversing alphabets atbash
        for (int i = alpa.length() - 1; i > -1; i--) {
            reverseAlpa += alpa.charAt(i);
        }
        System.out.println("masukan pesan enkripsi : ");
        String message = in.nextLine();
        in.nextLine();

        message = message.toUpperCase();

        String dencryText = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == (char) 32) {
                dencryText += " ";
            } else {
                int count = 0;
                for (int j = 0; j < reverseAlpa.length(); j++) {
                    if (message.charAt(i) == reverseAlpa.charAt(j)) {
                        dencryText += alpa.charAt(j);
                        break;
                    }
                }
            }
        }
        System.out.println("dekripsi : " + dencryText);
    }
}
