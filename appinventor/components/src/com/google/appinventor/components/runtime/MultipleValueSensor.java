// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0


package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;

import android.hardware.SensorEvent;

@SimpleObject
public abstract class MultipleValueSensor extends SensorBase {
  protected float[] values;  // most recent values read

  public MultipleValueSensor(ComponentContainer container, int sensorType) {
    super(container, sensorType);
  }

  @Override
  public void onSensorChanged(SensorEvent sensorEvent) {
    if (enabled && sensorEvent.sensor.getType() == sensorType) {
      values = sensorEvent.values;
      onValuesChanged(values);
    }
  }

  protected abstract void onValuesChanged(float[] values);

  protected float getValueAtIndex(int index) {
    return values[index];
  }
}
