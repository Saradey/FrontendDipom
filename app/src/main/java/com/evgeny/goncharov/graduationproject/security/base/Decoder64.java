package com.evgeny.goncharov.graduationproject.security.base;

/**
 * Created by Evgeny Goncharov on 2019-05-23.
 * jtgn@yandex.ru
 */

//декодирование
public class Decoder64 {

    private int FromBase64Char(int c)
    {
        if(c >= 'A' && c <= 'Z')
            return c - 'A';
        else if(c >= 'a' && c <= 'z')
            return c - 'a' + 26;
        else if(c >= '0' && c <= '9')
            return c - '0' + 52;
        else if(c == '+')
            return 62;
        else if(c == '/')
            return 63;
        else
            throw new IllegalArgumentException(); //Depends on how do you want to handle invalid characters
    }


    public byte[] FromBase64(String s) throws IllegalArgumentException
    {
        if(s == null)
            return null;

        int l = s.length();
        if(l == 0)
            return new byte[0];

        if(l % 4 != 0)
            throw new IllegalArgumentException();

        boolean Padded = (s.charAt(l-1) == '=');
        boolean Padded2 = (s.charAt(l-2) == '=');
        int ll = (Padded ? l-4 : l);
        int triad;

        byte [] b = new byte[(ll*3)/4 + (Padded ? (Padded2 ? 1 : 2) : 0)];

        int i, j = 0;
        for(i=0; i<ll; i+=4)
        {
            triad =
                    (FromBase64Char(s.charAt(i)) << 18) |
                            (FromBase64Char(s.charAt(i+1)) << 12) |
                            (FromBase64Char(s.charAt(i+2)) << 6) |
                            FromBase64Char(s.charAt(i+3));

            b[j++] = (byte)((triad >> 16) & 0xff);
            b[j++] = (byte)((triad >> 8) & 0xff);
            b[j++] = (byte)(triad & 0xff);
        }
        //The final chunk
        if(Padded)
        {
            if(Padded2) //Padded with two ='s
            {
                triad = (FromBase64Char(s.charAt(ll)) <<2 ) | (FromBase64Char(s.charAt(ll+1)) >> 4);
                b[j++] = (byte)triad;
            }
            else //Padded with one =
            {
                triad =
                        (FromBase64Char(s.charAt(ll)) << 10) |
                                (FromBase64Char(s.charAt(ll+1)) << 4) |
                                (FromBase64Char(s.charAt(ll+2)) >> 2);
                b[j++] = (byte)((triad >> 8) & 0xff);
                b[j++] = (byte)(triad & 0xff);
            }
        }
        return b;
    }

}
