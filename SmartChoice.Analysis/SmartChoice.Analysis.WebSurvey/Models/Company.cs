using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.WebSurvey.Models
{
    public partial class Company
    {
        public Company()
        {
            JobPost = new HashSet<JobPost>();
        }

        public int Id { get; set; }
        public string Code { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public string Image { get; set; }
        public string DetailUrl { get; set; }

        public virtual ICollection<JobPost> JobPost { get; set; }
    }
}
