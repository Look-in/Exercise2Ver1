import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    private final static List<SentenceBlockType> parts = new ArrayList<>(Arrays.asList(
            SentenceBlockType.PARAGRAPH,
            SentenceBlockType.SENTENCE,
            SentenceBlockType.WORD));

    final static String TEXT = "Программы на Java транслируются в байт-код Java, выполняемый виртуальной машиной Java (JVM). "
            + "Программой, обрабатывающей байтовый код и передающей " + "инструкции оборудованию как   интерпретатор.\n"
            + "Достоинством подобного      способа выполнения программ является полная независимость байт-кода "
            + "от операционной системы и оборудования, что позволяет выполнять Java-приложения на любом "
            + "устройстве, для которого dfr2@gmail.com   существует соответствующая виртуальная машина.\nДругой важной "
            + "особенностью технологии   Java является гибкая система безопасности, в рамках которой исполнение "
            + "программы полностью    контролируется виртуальной машиной. Любые операции, которые превышают установленные "
            + "полномочия программы (например, попытка несанкционированного доступа к данным или соединения с другим "
            + "компьютером), вызывают немедленное прерывание.\n";

    private static void fillSentenceBlock(Block textBlock, int partNumber) {
        if (partNumber < parts.size()) {
            splitBlock(textBlock, parts.get(partNumber - 1));
            List<Block> blocks = textBlock.getBlocks();
            for (Block block : blocks) {
                splitBlock(block, parts.get(partNumber));
                System.out.println(" " + block.getSentenceBlockType() + "<" + block.getText() + ">");
                fillSentenceBlock(block, partNumber++);
            }
        }
    }

    public static void splitBlock(Block block, SentenceBlockType sentenceBlockType) {
        if (sentenceBlockType == SentenceBlockType.WORD) {
            StringTokenizer tokenizer = new StringTokenizer(block.getText(), sentenceBlockType.getRegex(), true);
            String token;
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                if (token.matches(SentenceBlockType.EMAIL.getRegex())) {
                    block.addBlock(new Block(SentenceBlockType.EMAIL, token));
                } else {
                    if (token.matches(sentenceBlockType.getRegex())) {
                        block.addBlock(new Block(SentenceBlockType.MARKER, token));
                    } else {
                        block.addBlock(new Block(SentenceBlockType.WORD, token));
                    }
                }
            }
        } else {
            Pattern ptn = Pattern.compile(sentenceBlockType.getRegex());
            for (String reg : ptn.split(block.getText())) {
                if (reg.length() > 0)
                    block.addBlock(new Block(sentenceBlockType, reg));
            }
        }
    }

    public static void main(String[] args) {
        Block text = new Block(SentenceBlockType.TEXT, TEXT);
        //  fillSentenceBlock(text, 1);
        List<SentenceBlockType> parts = new LinkedList<>();
        List<Block> textblock;
        List<Block> sentences;
        List<Block> words;
        splitBlock(text, SentenceBlockType.PARAGRAPH);
        textblock = text.getBlocks();
        for (Block block : textblock) {
            splitBlock(block, SentenceBlockType.SENTENCE);
            sentences = block.getBlocks();
            for (Block sentence : sentences) {
                splitBlock(sentence, SentenceBlockType.WORD);
                words = sentence.getBlocks();
                for (Block word : words) System.out.println(word.getSentenceBlockType() + " <" + word.getText() + ">");
            }

        }

    }
}
