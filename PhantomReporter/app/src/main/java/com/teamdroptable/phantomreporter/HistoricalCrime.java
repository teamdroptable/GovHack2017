package com.teamdroptable.phantomreporter;

/**
 * Created by Grisha on 30/07/2017.
 */

import org.json.*;
//import org.json.simple.*;
//import org.json.simple.JSONObject;
//import org.json.simple.*;
//import org.json.simple.parser.*;
//import org.json.JSONArray;

public class HistoricalCrime {

    public String suburb;
    public int Assault;
    public int Burglary;
    public int Homicide;
    public int Motor_vehicle_theft;
    public int Offences_against_a_person;
    public int Other_offences;
    public int Property_damage;
    public int Road_collision_with_injury;
    public int Road_fatality;
    public int Robbery;
    public int Sexual_assault;
    public int Theft_excluding_Motor_Vehicles;
    public int Traffic_Infringement_Notices;
    public int Total;

    HistoricalCrime(JSONObject jsonObject)
    {
        try
        {
            Assault = jsonObject.getInt("Assault");
            Burglary = jsonObject.getInt("Burglary");
            Homicide = jsonObject.getInt("Homicide");
            Motor_vehicle_theft = jsonObject.getInt("Motor_vehicle_theft");
            Offences_against_a_person = jsonObject.getInt("Offences_against_a_person");
            Other_offences = jsonObject.getInt("Other_offences");
            Property_damage = jsonObject.getInt("Property_damage");
            Road_collision_with_injury = jsonObject.getInt("Road_collision_with_injury");
            Road_fatality = jsonObject.getInt("Road_fatality");
            Robbery = jsonObject.getInt("Robbery");
            Sexual_assault = jsonObject.getInt("Sexual_assault");
            Theft_excluding_Motor_Vehicles = jsonObject.getInt("Theft_excluding_Motor_Vehicles");
            Traffic_Infringement_Notices = jsonObject.getInt("Traffic_Infringement_Notices");
            Total = jsonObject.getInt("Total");
        }
        catch (Exception exception)
        {

        }
    }

}
