using Microsoft.ML;
using Microsoft.ML.Transforms.Text;
using System;
using System.Collections.Generic;
using System.Text;

namespace SmartChoice.Analysis.Transformers.Text
{
    public static class TextTransformer
    {
        public static PredictionEngine<TextData, TokenizedTextData> GetTokenizeEngine(MLContext context)
        {
            var emptyDataView = context.Data.LoadFromEnumerable(new List<TextData>());
            var textPipeline = context.Transforms.Text.TokenizeIntoWords(
                outputColumnName: "Words",
                inputColumnName: "Text", separators: new[] { ' ' });
            var textTransformer = textPipeline.Fit(emptyDataView);
            var predictionEngine = context.Model.CreatePredictionEngine<TextData,
                TokenizedTextData>(textTransformer);
            return predictionEngine;
        }

        public static PredictionEngine<TextData, NormalizedTextData> GetNormalizeEngine(MLContext context)
        {
            var emptyDataView = context.Data.LoadFromEnumerable(new List<TextData>());
            var normTextPipeline = context.Transforms.Text.NormalizeText(
                "NormalizedText", "Text", TextNormalizingEstimator.CaseMode.Lower,
                keepDiacritics: false,
                keepPunctuations: false,
                keepNumbers: true);
            var normTextTransformer = normTextPipeline.Fit(emptyDataView);
            var predictionEngine = context.Model.CreatePredictionEngine<TextData,
                NormalizedTextData>(normTextTransformer);
            return predictionEngine;
        }

        public static PredictionEngine<TextData, NonStopWordsTextData>
            GetRemoveStopWordsEngine(MLContext context, string[] stopWords)
        {
            var emptyDataView = context.Data.LoadFromEnumerable(new List<TextData>());
            var textPipeline = context.Transforms.Text.TokenizeIntoWords("Words",
                "Text")
                .Append(context.Transforms.Text.RemoveStopWords(
                "WordsWithoutStopWords", "Words", stopwords:
                stopWords));
            var textTransformer = textPipeline.Fit(emptyDataView);
            var predictionEngine = context.Model.CreatePredictionEngine<TextData,
                NonStopWordsTextData>(textTransformer);
            return predictionEngine;
        }
    }
}
