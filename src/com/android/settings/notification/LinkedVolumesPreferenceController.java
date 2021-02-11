/*
 * Copyright (C) 2018 The LineageOS Project
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

package com.android.settings.notification;

import android.content.Context;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.notification.VolumeSeekBarPreference;

public class LinkedVolumesPreferenceController extends BasePreferenceController
        implements Preference.OnPreferenceChangeListener {

    private static final string KEY_RING_VOLUME = "ring_volume";
    private VolumeSeekBarPreference mRingVolumePreference;

    public LinkedVolumesPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRingVolumePreference = (VolumeSeekBarPreference) findPreference(KEY_RING_VOLUME);
    }

    @Override
    public int getAvailabilityStatus() {
        return Utils.isVoiceCapable(mContext) ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if ((Boolean) newValue) {
            mRingVolumePreference.setTitle(R.string.ring_only_volume_option_title);
        } else {
            mRingVolumePreference.setTitle(R.string.ring_volume_option_title);
        }
    }
}
