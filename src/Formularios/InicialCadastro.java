package Formularios;

import javax.swing.*;
import java.awt.event.*;

public class InicialCadastro extends JDialog {
    private JPanel contentPane;

    private JButton buttonCancel;
    private JButton btnCadAgendamento;
    private JButton btnVerAgendamento;

    public InicialCadastro() {
        setContentPane(contentPane);
        setModal(true);


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCadAgendamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var telaInicial = new FormCadAgendamento();
                telaInicial.pack();
                telaInicial.setVisible(true);
            }
        });
        btnVerAgendamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnVerAgendamento();
            }
        });
    }
    private void onBtnVerAgendamento(){
        var telaVerAgendamentos = new FormVerAgendamentos();
        telaVerAgendamentos.pack();
        telaVerAgendamentos.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        InicialCadastro dialog = new InicialCadastro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
