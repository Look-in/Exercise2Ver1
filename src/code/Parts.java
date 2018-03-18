package code;

/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 * Consists of lists both parts of the text and parts of the sentence.
 */

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
