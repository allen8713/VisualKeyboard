import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class VisualKeyboardFrame extends JFrame implements KeyListener {

    // List to store all buttons representing keys
    private final ArrayList<JButton> Buttons;

    // String containing most keys on a standard keyboard
    private final String keys = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

    public VisualKeyboardFrame(){
        super("VisualKeyboard"); // Set window title
        this.setLayout(null); // Use absolute layout

        // Create a label for instructions
        JLabel prompts = new JLabel("<html>Type Some test using your keyboard. The keys you press will be highlighted and the text will be displayed<br>Note: Clicking the buttons with your mouse will not perform any action<br></html>");
        prompts.setBounds(20,10,800,40);
        add(prompts);

        // Create a text area for user input
        JTextArea inputarea = new JTextArea(10, 20);
        inputarea.setLineWrap(true); // Wrap lines

        // Add scroll pane to the text area
        JScrollPane s = new JScrollPane(inputarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        s.setBounds(20,50,810,200);
        add(s);

        // Initialize button list
        Buttons = new ArrayList<>();
        addButtons(); // Add all key buttons

        // Attach key listener to the text area
        inputarea.addKeyListener(this);
    }

    private void addButtons(){
        // Add standard keys row by row
        for(int i=0;i<13;i++){
            Buttons.add(new JButton(String.valueOf(keys.charAt(i))));
            Buttons.get(i).setBounds(20+55*i,260,50,50);
            add(Buttons.get(i));
        }
        for(int i=13;i<26;i++){
            Buttons.add(new JButton(String.valueOf(keys.charAt(i))));
            Buttons.get(i).setBounds(95+55*(i-13),315,50,50);
            add(Buttons.get(i));
        }
        for(int i=26;i<37;i++){
            Buttons.add(new JButton(String.valueOf(keys.charAt(i))));
            Buttons.get(i).setBounds(95+55*(i-26),370,50,50);
            add(Buttons.get(i));
        }
        for(int i=37;i<47;i++){
            Buttons.add(new JButton(String.valueOf(keys.charAt(i))));
            Buttons.get(i).setBounds(130+55*(i-37),425,50,50);
            add(Buttons.get(i));
        }

        // Add special keys
        Buttons.add(new JButton("Backspace")); // index 47
        Buttons.get(47).setBounds(735,260,100,50);
        add(Buttons.get(47));

        Buttons.add(new JButton("Tab")); // index 48
        Buttons.get(48).setBounds(20,315,70,50);
        add(Buttons.get(48));

        Buttons.add(new JButton("Caps")); // index 49
        Buttons.get(49).setBounds(20,370,70,50);
        add(Buttons.get(49));

        Buttons.add(new JButton("Enter")); // index 50
        Buttons.get(50).setBounds(700,370,105,50);
        add(Buttons.get(50));

        Buttons.add(new JButton("Shift")); // index 51
        Buttons.get(51).setBounds(20,425,105,50);
        add(Buttons.get(51));

        Buttons.add(new JButton("^")); // index 52 (up arrow)
        Buttons.get(52).setBounds(700,425,50,50);
        add(Buttons.get(52));

        Buttons.add(new JButton(" ")); // index 53 (space)
        Buttons.get(53).setBounds(240,480,325,50);
        add(Buttons.get(53));

        Buttons.add(new JButton("<")); // index 54 (left arrow)
        Buttons.get(54).setBounds(645,480,50,50);
        add(Buttons.get(54));

        Buttons.add(new JButton("v")); // index 55 (down arrow)
        Buttons.get(55).setBounds(700,480,50,50);
        add(Buttons.get(55));

        Buttons.add(new JButton(">")); // index 56 (right arrow)
        Buttons.get(56).setBounds(755,480,50,50);
        add(Buttons.get(56));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        Color mycolor = new Color(255,182,193); // Highlight color (pink)

        // Highlight special keys
        if(code==KeyEvent.VK_BACK_SPACE) Buttons.get(47).setBackground(mycolor);
        else if(code==KeyEvent.VK_TAB) Buttons.get(48).setBackground(mycolor);
        else if(code==KeyEvent.VK_CAPS_LOCK) Buttons.get(49).setBackground(mycolor);
        else if(code==KeyEvent.VK_ENTER) Buttons.get(50).setBackground(mycolor);
        else if(code==KeyEvent.VK_SHIFT) Buttons.get(51).setBackground(mycolor);
        else if(code==KeyEvent.VK_SPACE) Buttons.get(53).setBackground(mycolor);
        else if(code==KeyEvent.VK_UP) Buttons.get(52).setBackground(mycolor);
        else if(code==KeyEvent.VK_LEFT) Buttons.get(54).setBackground(mycolor);
        else if(code==KeyEvent.VK_DOWN) Buttons.get(55).setBackground(mycolor);
        else if(code==KeyEvent.VK_RIGHT) Buttons.get(56).setBackground(mycolor);
        else {
            // Highlight regular alphanumeric keys
            char c = Character.toUpperCase(e.getKeyChar());
            int idx = keys.indexOf(c);
            if(idx != -1){
                Buttons.get(idx).setBackground(mycolor);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Reset background for special keys
        if(code==KeyEvent.VK_BACK_SPACE) Buttons.get(47).setBackground(null);
        else if(code==KeyEvent.VK_TAB) Buttons.get(48).setBackground(null);
        else if(code==KeyEvent.VK_CAPS_LOCK) Buttons.get(49).setBackground(null);
        else if(code==KeyEvent.VK_ENTER) Buttons.get(50).setBackground(null);
        else if(code==KeyEvent.VK_SHIFT) Buttons.get(51).setBackground(null);
        else if(code==KeyEvent.VK_SPACE) Buttons.get(53).setBackground(null);
        else if(code==KeyEvent.VK_UP) Buttons.get(52).setBackground(null);
        else if(code==KeyEvent.VK_LEFT) Buttons.get(54).setBackground(null);
        else if(code==KeyEvent.VK_DOWN) Buttons.get(55).setBackground(null);
        else if(code==KeyEvent.VK_RIGHT) Buttons.get(56).setBackground(null);
        else {
            // Reset background for regular keys
            char c = Character.toUpperCase(e.getKeyChar());
            int idx = keys.indexOf(c);
            if(idx != -1){
                Buttons.get(idx).setBackground(null);
            }
        }
    }
}
