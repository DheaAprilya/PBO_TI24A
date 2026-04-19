import javax.swing.JOptionPane;

public class DialogInput {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
            null,
            "Anda sedang belajar apa?",
            "Input",
            JOptionPane.QUESTION_MESSAGE
        );

        if (input != null) {
            JOptionPane.showMessageDialog(
                null,
                "Belajar " + input + " sangat mudah",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}