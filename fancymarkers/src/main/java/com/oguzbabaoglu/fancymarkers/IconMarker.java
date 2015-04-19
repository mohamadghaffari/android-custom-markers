/*
 * Copyright (C) 2015 Oguz Babaoglu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.oguzbabaoglu.fancymarkers;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * A simple Marker implementation with custom icon resources.
 *
 * @author Oguz Babaoglu
 */
public class IconMarker extends CustomMarker {

    private int selectedIcon;
    private int defaultIcon;

    public IconMarker(int iconRes) {
        defaultIcon = iconRes;
    }

    public IconMarker(int selectedRes, int unSelectedRes) {
        selectedIcon = selectedRes;
        defaultIcon = unSelectedRes;
    }

    public void setSelectedIcon(int selectedRes) {
        selectedIcon = selectedRes;
    }

    public void setUnSelectedIcon(int unSelectedRes) {
        defaultIcon = unSelectedRes;
    }

    @Override
    public boolean onStateChange(boolean selected) {
        return selectedIcon > 0;
    }

    @Override
    public BitmapDescriptor getBitmapDescriptor() {

        return BitmapDescriptorFactory.fromResource(
                selectedIcon > 0 && isSelected()
                        ? selectedIcon
                        : defaultIcon
        );
    }
}
