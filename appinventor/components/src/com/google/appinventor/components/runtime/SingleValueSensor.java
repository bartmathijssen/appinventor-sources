// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0


package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;

import android.hardware.SensorEvent;

@SimpleObject
public abstract class SingleValueSensor extends SensorBase {
  protected float value;  // most recent value read

  public SingleValueSensor(ComponentContainer container, int sensorType) {
    super(container, sensorType);
  }

  @Override
  public void onSensorChanged(SensorEvent sensorEvent) {
    if (enabled && sensorEvent.sensor.getType() == sensorType) {
      final float[] values = sensorEvent.values;
      value = values[0];
      onValueChanged(value);
    }
  }

  protected abstract void onValueChanged(float value);

  protected float getValue() {
    return value;
  }
}
