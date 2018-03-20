package code;

public class Main {


    public static void main(String[] args) {
        //Reading text from file
        String textFile = FileToStringReader.readStringFromFile("text.txt");
        //Creating new parent object with type Text
        Block textBlock = new Block(TextBlockType.TEXT, textFile);
        //XXX-sentenceBlockType - depth of textParts for recursion
        TextBlockType beginSentenceBlockType= TextBlockType.PARAGRAPH;
        TextBlockType endSentenceBlockType= TextBlockType.WORD;
        textBlock.split(beginSentenceBlockType,endSentenceBlockType);
        StringBuilder modified=new StringBuilder();
        //Reading text from Blocks
        textBlock.collect(modified, endSentenceBlockType,4);
        //Regex for replacing 2 or more whitespaces
        System.out.println(modified.toString().replaceAll("( )+", " "));
    }
}
