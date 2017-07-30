package com.teamdroptable.phantomreporter;

import org.json.JSONObject;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Grisha on 30/07/2017.
 */

public class RecentCrimeStatistics {
    String suburb;
    HashMap<String, Integer> tags;

    RecentCrimeStatistics(JSONObject jsonObject)
    {
        try
        {
            JSONObject tagsJsonObject = jsonObject.getJSONObject("tagFrequency");
            tags = new HashMap<String, Integer>(){};
            while (tagsJsonObject.keys().hasNext())
            {
                String key = tagsJsonObject.keys().next();
                tags.put(key, tagsJsonObject.getInt(key));
                tagsJsonObject.remove(key);
            }
        }
        catch (Exception exception)
        {

        }
    }
}
