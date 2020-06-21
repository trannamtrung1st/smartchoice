using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using SmartChoice.Analysis.WebSurvey.Models;

namespace SmartChoice.Analysis.WebSurvey
{
    public class Startup
    {
        public static Dictionary<string, string> PERSONALITIES { get; private set; }
        public static Dictionary<string, string> HOBBIES { get; private set; }
        public static List<string> LOCATIONS { get; private set; }
        public static Dictionary<int, string> FIELDS { get; private set; }
        public static List<string> FIELD_LEVELS { get; private set; }
        public static List<string> STRENGTH_STATUSES { get; private set; }

        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddDbContext<DataContext>(opt =>
            {
                opt.UseSqlServer(Configuration.GetConnectionString("DataContext"));
                opt.UseLazyLoadingProxies();
            });

            services.AddRazorPages();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env, DataContext context)
        {
            Setup(context);
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
            }

            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapRazorPages();
            });
        }

        private void Setup(DataContext context)
        {
            Startup.PERSONALITIES = new Dictionary<string, string>();
            Startup.FIELDS = new Dictionary<int, string>();
            Startup.FIELD_LEVELS = new List<string>();
            Startup.HOBBIES = new Dictionary<string, string>();
            Startup.LOCATIONS = new List<string>();
            Startup.STRENGTH_STATUSES = new List<string>();

            var allPers = File.ReadAllLines("Data/personalities.txt");
            var allFLv = File.ReadAllLines("Data/fieldLevels.txt");
            var allHob = File.ReadAllLines("Data/hobbies.txt");
            var allStStt = File.ReadAllLines("Data/strengthStatuses.txt");
            foreach (var p in allPers)
            {
                var parts = p.Split(':');
                PERSONALITIES[parts[0].Trim()] = parts[1].Trim();
            }
            PERSONALITIES = new Dictionary<string, string>(
                PERSONALITIES.OrderBy(o => o.Value));
            foreach (var h in allHob)
            {
                var parts = h.Split(':');
                HOBBIES[parts[0].Trim()] = parts[1].Trim();
            }
            HOBBIES = new Dictionary<string, string>(
                HOBBIES.OrderBy(o => o.Value));
            foreach (var l in allFLv)
            {
                FIELD_LEVELS.Add(l);
            }
            foreach (var s in allStStt)
            {
                STRENGTH_STATUSES.Add(s);
            }
            LOCATIONS = context.Location.Select(l => l.Name).ToList();
            FIELDS = new Dictionary<int, string>(
                context.CareerField.Select(o => new KeyValuePair<int, string>(o.Id, o.Name)).ToList());
        }
    }
}
