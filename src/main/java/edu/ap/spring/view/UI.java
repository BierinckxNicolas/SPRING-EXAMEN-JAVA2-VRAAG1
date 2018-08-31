package edu.ap.spring.view;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {


	@Autowired
	EventHandler eventHandler;

	private JFrame jFrame;
	private JFrame jFrame1;
	private JPanel controlPanel;
	private JPanel controlPanel1;
	private JButton btnQuestion;
    private JButton btnQuestion1;
    private JLabel label1, answerLabel;
    private JTextField quote;

	public UI() {}

	public void setupUI() {
		jFrame = new JFrame("Quotes");
		jFrame1 = new JFrame("Search Quotes");
		jFrame.setLayout(new FlowLayout());
        jFrame1.setLayout(new FlowLayout());

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 1));
		controlPanel1 = new JPanel();
        controlPanel1.setLayout(new GridLayout(2, 2));

        label1 = new JLabel("Quote : ");
        quote = new JTextField(15);

        answerLabel = new JLabel("");

		btnQuestion = new JButton();
		btnQuestion.setText("Read file and save quotes");
		btnQuestion.addActionListener(eventHandler::whenButtonClicked);

        btnQuestion1 = new JButton();
        btnQuestion1.setText("Search quotes");
        btnQuestion1.addActionListener(eventHandler::whenButton1Clicked);

		controlPanel.add(btnQuestion);

        controlPanel1.add(label1);
        controlPanel1.add(quote);
        controlPanel1.add(btnQuestion1);
        controlPanel1.add(answerLabel);



		jFrame.add(controlPanel);
		jFrame1.add(controlPanel1);

		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);

        jFrame1.setSize(400, 400);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.pack();
        jFrame1.setVisible(true);
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

    public JFrame getjFrame1() {
        return jFrame1;
    }

    public void setjFrame1(JFrame jFrame1) {
        this.jFrame1 = jFrame1;
    }


	public JButton getBtnQuestion() {
        return btnQuestion;
    }

    public void setBtnQuestion(JButton btnQuestion) {
        this.btnQuestion = btnQuestion;
    }

    public JButton getBtnQuestion1() {
        return btnQuestion1;
    }

    public void setBtnQuestion1(JButton btnQuestion1) {
        this.btnQuestion1 = btnQuestion1;
    }

    public JLabel getAnswerLabel() {
        return answerLabel;
    }

    public void setAnswerLabel(JLabel answerLabel) {
        this.answerLabel = answerLabel;
    }

    public JTextField getQuote() {
        return quote;
    }

    public void setQuote(JTextField quote) {
        this.quote = quote;
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
