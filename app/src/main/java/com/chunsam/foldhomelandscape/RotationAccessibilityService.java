package com.chunsam.foldhomelandscape;
import android.accessibilityservice.AccessibilityService;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
public class RotationAccessibilityService extends AccessibilityService {
 private static final String HOME="com.sec.android.app.launcher";
 public void onAccessibilityEvent(AccessibilityEvent e){ if(e==null)return; CharSequence p=e.getPackageName(); if(p==null)return; boolean home=HOME.equals(p.toString()); int w=getResources().getConfiguration().screenWidthDp; int h=getResources().getConfiguration().screenHeightDp; boolean inner=Math.min(w,h)>=600; if(!Settings.System.canWrite(this))return; try{ if(home&&inner){Settings.System.putInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION,0); Settings.System.putInt(getContentResolver(),Settings.System.USER_ROTATION,1);} else {Settings.System.putInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION,1);} }catch(SecurityException ignored){} }
 public void onInterrupt(){}
}