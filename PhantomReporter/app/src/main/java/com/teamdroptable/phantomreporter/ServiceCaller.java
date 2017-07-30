package com.teamdroptable.phantomreporter;

import android.os.StrictMode;

import java.util.Vector;

import org.json.JSONObject;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Grisha on 29/07/2017.
 */

public class ServiceCaller  {
    public static final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    public static final String SERVCICE_URL = "https://phantomreporter.azurewebsites.net/PRService.asmx";

    public static void ReportCrime(String suburb, Double latitude, Double longitude, String comment, Vector<String> tags)
    {
        String method = "ReportCrime";
        Vector<PropertyInfo> parameters = new Vector<PropertyInfo>();
        parameters.add(CreatePropertyInfo("suburb", suburb, PropertyInfo.STRING_CLASS));
        parameters.add(CreatePropertyInfo("latitude", Double.toString(latitude), PropertyInfo.STRING_CLASS));
        parameters.add(CreatePropertyInfo("longitude", Double.toString(longitude), PropertyInfo.STRING_CLASS));
        parameters.add(CreatePropertyInfo("comment", comment, PropertyInfo.STRING_CLASS));
        parameters.add(CreatePropertyInfo("tags", tags, PropertyInfo.VECTOR_CLASS));

        CallFunciton(method, parameters);

    }

    public static HistoricalCrime GetHistoricalCrimeData(String suburb)
    {
        String method = "GetHistoricalCrimeData";
        Vector<PropertyInfo> parameters = new Vector<PropertyInfo>();
        parameters.add(CreatePropertyInfo("suburb", suburb, PropertyInfo.STRING_CLASS));

        JSONObject result = CallFunciton(method, parameters);
        HistoricalCrime historicalCrime = new HistoricalCrime(result);
        historicalCrime.suburb = suburb;
        return historicalCrime;
    }

    public static RecentCrimeStatistics GetCrimeStatistics(String suburb)
    {
        String method = "GetCrimeStatistics";
        Vector<PropertyInfo> parameters = new Vector<PropertyInfo>();
        parameters.add(CreatePropertyInfo("suburb", suburb, PropertyInfo.STRING_CLASS));

        JSONObject result =CallFunciton(method, parameters);
        RecentCrimeStatistics recentCrime = new RecentCrimeStatistics(result);
        recentCrime.suburb = suburb;
        return recentCrime;
    }

    public static PropertyInfo CreatePropertyInfo(String name, Object value, java.lang.Class classtype)
    {
        PropertyInfo pi=new PropertyInfo();
        pi.setName(name);
        pi.setValue(value);
        pi.setType(classtype);
        return pi;
    }


    public static JSONObject CallFunciton(String method, Vector<PropertyInfo> parameters)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        final String taskMethod = method;
        final Vector<PropertyInfo> parameterVector = parameters;
        //Thread thread = new Thread(new Runnable() {

        //@Override
        //public void run() {
            SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, taskMethod);

            for (int i = 0; i < parameterVector.size(); i++)
            {
                request.addProperty(parameterVector.get(i));
            }

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransport = new HttpTransportSE(SERVCICE_URL);
            Object response=null;
            try
            {
                httpTransport.call(WSDL_TARGET_NAMESPACE + taskMethod, envelope);
                response = envelope.getResponse();
                String responceString = response.toString();
                JSONObject jsonObject = new JSONObject(responceString);
                return jsonObject;
            }
            catch (Exception exception)
            {
                response=exception.toString();
            }
            return new JSONObject();
            //String result = response.toString();
            //return ;
        //}
//    });
//
//    thread.start();
//
//        return "";
    }
}

