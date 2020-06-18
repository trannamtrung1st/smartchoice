using Microsoft.ML;
using SmartChoice.Analysis.Transformers.Text;
using System;
using System.Collections.Generic;

namespace SmartChoice.Analysis.ConsoleClient
{
    class Program
    {
        static void Main(string[] args)
        {
            var context = new MLContext();
            var engine = TextTransformer.GetTokenizeEngine(context);
            var words = engine.Predict(new TextData
            {
                Text = "Yêu cầu 10 năm kinh nghiệm, gắn bó với công ty.\n" +
                "- Làm việc nghiêm túc, linh hoạt."
            });
            foreach (var w in words.Words)
            {
                Console.WriteLine(w);
            }
        }
    }
}
