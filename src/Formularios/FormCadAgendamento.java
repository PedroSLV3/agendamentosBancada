package Formularios;

import Dados.ListaAgendamentos;
import Modelos.AgendamentoCadastrado;

import javax.swing.*;
import java.awt.event.*;

public class FormCadAgendamento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtOS;
    private JTextField txtCliente;
    private JTextField txtDia;
    private JTextField txtTecnico;
    private JTextField txtEquipamento;
    private JTextField txtServico;

    public FormCadAgendamento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnOkCadAgendamento();
            }
        });
    }
    private void onBtnOkCadAgendamento() {
    var agendamento = new AgendamentoCadastrado();
    agendamento.OrdemDeServiço = txtOS.getText();
    agendamento.Cliente = txtCliente.getText();
    agendamento.Dia = txtDia.getText();
    agendamento.TécnicoRecolheu = txtTecnico.getText();
    agendamento.Equipamento = txtEquipamento.getText();
    agendamento.ServicoSolicitado = txtServico.getText();
    ListaAgendamentos.adicionarAgendamento(agendamento);
    dispose();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FormCadAgendamento dialog = new FormCadAgendamento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
