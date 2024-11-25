/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xprod.xproddesktop.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author william NYACKA
 */
public class DataEncryption {

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        //la classe StringBufffer en java est identique à la classe string, sauf qu'elle peut être modifiée.

        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
//L'opérateur >>> est l'opérateur de décalage de bits vers la droite non-signé en java. Il divise effectivement l'opérande par 4 à la puissance de l'opérande de droite, ici c'est 4.

            int two_halfs = 0;

            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + halfbyte - 10));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String getSHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md; //La classe messageDigest() va fournir au application la fonctionalité d'un algorithme de résumé de message, tel que SHA-1 ou le SHA-256.

        md = MessageDigest.getInstance("SHA-1"); //je prend un algorithme

        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());

        sha1hash = md.digest(); //termine le calcul de hashage en effectuant les opérations finales tel que le remplissage. Le résumé est réinitialisé après cet appel.
        return convertToHex(sha1hash);
    }
}
