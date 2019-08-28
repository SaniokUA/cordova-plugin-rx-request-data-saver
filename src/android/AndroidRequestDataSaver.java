package com.rex.plugin;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class AndroidRequestDataSaver extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        Log.d("TapApp", "action = " + action);


        if (action.equals("saveData")) {

            ArrayList<String> list = new ArrayList<String>();
            if (data != null) {
                int len = data.length();
                for (int i = 0; i < len; i++) {
                    list.add(data.get(i).toString());
                    Log.d("TapApp", data.get(i).toString());
                }
            }

            int d = list.size();
            callbackContext.success();
            return true;
        } else {
            callbackContext.error("Error parse");
            return false;
        }
    }
}
