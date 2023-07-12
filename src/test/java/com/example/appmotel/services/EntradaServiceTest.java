package com.example.appmotel.services;

import Fixture.EntradaConsumoFixture;
import Fixture.EntradasFixture;
import Fixture.ItensFixture;
import com.example.appmotel.exceptions.EntityConflict;
import com.example.appmotel.exceptions.EntityNotFound;
import com.example.appmotel.feign.ItensFeing;
import com.example.appmotel.feign.MapaFeing;
import com.example.appmotel.feign.QuartosFeing;
import com.example.appmotel.model.EntradaConsumo;
import com.example.appmotel.model.Entradas;
import com.example.appmotel.model.Itens;
import com.example.appmotel.model.Quartos;
import com.example.appmotel.repository.EntradaConsumoRepository;
import com.example.appmotel.repository.EntradaRepository;
import com.example.appmotel.response.EntradaSimplesResponse;
import com.example.appmotel.response.StatusDoQuarto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class EntradaServiceTest {
    @Mock
    MapaFeing mapaFeing;
    @Mock
    QuartosFeing quartosFeing;
    @Mock
    ItensFeing itensFeing;
    @Mock
    EntradaConsumoService entradaConsumoService;
    @Mock
    EntradaRepository entradaRepository;
    @Mock
    EntradaConsumoRepository entradaConsumoRepository;
    Quartos quarto;



    @InjectMocks
    EntradaService entradaService;
    List<Entradas> entradasList = EntradasFixture.entradasList();
    Entradas entrada = EntradasFixture.entradas();
    Entradas entradaEmAndamento = EntradasFixture.entradasEmAndamento();
    Entradas entradasEmAndamentoWithLongHours = EntradasFixture.entradasEmAndamentoWithLongHours();
    Entradas entradasEmAndamentoWithLongHoursDinheiro = EntradasFixture.entradasEmAndamentoWithLongHoursDInheiro();
    Long entrada_id = 1L;
    List<EntradaConsumo> entradaConsumosList= EntradaConsumoFixture.entradaConsumoList();
    Itens itemVazio = ItensFixture.itenVazio();
    @Mock
    Pageable pageable;

    @Test
    @DisplayName("should return a page of all entradas")
    public void testFindAll() {
        Page<Entradas> pageMock = new PageImpl<>(entradasList);
        when(entradaRepository.findAll(pageable)).thenReturn(pageMock);
        Page<EntradaSimplesResponse> resultPage = entradaService.findAll(pageable);
        assertNotNull(resultPage);
        verify(entradaRepository, atLeastOnce()).findAll(pageable);
    }
    @Test
    @DisplayName("should return a entrada when using find by id")
    void findById() {
        when(entradaRepository.findById(entrada_id)).thenReturn(Optional.ofNullable(entrada));
        entradaService.findById(entrada_id);
        verify(entradaRepository, atLeastOnce()).findById(entrada_id);
    }

    @Test
    @DisplayName("should return a exception when entrada is null or empty")
    void findByIdException() {
        when(entradaRepository.findById(entrada_id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFound.class)
        .isThrownBy(()-> entradaService.findById(entrada_id))
        .withMessage("Entrada não foi Cadastrada ou não existe mais");
        verify(entradaRepository, atLeastOnce()).findById(entrada_id);
    }

    @Test
    void registerEntrada() {
        when(entradaRepository.save(any())).thenReturn(entrada);

        entradaService.registerEntrada(entrada);
    }

    @Test
    @DisplayName("deve lancar uma exception de quarto ocupado")
    void registerEntradaExceptionOcupado() {
        entrada.getQuartos().setStatusDoQuarto(StatusDoQuarto.OCUPADO);
        when(entradaRepository.save(any())).thenReturn(entrada);

        assertThatExceptionOfType(EntityConflict.class)
                .isThrownBy(()->entradaService.registerEntrada(entrada))
                .withMessage("Quarto Ocupado");
    }

    @Test
    @DisplayName("deve lancar uma exception de quarto Sujo")
    void registerEntradaExceptionLimpesa() {
        entrada.getQuartos().setStatusDoQuarto(StatusDoQuarto.NECESSITA_LIMPEZA);
        when(entradaRepository.save(any())).thenReturn(entrada);

        assertThatExceptionOfType(EntityConflict.class)
                .isThrownBy(()->entradaService.registerEntrada(entrada)).
                withMessage("Quarto Precisa de limpeza!");
    }
    @Test
    @DisplayName("deve lancar uma exception de quarto reservado")
    void registerEntradaExceptionReservado() {
        entrada.getQuartos().setStatusDoQuarto(StatusDoQuarto.RESERVADO);
        when(entradaRepository.save(any())).thenReturn(entrada);

        assertThatExceptionOfType(EntityConflict.class)
                .isThrownBy(()->entradaService.registerEntrada(entrada)).
                withMessage("Quarto Reservado!");
    }

    @Test
    void updateEntradaData() {
    }

    @Test
    void findByStatusEntrada() {
    }

    @Test
    void findEntradaByToday() {
    }

    @Test
    void findEntradaByDate() {
    }
}