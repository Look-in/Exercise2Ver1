package code;

public class Main {


    public static void main(String[] args) {
        //Reading text from file
        String textFile = FileToStringReader.readStringFromFile("text.txt");
        //Creating new parent object with type Text
        Block textBlock = new Block(SentenceBlockType.TEXT, textFile);
        textBlock.setWordLengthForReplacing(6);
        //õõõ-sentenceBlockType - depth of textParts for recursion
        SentenceBlockType beginSentenceBlockType=SentenceBlockType.PARAGRAPH;
        SentenceBlockType endSentenceBlockType=SentenceBlockType.WORD;
        textBlock.split(beginSentenceBlockType,endSentenceBlockType);
        StringBuilder modified=new StringBuilder();
        //Reading text from Blocks
        textBlock.collect(modified, endSentenceBlockType);
        //Regex for replacing 2 or more whitespaces
        System.out.println(modified.toString().replaceAll("( )+", " "));
    }
}
