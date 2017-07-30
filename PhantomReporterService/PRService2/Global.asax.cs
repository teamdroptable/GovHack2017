using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Routing;

namespace PRService2
{
    public class WebApiApplication : System.Web.HttpApplication
    {
        public static PRService service = new PRService();
        protected void Application_Start()
        {
            GlobalConfiguration.Configure(WebApiConfig.Register);

            //service.ReportCrime("Manuka", "-35.3181", "149.1347", "Cricket bat weilding maniac chased me accross Manuka Oval", new string[] { "assault", "maniac" });
            
            
            //var test = service.GetCrimeStatistics("Aranda");

            //var tttt = "";
            //service.GetHistoricalCrimeData("Aranda");
        }
    }
}
