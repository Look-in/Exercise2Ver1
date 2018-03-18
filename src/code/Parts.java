package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Parts {

    List<SentenceBlockType> textParts = new ArrayList<>(Arrays.asList(
            SentenceBlockType.PARAGRAPH,
            SentenceBlockType.SENTENCE,
            SentenceBlockType.WORD));

    List<SentenceBlockType> sentenceParts = new ArrayList<>(Arrays.asList(
            SentenceBlockType.WHITESPACE,
            SentenceBlockType.EMAIL,
            SentenceBlockType.NUMERIC,
            SentenceBlockType.MARKER,
            SentenceBlockType.PHONE));

}
