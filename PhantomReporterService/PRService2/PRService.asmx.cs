using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

using Newtonsoft.Json;

namespace PRService2
{
    /// <summary>
    /// Summary description for PRService
    /// </summary>
    /// 

    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    [System.Web.Script.Services.ScriptService]
    public class PRService : System.Web.Services.WebService
    {
        private const string ConnectString = @"Server=tcp:phantomreporterserver.database.windows.net,1433;Initial Catalog=PhantomReporterDB;Persist Security Info=False;User ID=********;Password=******;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30";
        
        public PhantomReporterDBDataContext GetNewContext()
        {
            return new PhantomReporterDBDataContext(ConnectString);

        }
        
        [WebMethod]
        public string GetHistoricalCrimeData(string suburb)
        {
            var dbContext = GetNewContext();
            var crimehistory = (from ch in dbContext.CrimeHistory
                                where ch.Suburb == suburb
                                select ch).ToList();

            var totalAssaults = crimehistory.Sum(item => item.Assault);

            var assault = crimehistory.Sum(item => item.Assault);
            var burglary = crimehistory.Sum(item => item.Burglary);
            var homicide = crimehistory.Sum(item => item.Homicide);
            var motor_vehicle_theft = crimehistory.Sum(item => item.Motor_vehicle_theft);
            var offences_against_a_person = crimehistory.Sum(item => item.Offences_against_a_person);
            var other_offences = crimehistory.Sum(item => item.Other_offences);
            var property_damage = crimehistory.Sum(item => item.Property_damage);
            var road_collision_with_injury = crimehistory.Sum(item => item.Road_collision_with_injury);
            var road_fatality = crimehistory.Sum(item => item.Road_fatality);
            var robbery = crimehistory.Sum(item => item.Robbery);
            var sexual_assault = crimehistory.Sum(item => item.Sexual_assault);
            var theft_excluding_Motor_Vehicles = crimehistory.Sum(item => item.Theft__excluding_Motor_Vehicles_);
            var traffic_Infringement_Notices = crimehistory.Sum(item => item.Traffic_Infringement_Notices);
            var total = assault + burglary +
                        homicide + motor_vehicle_theft
                        + offences_against_a_person + other_offences
                        + property_damage + road_collision_with_injury
                        + road_fatality + robbery
                        + sexual_assault + theft_excluding_Motor_Vehicles
                        + theft_excluding_Motor_Vehicles + traffic_Infringement_Notices;

            var retVal = new
            {
                Assault = assault,
                Burglary = burglary,
                Homicide = homicide,
                Motor_vehicle_theft = motor_vehicle_theft,
                Offences_against_a_person = offences_against_a_person,
                Other_offences = other_offences,
                Property_damage = property_damage,
                Road_collision_with_injury = road_collision_with_injury,
                Road_fatality = road_fatality,
                Robbery = robbery,
                Sexual_assault = sexual_assault,
                Theft_excluding_Motor_Vehicles = theft_excluding_Motor_Vehicles,
                Traffic_Infringement_Notices = traffic_Infringement_Notices,
                Total = total,
            };

            var retString = JsonConvert.SerializeObject(retVal);

            dbContext.Dispose();
            return retString;
        }

        [WebMethod]
        public object GetCrimeStatistics(string suburb)
        {
            var currentTime = DateTime.UtcNow;
            var oneDayAgo = currentTime.AddDays(-1);
            var dbContext = GetNewContext();
            var crimehistory = (from cc in dbContext.CrimeComment
                                where cc.Suburb == suburb
                                && cc.InputDateTime > oneDayAgo
                                select cc).ToList();

            var tagsGroups = crimehistory.SelectMany(item => item.CrimeTag).GroupBy(item => item.HashTag);
            Dictionary<string, int> tagFrequency = tagsGroups.ToDictionary(item => item.Key, value => value.Count());
            

            var retVal = new
            {
                tagFrequency
            };

            var retString = JsonConvert.SerializeObject(retVal);

            dbContext.Dispose();
            return retString;
        }

        [WebMethod]
        public object ReportCrime(string suburb, string latitude, string longitude, string comment, string[] tags)
        {
            var currentTime = DateTime.UtcNow;
            var dbContext = GetNewContext();

            var newCrimeComment = new CrimeComment();
            newCrimeComment.Comment = comment;
            newCrimeComment.Suburb = suburb;
            newCrimeComment.Latitude = latitude;
            newCrimeComment.Longitude = longitude;
            newCrimeComment.InputDateTime = currentTime;

            dbContext.CrimeComment.InsertOnSubmit(newCrimeComment);
            
            foreach (var tag in tags)
            {
                var newCrimeTag = new CrimeTag();
                newCrimeTag.HashID = newCrimeComment.HashID;
                newCrimeTag.HashTag = tag;
                dbContext.CrimeTag.InsertOnSubmit(newCrimeTag);
            }
            dbContext.SubmitChanges();

            dbContext.Dispose();
            return "report Submitted";
        }
    }
}
