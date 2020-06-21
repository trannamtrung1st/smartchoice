using Microsoft.ML;
using SmartChoice.Analysis.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace SmartChoice.Analysis
{
    public class JobRecommender
    {
        protected MLContext mlContext;

        public JobRecommender()
        {
            mlContext = new MLContext();
        }

        public void LoadData()
        {
        }

        public void PrepareData()
        {
            //begin - normalize numOfVancancy
            var minMaxEstimator = mlContext.Transforms.NormalizeMinMax(nameof(JobRecommenderData.numOfVacancy));
            //ITransformer minMaxTransformer = minMaxEstimator.Fit(data);
            //IDataView transformedData = minMaxTransformer.Transform(data);
            //end - normalize numOfVancancy
        }

    }
}
