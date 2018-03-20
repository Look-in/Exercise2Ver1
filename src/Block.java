import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

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

	public void splitBlock(SentenceBlockType sentenceBlockType) {

		if (sentenceBlockType == SentenceBlockType.WORD) {
			// StringBuilder modifySentence = new StringBuilder(text.length());
			// разбиение строки на отдельные литералы
			StringTokenizer tokenizer = new StringTokenizer(text, sentenceBlockType.getRegex(), true);
			String token;
			while (tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();
				if (token.matches(SentenceBlockType.EMAIL.getRegex())) {
					blocks.add(new Block(SentenceBlockType.EMAIL, token));
				} else {
					if (token.matches(sentenceBlockType.getRegex())) {
						blocks.add(new Block(SentenceBlockType.MARKER, token));
					} else {
						blocks.add(new Block(SentenceBlockType.WORD, token));
					}

				}
			}
		} else {
			Pattern ptn = Pattern.compile(sentenceBlockType.getRegex());
			for (String reg : ptn.split(text)) {
				if (reg.length() > 0)
					blocks.add(new Block(sentenceBlockType, reg));
			}
		}
	}


}
