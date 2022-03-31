package Formularios;

import Dados.ListaAgendamentos;
import Modelos.AgendamentoCadastrado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class FormVerAgendamentos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private DefaultTableModel model;

    public FormVerAgendamentos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

        private void createUIComponents () {
            // TODO: place custom component creation code here
            var listaAgendamentos = ListaAgendamentos.retornaTodos();
            CriarListaAgendamento(listaAgendamentos);
        }


        private void CriarListaAgendamento (List<AgendamentoCadastrado> listaAgendamento) {
            if (table1 == null)
                table1 = new JTable();
            if (model == null) {
                model = new DefaultTableModel() {
                    @Override
                    public int getColumnCount() {
                        return 4;
                    }
                }; // essa llnnha é para a quantidde de coluinas
            }
            model.getDataVector().removeAllElements();
            model.setColumnCount(0);
            if (listaAgendamento.stream().count() > 0) // se for maior que 0 executa:
                model.addRow(new Object[]{"OS", "Data", "Cliente", "Equipamento"});
            listaAgendamento.forEach(agendamento -> model.addRow(new Object[]{agendamento.OrdemDeServiço, agendamento.Dia, agendamento.Cliente, agendamento.Equipamento}));
            table1.setModel(model);
            table1.revalidate();
        }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FormVerAgendamentos dialog = new FormVerAgendamentos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
