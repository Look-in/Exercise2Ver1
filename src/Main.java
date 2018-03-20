import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	final static String TEXT = "Программы на Java транслируются в байт-код Java, выполняемый виртуальной машиной Java (JVM). "
			+ "Программой, обрабатывающей байтовый код и передающей " + "инструкции оборудованию как   интерпретатор.\n"
			+ "Достоинством подобного      способа выполнения программ является полная независимость байт-кода "
			+ "от операционной системы и оборудования, что позволяет выполнять Java-приложения на любом "
			+ "устройстве, для которого dfr2@gmail.com   существует соответствующая виртуальная машина.\nДругой важной "
			+ "особенностью технологии   Java является гибкая система безопасности, в рамках которой исполнение "
			+ "программы полностью    контролируется виртуальной машиной. Любые операции, которые превышают установленные "
			+ "полномочия программы (например, попытка несанкционированного доступа к данным или соединения с другим "
			+ "компьютером), вызывают немедленное прерывание.\n";

	private static void fillSentenceBlock(Block textBlock, List<SentenceBlockType> parts) {
		if (!parts.isEmpty()) {
			textBlock.splitBlock(parts.get(0));
			// parts.remove(0);
			// System.out.println(block.size());
			List<Block> blocks = textBlock.getBlocks();
			for (Block block : blocks) {
				block.splitBlock(parts.get(0));
				System.out.println(parts.get(0));
				System.out.println(block.getText());
				// parts.remove(0);
				fillSentenceBlock(block, parts);
			}

		}
	}

	public static void main(String[] args) {
		Block text = new Block(SentenceBlockType.TEXT, TEXT);

		List<SentenceBlockType> parts = new LinkedList<>();
		parts.add(SentenceBlockType.PARAGRAPH);
		parts.add(SentenceBlockType.SENTENCE);
		parts.add(SentenceBlockType.WORD);
		List<Block> textblock;
		List<Block> sentences;
		List<Block> words;

		// fillSentenceBlock(text, parts);
		text.splitBlock(SentenceBlockType.PARAGRAPH);
		textblock = text.getBlocks();
		for (Block block : textblock) {
			block.splitBlock(SentenceBlockType.SENTENCE);
			sentences = block.getBlocks();
			for (Block sentence : sentences) {
				sentence.splitBlock(SentenceBlockType.WORD);
				words = sentence.getBlocks();
				/*for (Block word : words) {
					System.out.println(word.getSentenceBlockType() + " " + word.getText());
				}*/

			}

		}

	}
}
