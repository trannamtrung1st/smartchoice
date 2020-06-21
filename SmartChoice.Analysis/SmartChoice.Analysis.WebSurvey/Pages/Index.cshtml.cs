using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using SmartChoice.Analysis.Models;
using SmartChoice.Analysis.WebSurvey.Models;

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

        public void OnGet()
        {
            var count = _context.JobPost.Count();
            var pos = new Random().Next(0, count);
            var post = _context.JobPost.Skip(pos).Take(1).FirstOrDefault();
            RandomPost = post;
        }

        public IActionResult OnPost(JobRecommenderData model)
        {
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
