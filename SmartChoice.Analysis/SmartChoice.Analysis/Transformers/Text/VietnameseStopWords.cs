using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace SmartChoice.Analysis.Transformers.Text
{
    public static class VietnameseStopWords
    {
        public static readonly string[] STOP_WORDS;
        static VietnameseStopWords()
        {
            STOP_WORDS = File.ReadAllLines("Data/vietnamese-stopwords.txt");
        }
    }
}
