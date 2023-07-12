package Fixture;

import com.example.appmotel.model.Entradas;
import com.example.appmotel.response.StatusEntrada;
import com.example.appmotel.response.StatusPagamento;
import com.example.appmotel.response.TipoPagamento;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EntradasFixture {
    public static Entradas entradas(){
        return new Entradas(
                1L,
                QuartosFixture.quartoDisponivel(),
                LocalTime.now(),
                LocalTime.now().plusHours(2),
                "abc1234",
                TipoPagamento.CARTAO,
                StatusPagamento.CONCLUIDO,
                StatusEntrada.FINALIZADA
        );
    }

    public static Entradas entradasEmAndamento(){
        return new Entradas(
                1L,
                QuartosFixture.quartoDisponivel(),
                LocalTime.now(),
                LocalTime.now().plusHours(2),
                "abc1234",
                TipoPagamento.PENDENTE,
                StatusPagamento.PENDENTE,
                StatusEntrada.EM_ANDAMENTO
        );
    }
    public static Entradas entradasEmAndamentoWithLongHours(){
        return new Entradas(
                1L,
                QuartosFixture.quartoDisponivel(),
                LocalTime.now(),
                LocalTime.now().plusHours(5),
                "abc1234",
                TipoPagamento.PIX,
                StatusPagamento.CONCLUIDO,
                StatusEntrada.EM_ANDAMENTO
        );
    }
    public static Entradas entradasEmAndamentoWithLongHoursDInheiro(){
        return new Entradas(
                1L,
                QuartosFixture.quartoDisponivel(),
                LocalTime.now(),
                LocalTime.now().plusHours(5),
                "abc1234",
                TipoPagamento.DINHEIRO,
                StatusPagamento.CONCLUIDO,
                StatusEntrada.EM_ANDAMENTO
        );
    }

    public static List<Entradas> entradasList (){
        List<Entradas> entradasList = new ArrayList<>();
        entradasList.add(entradas());
        return entradasList;
    }
}
