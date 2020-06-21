using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace SmartChoice.Analysis.WebSurvey
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //dotnet ef dbcontext scaffold "Server=localhost;Database=SmartChoice;Trusted_Connection=False;User Id=sa;Password=123456;" Microsoft.EntityFrameworkCore.SqlServer -o Models -c DataContext --project SmartChoice.Analysis.WebSurvey
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
