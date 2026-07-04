import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataMahasiswa extends JFrame {

    private JTextField fieldNim, fieldNama, fieldProdi;
    private JTextArea areaOutput;

    public BiodataMahasiswa() {
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));

        fieldNim = new JTextField();
        fieldNama = new JTextField();
        fieldProdi = new JTextField();

        panelInput.add(new JLabel("NIM"));
        panelInput.add(fieldNim);
        panelInput.add(new JLabel("Nama"));
        panelInput.add(fieldNama);
        panelInput.add(new JLabel("Program Studi"));
        panelInput.add(fieldProdi);

        // Panel Tombol
        JPanel panelTombol = new JPanel();
        JButton btnTampilkan = new JButton("Tampilkan");
        JButton btnReset = new JButton("Reset");
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // Area Output
        areaOutput = new JTextArea();
        areaOutput.setEditable(false);
        JScrollPane scrollOutput = new JScrollPane(areaOutput);
        scrollOutput.setBorder(BorderFactory.createTitledBorder("Output"));

        // Gabungin panel atas (input + tombol)
        JPanel panelAtas = new JPanel(new BorderLayout(10, 10));
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        add(panelAtas, BorderLayout.NORTH);
        add(scrollOutput, BorderLayout.CENTER);

        // Aksi tombol Tampilkan
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = fieldNim.getText();
                String nama = fieldNama.getText();
                String prodi = fieldProdi.getText();

                String hasil = "========== BIODATA MAHASISWA ==========\n\n";
                hasil += "NIM           : " + nim + "\n";
                hasil += "Nama          : " + nama + "\n";
                hasil += "Program Studi : " + prodi + "\n";

                areaOutput.setText(hasil);
            }
        });

        // Aksi tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldNim.setText("");
                fieldNama.setText("");
                fieldProdi.setText("");
                areaOutput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BiodataMahasiswa frame = new BiodataMahasiswa();
            frame.setVisible(true);
        });
    }
}