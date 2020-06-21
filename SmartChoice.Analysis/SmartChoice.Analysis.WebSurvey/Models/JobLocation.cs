using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class JobLocation
    {
        public string LocationName { get; set; }
        public int JobPostId { get; set; }

        public virtual JobPost JobPost { get; set; }
        public virtual Location LocationNameNavigation { get; set; }
    }
}
