package com.evgeny.goncharov.graduationproject.security.base;

/**
 * Created by Evgeny Goncharov on 2019-05-23.
 * jtgn@yandex.ru
 */

//кодировщик
public class Encoder64 {

    private final static String BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
            PAD1 = "=", PAD2 = "==";

    public String ToBase64(String namepass)
    {
        final byte [] a = namepass.getBytes();
        int l = a.length;
        StringBuilder sb = new StringBuilder((l+3)*4/3);
        int i;
        int mod = l % 3;
        int ll = l - mod;
        int triad;
        for(i=0;i<ll;i+=3)
        {
            triad = (a[i]<<16) | (a[i+1]<<8) | a[i+2];
            sb.append(BASE64_ALPHABET.charAt((triad >> 18) & 0x3f));
            sb.append(BASE64_ALPHABET.charAt((triad >> 12) & 0x3f));
            sb.append(BASE64_ALPHABET.charAt((triad >> 6) & 0x3f));
            sb.append(BASE64_ALPHABET.charAt(triad & 0x3f));
        }
        if(mod == 1)
        {
            sb.append(BASE64_ALPHABET.charAt((a[i] >> 2) & 0x3f));
            sb.append(BASE64_ALPHABET.charAt((a[i] << 4) & 0x3f));
            sb.append(PAD2);
        }
        if(mod == 2)
        {
            triad = (a[i]<<8) | a[i+1];
            sb.append(BASE64_ALPHABET.charAt((triad >> 10) & 0x3ff));
            sb.append(BASE64_ALPHABET.charAt((triad >> 4) & 0x3f));
            sb.append(BASE64_ALPHABET.charAt((triad << 2) & 0x3f));
            sb.append(PAD1);
        }
        return sb.toString();
    }



}
