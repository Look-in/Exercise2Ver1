/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 * Consists of lists both parts of the text and parts of the sentence.
 */

package code;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public interface Parts {

    List<TextBlockType> textParts = new ArrayList<>(EnumSet.range(TextBlockType.PARAGRAPH, TextBlockType.WORD));

    List<TextBlockType> sentenceParts = new ArrayList<>(EnumSet.range(TextBlockType.EMAIL, TextBlockType.MARKER));
}
