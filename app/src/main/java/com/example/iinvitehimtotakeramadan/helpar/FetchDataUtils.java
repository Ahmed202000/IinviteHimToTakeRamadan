package com.example.iinvitehimtotakeramadan.helpar;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class FetchDataUtils {

    public static String[] getJsonResponseArray(final Context context, final LocationUtils.MyLocation myLocation,
                                                final int storeDays, final long startTimeInMillis) throws IOException {
        double longitude = myLocation.getLongitude();
        double latitude = myLocation.getLatitude();

        String[] jsonResponseArray = new String[storeDays];

        for (int i = 0; i < storeDays; i++) {
                long dayInSeconds = TimeUnit.DAYS.toSeconds(1);
                long dateInSeconds = startTimeInMillis / 1000 + dayInSeconds * i;

                String methodString = PreferenceUtils.getAzanCalcMethodFromPreferences(context);

                URL url = NetworkUtils.buildUrl(dateInSeconds, longitude, latitude,
                        AzanCalcMethodUtils.getAzanCalcMethodInt(context, methodString));
                jsonResponseArray[i] = NetworkUtils.gettingResponseFromHttpUrl(url);
        }
        return jsonResponseArray;
    }

    public static void saveAzanAppDataInPreferences(Context context, String[] jsonResponseArray,
                                                    int storeDays, long startTimeInMillis) throws JSONException {
        // storing all azan times for different days from jsonResponseArray into preferences
        // file
        for (int i = 0; i < storeDays; i++) {

            String dateString = AzanAppTimeUtils.convertMillisToDateString(
                    startTimeInMillis + i * AzanAppTimeUtils.DAY_IN_MILLIS
            );

            PreferenceUtils.setAzanTimesForDay(context, dateString,
                    AladhanJsonUtils.getAllAzanTimesIn24Format(jsonResponseArray[i]));

        }
    }
}
