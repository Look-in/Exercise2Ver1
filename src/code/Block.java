/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 * Integer wordLengthForReplacing - the length of words for replacing
 * Zero or a negative number - without replacement.
 * Also can use regex ->
 * sentence.replaceAll("\\b[A-Za-zР-пр-џ0-9]{"+modifyLength+"}\\b", toModify);
 * Collect - recursive method for reading text from the childblocks
 * Split - recursive method for placing text to the childblocks
 */

package code;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Block {

    private SentenceBlockType sentenceBlockType;

    private List<Block> blocks = new ArrayList<>();

    private String text;

    public Block(SentenceBlockType sentenceBlockType, String text) {
        this.sentenceBlockType = sentenceBlockType;
        this.text = text;
    }

    public void split(SentenceBlockType beginSentenceBlockType, SentenceBlockType endSentenceBlockType) {
        int partNumber = Parts.textParts.indexOf(beginSentenceBlockType);
        splitBlock(Parts.textParts.get(partNumber++));
        if (partNumber <= Parts.textParts.indexOf(endSentenceBlockType))
            for (Block block : blocks) block.split(Parts.textParts.get(partNumber), endSentenceBlockType);
    }

    private void splitBlock(SentenceBlockType sentenceBlockType) {
        if (sentenceBlockType == SentenceBlockType.WORD) {
            StringTokenizer tokenizer = new StringTokenizer(text, sentenceBlockType.getRegex(), true);
            String token;
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                for (SentenceBlockType kind : Parts.sentenceParts)
                    if (token.matches(kind.getRegex())) {
                        blocks.add(new Block(kind, token));
                        token = null;
                        break;
                    }
                if (token != null) blocks.add(new Block(sentenceBlockType, token));
            }
        } else
            for (String regex : text.split(sentenceBlockType.getRegex()))
                blocks.add(new Block(sentenceBlockType, regex));
    }

    public void collect(StringBuilder splitedText, SentenceBlockType endSentenceBlockType, int wordLengthForReplacing) {
        if (sentenceBlockType != endSentenceBlockType & !blocks.isEmpty())
            blocks.forEach(e -> e.collect(splitedText, endSentenceBlockType, wordLengthForReplacing));
        else
            /*Resolving the exercise N16 - replace each word length more than X with =====Java=====
              without replacing -> splitedText.append(text);*/
            //splitedText.append(text.length() == wordLengthForReplacing ? "=====Java=====" : sentenceBlockType + "=" + text);
            splitedText.append(text.length() == wordLengthForReplacing ? "=====Java=====" : text);
    }
}
