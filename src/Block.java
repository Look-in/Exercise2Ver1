import java.util.ArrayList;
import java.util.List;

public class Block {

    private SentenceBlockType sentenceBlockType;

    private List<Block> blocks = new ArrayList<>();

    private String text;

    public Block(SentenceBlockType sentenceBlockType, String text) {
        this.sentenceBlockType = sentenceBlockType;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public SentenceBlockType getSentenceBlockType() {
        return sentenceBlockType;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

}
