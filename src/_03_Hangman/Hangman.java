package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	static Stack<String> words = new Stack<String>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	static int lives = 10;
	static String s;
	public static void main(String[] args) {
		new Hangman().run();
	}
	public void run() {
		frame.setVisible(true);
		frame.setSize(150,75);
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		String q = JOptionPane.showInputDialog("Enter the number of words: ");
		int num = Integer.parseInt(q);
		for (int i = 0; i < num; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(word)) {
				words.add(word);
			}
		}
		s = words.pop();
		for (int i = 0; i < s.length(); i++) {
			label.setText(label.getText()+"_");
		}
		label.setText(label.getText() + " Lives: " + lives);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String s2 = label.getText();
		String check = s;
		int count = 0;
		for (int i = 0; i < check.length(); i++) {
			if (arg0.getKeyChar() == check.charAt(i)) {
				s2 = s2.substring(0, i) + check.charAt(i) + s2.substring(i+1);
				label.setText(s2);
				count++;
			}
		}
		if (count == 0) {
			lives--;
			if (lives == 0) {
				JOptionPane.showMessageDialog(null, "Ran out of lives. The hidden word was: " + s);
				String again = JOptionPane.showInputDialog("Do you want to play again?");
				if (again.toLowerCase().equals("yes")) {
					new Hangman().run();
				}
			}
			String x = label.getText();
			int a = x.indexOf(":");
			x = x.substring(0, a+1) + " " + lives;
			label.setText(x);
		}
	}
}
