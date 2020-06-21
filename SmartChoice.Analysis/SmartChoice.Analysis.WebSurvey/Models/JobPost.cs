using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class JobPost
    {
        public JobPost()
        {
            JobField = new HashSet<JobField>();
            JobLocation = new HashSet<JobLocation>();
        }

        public int Id { get; set; }
        public string Code { get; set; }
        public string Name { get; set; }
        public string Url { get; set; }
        public double? SalaryFrom { get; set; }
        public double? SalaryTo { get; set; }
        public string ExperienceRequirement { get; set; }
        public string DegreeRequirement { get; set; }
        public int? NumOfVacancy { get; set; }
        public bool? GenderRequirement { get; set; }
        public string Description { get; set; }
        public string Benefit { get; set; }
        public string OtherRequirement { get; set; }
        public DateTime? ExpiredDate { get; set; }
        public DateTime? UpdatedDate { get; set; }
        public string ContactPerson { get; set; }
        public string ContactAddress { get; set; }
        public int CompanyId { get; set; }

        public virtual Company Company { get; set; }
        public virtual ICollection<JobField> JobField { get; set; }
        public virtual ICollection<JobLocation> JobLocation { get; set; }
    }
}
