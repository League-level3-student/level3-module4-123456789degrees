package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	static Stack<String> words = new Stack<String>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setSize(600, 600);
		panel.add(label);
		frame.add(panel);
		String s = JOptionPane.showInputDialog("Enter the number of words: ");
		int num = Integer.parseInt(s);
		for (int i = 0; i < num; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(word)) {
				words.add(word);
			}
		}
	}
}
