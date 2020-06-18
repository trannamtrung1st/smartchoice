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
            var text = new TextData
            {
                Text = "Anh ấy yêu cầu 10 năm kinh nghiệm, gắn bó với công ty.\n" +
                "- Làm việc nghiêm túc, linh hoạt."
            };
            Console.WriteLine(text.Text);
            //var tEngine = TextTransformer.GetTokenizeEngine(context);
            //var tWords = tEngine.Predict(new TextData() { Text = nText.NormalizedText });
            var nswEngine = TextTransformer.GetRemoveStopWordsEngine(context, VietnameseStopWords.STOP_WORDS);
            var nswWords = nswEngine.Predict(text);
            var nswText = string.Join(' ', nswWords.WordsWithoutStopWords);
            var normalizeEngine = TextTransformer.GetNormalizeEngine(context);
            var nText = normalizeEngine.Predict(new TextData() { Text = nswText });
            Console.WriteLine(nText.NormalizedText);
        }
    }
}
