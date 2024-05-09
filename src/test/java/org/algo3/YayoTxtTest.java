package org.algo3;

import org.algo3.modelo.Chiste;
import org.algo3.modelo.Yayo;
import org.algo3.modelo.invitado.Invitado;
import org.algo3.modelo.proveedor.Proveedor;
import org.algo3.modelo.proveedor.ProveedorTxt;
import org.algo3.modelo.tiempo.Tiempo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
public class YayoTxtTest {

    @Mock private Proveedor proveedorMock;
    @Mock private Invitado invitadoMock;
    @Mock private Tiempo tiempoMock;

    private AutoCloseable closeable;

    @Before
    public void beforeEach(){
        closeable = MockitoAnnotations.openMocks(this);
        Mockito.reset(proveedorMock, invitadoMock, tiempoMock);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void yayoSolicitaAlProovedorTxtChistesDeProgramacion(){

        when(tiempoMock.obtenerDiaDeHoy()).thenReturn(2);
        Proveedor proveedorWeb = new ProveedorTxt();
        Yayo yayo = new Yayo(proveedorWeb, invitadoMock);

        Chiste chiste = yayo.contarChiste(tiempoMock);

        Assert.assertTrue(chiste.tieneCategoria("Programming"));
    }

    @Test
    public void yayoSolicitaAlProovedorTxtChistesDeNavidad(){

        when(tiempoMock.obtenerDiaDeHoy()).thenReturn(1);
        Proveedor proveedorWeb = new ProveedorTxt();
        Yayo yayo = new Yayo(proveedorWeb, invitadoMock);

        Chiste chiste = yayo.contarChiste(tiempoMock);

        Assert.assertTrue(chiste.tieneCategoria("Christmas"));
    }

    @Test
    public void losMejoresChistesDeYayo() {
        // Arrange
        Chiste chiste1 = new Chiste("Programming","hola pepe","Hola jose");
        Chiste chiste2 = new Chiste("Programming","hola pepe","Hola jose");
        Chiste chiste3 = new Chiste("Programming","hola pepe","Hola jose");
        Chiste chiste4 = new Chiste("Programming","hola pepe","Hola jose");
        Chiste chiste5 = new Chiste("Programming","hola pepe","Hola jose");

        when(YayoTxtTest.this.proveedorMock.solicitarChiste("Programming", "es")).thenReturn(chiste1);
        when(YayoTxtTest.this.proveedorMock.solicitarChiste("Programming", "es")).thenReturn(chiste2);
        when(YayoTxtTest.this.proveedorMock.solicitarChiste("Programming", "es")).thenReturn(chiste3);
        when(YayoTxtTest.this.proveedorMock.solicitarChiste("Programming", "es")).thenReturn(chiste4);
        when(YayoTxtTest.this.proveedorMock.solicitarChiste("Programming", "es")).thenReturn(chiste5);

        when(invitadoMock.puntuar(chiste1)).thenReturn(1);
        when(invitadoMock.puntuar(chiste2)).thenReturn(2);
        when(invitadoMock.puntuar(chiste3)).thenReturn(3);
        when(invitadoMock.puntuar(chiste4)).thenReturn(4);
        when(invitadoMock.puntuar(chiste5)).thenReturn(5);

        Yayo yayo = new Yayo(YayoTxtTest.this.proveedorMock, invitadoMock);
        
        List<Chiste> mejoresChistesEsperados = Arrays.asList(chiste5, chiste4, chiste3);

        //Act
        yayo.contarChiste(tiempoMock);
        yayo.contarChiste(tiempoMock);
        yayo.contarChiste(tiempoMock);
        yayo.contarChiste(tiempoMock);
        yayo.contarChiste(tiempoMock);

        //Assert
        Assert.assertTrue(mejoresChistesEsperados.containsAll(yayo.mejoresChistes(3)));
    }
















}
