package sample;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainDisplay extends JFrame {
    private JTextField length;
    private JButton Button;
    private JTextField password;
    private JPanel root;
    private static final char[] chars =  new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    private static final char[] symbols =  new char[]{'`', '~', '!', '@', '"', '#', '№', '$', ';', '%', '^', ':', '&', '?', '*', '(', ')', '-', '_', '+', '=', '{', '[', '}', ']', '\\', '|', '/', '<', ',', '>', '.'};

    public int myRandom(int min, int max){
        return (int) (Math.random() * ++max) + min;
    }

    public mainDisplay(){
        PlainDocument doc = (PlainDocument) length.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        add(root);
        pack();
        setTitle("Генератор паролей");

        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len = 8;
                StringBuilder pass = new StringBuilder();
                if(length.getText() != "")
                    len = Integer.parseInt(length.getText());

                if(len == 0)
                    len = 8;

                for (int i = 0; i < len; i++){
                    switch (myRandom(1, 2)){
                        case 1:
                            pass.append(myRandom(0, 9));
                            break;

                        case 2:
                            pass.append(symbols[myRandom(0, symbols.length-1)]);
                            break;

                        case 3:
                            if(myRandom(0, 1) == 1) {
                                pass.append(Character.toUpperCase(chars[myRandom(0, chars.length-1)]));
                            }else pass.append(chars[myRandom(0, chars.length-1)]);
                    }


                } password.setText("Пароль: " + pass.toString());
                pack();
            }
        });

    }
}
