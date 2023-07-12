package Fixture;

import com.example.appmotel.feign.QuartosFeing;
import com.example.appmotel.model.Quartos;
import com.example.appmotel.response.StatusDoQuarto;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;


public class QuartosFixture {
    @Mock
    QuartosFeing quartosFeing;
    Long entrada_id = 1L;
    Quartos quarto = quartosFeing.findById(entrada_id);
    public static Quartos quartoDisponivel(){
        return new Quartos()
    }
    public static Quartos quartoOcupado(){
        return new Quartos(
                2L,
                1,
                "qarto rgb",
                2,
                StatusDoQuarto.OCUPADO
        );
    }
    public static Quartos quartoReservado(){
        return new Quartos(
                2L,
                1,
                "qarto rgb",
                2,
                StatusDoQuarto.RESERVADO
        );
    }
    public static Quartos quartoSujo(){
        return new Quartos(
                2L,
                1,
                "qarto rgb",
                2,
                StatusDoQuarto.NECESSITA_LIMPEZA
        );
    }
    public static List<Quartos> quartosList (){
        List<Quartos> quartosList = new ArrayList<>();
        quartosList.add(quartoOcupado());
        return quartosList;
    }
}
