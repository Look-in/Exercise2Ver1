/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 * Integer wordLengthForReplacing - the length of words for replacing
 * Zero or a negative number - without replacement.
 * Also can use regex ->
 * sentence.replaceAll("\\b[A-Za-z�-��-�0-9]{"+modifyLength+"}\\b", toModify);
 * Collect - recursive method for reading text from the childblocks
 * Split - recursive method for placing text to the childblocks
 */

package code;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Block extends ArrayList<Block>{

    private TextBlockType textBlockType;

    private String text;

    public Block(TextBlockType textBlockType, String text) {
        this.textBlockType = textBlockType;
        this.text = text;
    }

    public void split(TextBlockType beginTextBlockType, TextBlockType endTextBlockType) {
        splitBlock(beginTextBlockType);
        if (beginTextBlockType != endTextBlockType & Parts.textParts.indexOf(beginTextBlockType) < Parts.textParts.size() - 1)
            this.forEach(e -> e.split(Parts.textParts.get(Parts.textParts.indexOf(beginTextBlockType) + 1), endTextBlockType));
    }

    private void splitBlock(TextBlockType textBlockType) {
        if (textBlockType == textBlockType.WORD) {
            StringTokenizer tokenizer = new StringTokenizer(text, textBlockType.getRegex(), true);
            String token;
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                for (TextBlockType kind : Parts.sentenceParts)
                    if (token.matches(kind.getRegex())) {
                        this.add(new Block(kind, token));
                        token = null;
                        break;
                    }
                if (token != null) this.add(new Block(textBlockType, token));
            }
        } else
            for (String regex : text.split(textBlockType.getRegex()))
                this.add(new Block(textBlockType, regex));
    }

    public void collect(StringBuilder splitedText, TextBlockType endSentenceBlockType, int wordLengthForReplacing) {
        if (textBlockType != endSentenceBlockType & !this.isEmpty())
            this.forEach(e -> e.collect(splitedText, endSentenceBlockType, wordLengthForReplacing));
        else
            /*Resolving the exercise N16 - replace each word length more than X with =====Java=====
              without replacing -> splitedText.append(text);*/
            splitedText.append(text.length() == wordLengthForReplacing ? "=====Java=====" : textBlockType + "=" + text+"|");
            //splitedText.append(text.length() == wordLengthForReplacing ? "=====Java=====" : text);
    }
}
