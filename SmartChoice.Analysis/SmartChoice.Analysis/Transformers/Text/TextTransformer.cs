using Microsoft.ML;
using System;
using System.Collections.Generic;
using System.Text;

namespace SmartChoice.Analysis.Transformers.Text
{
    public static class TextTransformer
    {
        public static PredictionEngine<TextData, TokenizedText> GetTokenizeEngine(MLContext context)
        {
            var emptyDataView = context.Data.LoadFromEnumerable(new List<TextData>());
            var textPipeline = context.Transforms.Text.TokenizeIntoWords(
                outputColumnName: "Words",
                inputColumnName: "Text", separators: new[] { ' ' });
            var textTransformer = textPipeline.Fit(emptyDataView);
            var predictionEngine = context.Model.CreatePredictionEngine<TextData,
                TokenizedText>(textTransformer);
            return predictionEngine;
        }
    }
}
