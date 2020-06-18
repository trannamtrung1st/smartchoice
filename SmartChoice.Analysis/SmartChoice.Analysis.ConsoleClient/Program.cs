using Microsoft.ML;
using SmartChoice.Analysis.Transformers.Text;
using System;
using System.Collections.Generic;
using System.Linq;

namespace SmartChoice.Analysis.ConsoleClient
{
    class Program
    {
        static void Main(string[] args)
        {
            var listData = new List<TextData>()
            {
                new TextData
                {
                    Text = "Anh ấy yêu cầu 10 năm kinh nghiệm, gắn bó với công ty.",
                },
                new TextData
                {
                    Text = "- Làm việc nghiêm túc, linh hoạt.",
                }
            };
            var context = new MLContext();
            var engine = TextTransformer.GetFeaturizeTextEngine(context, listData);
            var finalData = engine.Predict(new TextData
            {
                Text = "Yêu cầu em nhất trên đời"
            });
            Console.Write("Features: ");
            foreach (var f in finalData.Features)
                Console.WriteLine(f);
        }
    }
}
