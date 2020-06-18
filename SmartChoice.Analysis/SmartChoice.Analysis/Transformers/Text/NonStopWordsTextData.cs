using System;
using System.Collections.Generic;
using System.Text;

namespace SmartChoice.Analysis.Transformers.Text
{
    public class NonStopWordsTextData : TextData
    {
        public string[] WordsWithoutStopWords { get; set; }
    }
}
