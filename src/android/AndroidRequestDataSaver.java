package com.rex.plugin;

import android.util.Log;
import com.tapapp.rex.PrefDataSaver;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.LinkedHashMap;
import java.util.Map;

public class AndroidRequestDataSaver extends CordovaPlugin {

    JSONObject jsonObject;
    Map<String, String> map;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        Log.d("TapApp", "action = " + action);

        jsonObject = new JSONObject(data.get(0).toString());
        map = new LinkedHashMap<>();
        PrefDataSaver prefDataSaver = new PrefDataSaver(cordova.getActivity());

        if (action.equals("requestDataSaver")) {

            Log.d("TapApp", "requestDataSaver: ");

//            Log.d("TapApp", "jsonObject.length() = " + jsonObject.length());

            if (jsonObject != null) {
                map.put("baseUrl", jsonObject.get("baseUrl").toString());
                map.put("basePath", jsonObject.get("basePath").toString());
                map.put("token", jsonObject.get("token").toString());
                map.put("fcmToken", jsonObject.get("fcmToken").toString());
                map.put("uuid", jsonObject.get("uuid").toString());
                map.put("os", jsonObject.get("os").toString());


                prefDataSaver.saveBaseUrl(map.get("baseUrl"));
                prefDataSaver.savePathUrl(map.get("basePath"));

                prefDataSaver.saveP0Name("token");
                prefDataSaver.saveP0Value(map.get("token"));

                prefDataSaver.saveP1Name("token");
                prefDataSaver.saveP1Value(map.get("fcmToken"));

                prefDataSaver.saveP2Name("uuid");
                prefDataSaver.saveP2Value(map.get("uuid"));

                prefDataSaver.saveP3Name("os");
                prefDataSaver.saveP3Value(map.get("os"));
            }

            Log.d("TapApp", "size = " + map.size());

            return true;
        } else if (action.equals("changeSchedule")) {
            Log.d("TapApp", "changeSchedule jsonObject" + jsonObject.toString());


            if (jsonObject != null) {
                prefDataSaver.saveIsLogin( jsonObject.get("isLogin").toString());
                Log.d("TapApp", "isLogin: " + jsonObject.get("isLogin").toString());
            }

            return true;
        } else {
            return false;
        }
    }
}
