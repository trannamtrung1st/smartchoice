using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class Location
    {
        public Location()
        {
            JobLocation = new HashSet<JobLocation>();
        }

        public string Name { get; set; }
        public bool? IsInVietNam { get; set; }

        public virtual ICollection<JobLocation> JobLocation { get; set; }
    }
}
