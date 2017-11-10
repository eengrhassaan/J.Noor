package com.example.lenovo.jnoor.WebRestApiServices;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by LENOVO on 11/3/2017.
 */

public class Rest_Api_Services extends AsyncTask<String, String, String>{

    //Rest API's Variables
    String responses = "SERVER RESPONSES: ";
    String responseString = "";
    int statusCode = 0;
    private static final String TAG = "AARestTask";
    public static final String HTTP_RESPONSE = "httpResponse";
    public JSONObject postData,getData,putData,deleteData;
    URL url;
    HttpURLConnection httpsURLConnection;

    private Context mContext;
    private String mAction;

    public Rest_Api_Services(Context applicationContext, String task_code) {
        mContext = applicationContext;
        mAction = task_code;
    }

    public Rest_Api_Services(Map<String,String> getData){
        if(getData != null){
            this.getData = new JSONObject(getData);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Log.d(responses,"In DoInBackground");
            url = new URL(params[0]);
            httpsURLConnection = (HttpURLConnection) url.openConnection();
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setReadTimeout(15000);
            //httpsURLConnection.setDoInput(true);
            //httpsURLConnection.setDoOutput(true);
            //httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestMethod("GET");
            if (getData!=null){
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
                outputStreamWriter.write(getData.toString());
                outputStreamWriter.flush();
            }
            //Check the stauscode response from server and then perform the reqyui
            statusCode = httpsURLConnection.getResponseCode();
            if (statusCode == 200){
                InputStream inputStream = new BufferedInputStream(httpsURLConnection.getInputStream());

                byte[] contents = new byte[4096];
                int bytesRead = 0;
                responseString = "";
                String strFileContents;
                JSONObject jsonObject = new JSONObject(String.valueOf(inputStream));
                while ((bytesRead = inputStream.read(contents)) != -1) {
                    strFileContents = new String(contents, 0, bytesRead);
                    System.out.print(strFileContents);
                    responseString = strFileContents;
                }
                inputStream.close();

                //responseString = inputStream.toString();
                System.out.println("RESULT = " + responseString.toString());

            } else {
                Log.d(responses,"Unknown Error");
                System.out.println("RESULT = " + statusCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            responseString = e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            responseString = e.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseString;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
        Log.d(responses, "RESULT on POST Execute = " + s);
        Intent intent = new Intent(mAction);
        intent.putExtra(HTTP_RESPONSE, s);

        // broadcast the completion
        mContext.sendBroadcast(intent);
    }
}
