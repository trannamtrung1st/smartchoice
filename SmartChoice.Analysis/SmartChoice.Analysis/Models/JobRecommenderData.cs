using Microsoft.ML.Data;
using System;
using System.Collections.Generic;
using System.Text;

namespace SmartChoice.Analysis.Models
{
    public class JobRecommenderData
    {
        public string jobName { get; set; }
        public float salaryFrom { get; set; }
        public float salaryTo { get; set; }
        public string experienceRequirement { get; set; }
        public string degreeRequirement { get; set; }
        public int numOfVacancy { get; set; }
        public int? genderRequirement { get; set; }
        public string description { get; set; }
        public string benefit { get; set; }
        public string otherRequirement { get; set; }
        public int companyId { get; set; }
        public int fieldId { get; set; }
        public string locationName { get; set; }
        public bool gender { get; set; }
        public string personality1 { get; set; }
        public string personality2 { get; set; }
        public string personality3 { get; set; }
        public string liveLocation { get; set; }
        public int fieldStudy { get; set; }
        public string fieldLevel { get; set; }
        public string strengthStatus { get; set; }
        public string hobby1 { get; set; }
        public string hobby2 { get; set; }
        public string hobby3 { get; set; }
        public float rating { get; set; }

    }
}
