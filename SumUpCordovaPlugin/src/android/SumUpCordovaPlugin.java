package com.herbert.sumup;

import android.util.Log;
import android.widget.Toast;

import com.sumup.merchant.reader.api.SumUpAPI;
import com.sumup.merchant.reader.api.SumUpLogin;
import com.sumup.merchant.reader.api.SumUpState;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class triggers the SumUpSdk/Login from JavaScript.
 */
public class SumUpCordovaPlugin extends CordovaPlugin {

    @Override
    protected void pluginInitialize() {
        SumUpState.init(cordova.getActivity().getApplicationContext());
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("sumupLogin")) {
            try {
                String apiKey = this.cordova.getActivity().getString(
                        cordova.getActivity().getResources()
                                .getIdentifier("API_KEY", "string", cordova.getActivity().getPackageName()));

                if (!apiKey.isEmpty()) {
                    SumUpLogin sumupLogin = SumUpLogin.builder(apiKey).build();
                    SumUpAPI.openLoginActivity(cordova.getActivity(), sumupLogin, 1);
                } else {
                    Toast.makeText(cordova.getActivity().getApplicationContext(), "Api Key not found" ,
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(cordova.getActivity().getApplicationContext(), "Api Key not found ::: " + e.toString(),
                        Toast.LENGTH_LONG).show();
            }

        }
        return false;
    }

}