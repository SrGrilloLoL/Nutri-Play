package com.example.inicio.api;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

public class JWTUtils {

    public static String[] decoded(String JWTEncoded) throws Exception {
        String body = "";
        String[] data;

        try {
            String[] split = JWTEncoded.split("\\.");
            body = getJson(split[1]);
            body = body.substring(1, body.length()-1);
            data = body.split(",");
            return data;
//            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
//            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
        } catch (UnsupportedEncodingException e) {
            //Error
            throw e;
        }
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException{
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }

}
