package com.example.marciano.aps1.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marciano on 14/10/2017.
 */

public class Util {
    public static boolean isValidEmail(String email) {
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }

    public static int indexOf(String value, String[] list) {
        for (int i = 0; i < list.length; i++)
            if (list[i].equals(value))
                return i;

        return -1;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        //https://kennethflynn.wordpress.com/2012/09/12/putting-android-listviews-in-scrollviews/
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static int randomInt(int min, int max) {
        Random ran = new Random();
        return ran.nextInt(max - min + 1) + min;
    }
}
