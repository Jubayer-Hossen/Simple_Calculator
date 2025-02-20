import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton, subButton, mulButton, divButton, modButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Arial",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 860);
		frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

		textfield = new JTextField();
		textfield.setBounds(0, 0, 480, 320);
		textfield.setFont(myFont);
		textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
		textfield.setBorder(BorderFactory.createEmptyBorder());

		addButton = new JButton("+");
		subButton = new JButton("–");
		mulButton = new JButton("×");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("<=");
		clrButton = new JButton("AC");
		negButton = new JButton("(-)");
		modButton = new JButton("%");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = modButton;

		for(int i = 0; i<10; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			if (i <= 3 || i == 5){
				styleButton(functionButtons[i], Color.ORANGE);
			}
			else if (7 <= i && i <= 9){
				styleButton(functionButtons[i], Color.lightGray);
			}
			else{
				styleButton(functionButtons[i], Color.darkGray);
			}
		}

		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			styleButton(numberButtons[i], Color.DARK_GRAY);
		}

		panel = new JPanel();
		panel.setBounds(10, 320, 465, 490);
		panel.setLayout(new GridLayout(5,4,10,10));
		panel.setBackground(Color.BLACK);

		panel.add(clrButton);
		panel.add(negButton);
		panel.add(modButton);
		panel.add(divButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(delButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);

		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==modButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='%';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			case'%':
				result=num1%num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
	private void styleButton(JButton button, Color bgColor) {
        button.setFont(myFont);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);

        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(Color.GRAY);
                g.fillOval(0, 0, b.getWidth(), b.getHeight());
            }

            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bgColor);
                g2.fillOval(0, 0, c.getWidth(), c.getHeight());
                super.paint(g, c);
                g2.dispose();
            }
        });
    }
}