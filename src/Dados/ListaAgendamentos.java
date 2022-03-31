package Dados;

import Modelos.AgendamentoCadastrado;

import java.util.ArrayList;
import java.util.List;

public class ListaAgendamentos {

    private static List<AgendamentoCadastrado> _listaAgendamento = new ArrayList<>();

    public static List<AgendamentoCadastrado> retornaTodos(){
        return _listaAgendamento;
    }

    public static void adicionarAgendamento(AgendamentoCadastrado agendamento){
        _listaAgendamento.add(agendamento);
    }





    public static AgendamentoCadastrado get(int indice) {
        return new AgendamentoCadastrado();
    }

}

