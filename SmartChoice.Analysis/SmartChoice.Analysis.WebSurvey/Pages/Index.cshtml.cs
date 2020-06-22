using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using SmartChoice.Analysis.Models;
using SmartChoice.Analysis.WebSurvey.Models;
using TNT.Core.Http;

namespace SmartChoice.Analysis.WebSurvey.Pages
{
    public class IndexModel : PageModel
    {
        private readonly ILogger<IndexModel> _logger;
        private DataContext _context;

        public IndexModel(ILogger<IndexModel> logger, DataContext context)
        {
            _logger = logger;
            _context = context;
        }

        public JobPost RandomPost { get; set; }
        public JobRecommenderData InputData { get; set; }

        public void OnGet()
        {
            InputData = HttpContext.Session.Get<JobRecommenderData>("input_data");
            if (InputData != null)
            {
                var query = _context.JobPost
                    .Where(p => p.JobField.Any(f => f.CareerFieldId == InputData.fieldStudy));
                var count = query.Count();
                var pos = new Random().Next(0, count);
                var post = query.Skip(pos).Take(1).FirstOrDefault();
                RandomPost = post;
            }
        }

        public IActionResult OnPost(JobRecommenderData model)
        {
            HttpContext.Session.Set("input_data", model);
            if (model.jobName == null) return LocalRedirect("/");
            var dataStr = $"{model.jobName}\t" +
                $"{model.salaryFrom}\t" +
                $"{model.salaryTo}\t" +
                $"{model.experienceRequirement}\t" +
                $"{model.degreeRequirement}\t" +
                $"{model.numOfVacancy}\t" +
                $"{model.genderRequirement}\t" +
                $"{model.description}\t" +
                $"{model.benefit}\t" +
                $"{model.otherRequirement}\t" +
                $"{model.companyId}\t" +
                $"{model.fieldId}\t" +
                $"{model.locationName}\t" +
                $"{model.gender}\t" +
                $"{model.personality1}\t" +
                $"{model.personality2}\t" +
                $"{model.personality3}\t" +
                $"{model.liveLocation}\t" +
                $"{model.fieldStudy}\t" +
                $"{model.fieldLevel}\t" +
                $"{model.strengthStatus}\t" +
                $"{model.hobby1}\t" +
                $"{model.hobby2}\t" +
                $"{model.hobby3}\t" +
                $"{model.rating}";
            System.IO.File.AppendAllLines("Data/final-data.tsv", new List<string>() { dataStr });
            return LocalRedirect("/");
        }
    }
}
