package com.novsu.antonivanov.exampleproject.utils;

import com.novsu.antonivanov.exampleproject.MyObjects.BaseObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Date creation: 31.03.2016.
 */
public class GenerateData {

    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String ALLOWED_CHARACTERS_SPACE = "0 1 2 3 4 5 6 7 8 9 qwerty uiopa sdfgh jklzx cvbnm QWERTY UIOPAS DFGHJK LZXCVBNM";

    public static String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

    public static ArrayList<BaseObject> getListObject(int count) {
        ArrayList<BaseObject> list = new ArrayList<>();
        for (int i = 0; i < count; i++)
            list.add(new BaseObject(i, getRandomString(20)));
        return list;
    }

    public static String getRandomStringInSpace(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS_SPACE.charAt(random.nextInt(ALLOWED_CHARACTERS_SPACE.length())));
        return sb.toString();
    }
}
