using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class JobField
    {
        public int CareerFieldId { get; set; }
        public int JobPostId { get; set; }

        public virtual CareerField CareerField { get; set; }
        public virtual JobPost JobPost { get; set; }
    }
}
