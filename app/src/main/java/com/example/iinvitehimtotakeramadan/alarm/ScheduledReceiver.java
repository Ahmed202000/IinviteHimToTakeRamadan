/*
 * Copyright (C) 2018 Yahia H. El-Tayeb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.iinvitehimtotakeramadan.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.iinvitehimtotakeramadan.helpar.AzanAppHelperUtils;
import com.example.iinvitehimtotakeramadan.helpar.AzanAppTimeUtils;
import com.example.iinvitehimtotakeramadan.helpar.PreferenceUtils;
import com.example.iinvitehimtotakeramadan.view.PlayAzanSound;
import com.example.iinvitehimtotakeramadan.widget.AzanWidgetService;

/**
 * Created by yahia on 1/2/18.
 */

public class ScheduledReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // if no data stored for the current azan, nothing will do
        if (PreferenceUtils.getAzanTimesIn24Format(context,
                AzanAppTimeUtils.convertMillisToDateString(System.currentTimeMillis())) == null)
            return;

        int indexOfCurrentAzanTime = AzanAppHelperUtils.getIndexOfCurrentTime(context);
        if (AzanAppHelperUtils.isValidPlayAzanTimeIndex(indexOfCurrentAzanTime)) {
            Intent startPlaySoundActivityIntent = new Intent(context, PlayAzanSound.class);
            startPlaySoundActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startPlaySoundActivityIntent);
        } else {
            AzanWidgetService.startActionDisplayAzanTime(context);
        }
    }
}
