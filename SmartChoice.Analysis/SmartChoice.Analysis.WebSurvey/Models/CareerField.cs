using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class CareerField
    {
        public CareerField()
        {
            JobField = new HashSet<JobField>();
        }

        public int Id { get; set; }
        public string Name { get; set; }

        public virtual ICollection<JobField> JobField { get; set; }
    }
}
