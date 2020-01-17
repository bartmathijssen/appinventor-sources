// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2016-2019 MIT, All rights reserved
// Copyright 2017-2019 Kodular, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;

@DesignerComponent(version = YaVersion.MAGNETICFIELDSENSOR_COMPONENT_VERSION,
    description = "<p>Non-visible component that measures the ambient geomagnetic field for all three physical axes (x, y, z) in Tesla https://en.wikipedia.org/wiki/Tesla_(unit).</p>",
    category = ComponentCategory.SENSORS,
    nonVisible = true,
    iconName = "images/magneticSensor.png")
@SimpleObject
public class MagneticFieldSensor extends MultipleValueSensor {
  private float xStrength;
  private float yStrength;
  private float zStrength;

  public MagneticFieldSensor(ComponentContainer container, int sensorType) {
    super(container, sensorType);
  }

  @Override
  protected void onValuesChanged(float[] values) {
    xStrength = values[0];
    yStrength = values[1];
    zStrength = values[2];
    MagneticChanged(xStrength, yStrength, zStrength);
  }

  @SimpleEvent
  public void MagneticChanged(float xStrength, float yStrength, float zStrength) {
    EventDispatcher.dispatchEvent(this, "MagneticChanged", xStrength, yStrength, zStrength);
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR)
  public float Xstrength() {
    return xStrength;
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR)
  public float Ystrength() {
    return yStrength;
  }

  @SimpleProperty(category = PropertyCategory.BEHAVIOR)
  public float Zstrength() {
    return zStrength;
  }
}
