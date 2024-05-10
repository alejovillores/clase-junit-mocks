package org.algo3;



import org.algo3.modelo.*;
import org.algo3.modelo.invitado.Invitado;
import org.algo3.modelo.proveedor.Proveedor;
import org.algo3.modelo.tiempo.Tiempo;
import org.junit.*;
//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

public class YayoTest {

    @BeforeClass
    public static void beforeAll(){
        System.out.println("BEFORE ALL - Esta funcion se corre antes de correr todos los test");
    }

    // ATENCION - static
    @Before
    public void beforeEach(){
        System.out.println("BEFORE EACH - Esta funcion se corre antes de correr cada uno de los test!");
    }

    // ATENCION - static
    @AfterClass
    public static void afterAll(){
        System.out.println("AFTER ALL - Esta funcion se corre luego de correr todos los test");
    }

    @After
    public void afterEach(){
        System.out.println("AFTER EACH - Esta funcion se corre luego de correr cada uno de los test!");
    }

    @Test
    public void cuandoSeInstanciaYayoNoTieneChistes(){
        // Arrange
        Proveedor proovedorMock = mock(Proveedor.class);
        Invitado invitadoMock = mock(Invitado.class);
        Yayo yayo = new Yayo(proovedorMock, invitadoMock);

        //Act
        ArrayList<Chiste> chistes = yayo.todosLosChistes();

        //Assert
        Assert.assertEquals(0, chistes.size());
    }

    @Test
    public void yayoCuentaUnChisteDeProgramacionEnEspanniolSiElDiaEsPar(){

        // Arrange
        Chiste chisteFalso = new Chiste("Programming","hola pepe","Hola jose");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Programming", "es")).thenReturn(chisteFalso);
        Invitado invitadoMock = mock(Invitado.class);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(2);

        Yayo yayo = new Yayo(proovedorStub, invitadoMock);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        Assert.assertTrue(chiste.tieneCategoria("Programming"));
    }

    @Test
    public void yayoInvocaAlProvedorParaSolicitarChisteDeProgramacion(){

        // Arrange
        Chiste chisteFalso = new Chiste("Programming","hola pepe","Hola jose");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Programming", "es")).thenReturn(chisteFalso);
        Invitado invitadoMock = mock(Invitado.class);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(2);
        Yayo yayo = new Yayo(proovedorStub, invitadoMock);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        verify(proovedorStub, times(1)).solicitarChiste("Programming", "es");
    }

    @Test
    public void yayoCuentaUnChisteDeNavidadEnInglesSiElDiaEsInpar(){

        // Arrange
        Chiste chisteFalso = new Chiste("Christmas","Hello pepe!","Hi Mark");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteFalso);
        Invitado invitadoMock = mock(Invitado.class);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(5);

        Yayo yayo = new Yayo(proovedorStub, invitadoMock);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        Assert.assertTrue(chiste.tieneCategoria("Christmas"));
    }

    @Test
    public void yayoInvocaAlProvedorParaSolicitarChisteDeNavidad(){

        // Arrange
        Chiste chisteFalso = new Chiste("Christmas","Hello pepe!","Hi Mark");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteFalso);
        Invitado invitadoMock = mock(Invitado.class);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(5);
        Yayo yayo = new Yayo(proovedorStub, invitadoMock);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        verify(proovedorStub, times(1)).solicitarChiste("Christmas", "en");
    }

    @Test
    public void yayoCuentaUnChisteMalisimo(){

        // Arrange
        Chiste chisteFalso = new Chiste("Christmas","Hello pepe!","Hi Mark");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteFalso);
        Invitado invitadoStub = mock(Invitado.class);
        when(invitadoStub.puntuar(chisteFalso)).thenReturn(2);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(5);

        Yayo yayo = new Yayo(proovedorStub, invitadoStub);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        Assert.assertTrue(chiste.esMalo());

    }

    @Test
    public void yayoCuentaUnChisteBuenisimo(){

        // Arrange
        Chiste chisteFalso = new Chiste("Christmas","Hello pepe!","Hi Mark");
        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteFalso);
        Invitado invitadoStub = mock(Invitado.class);
        when(invitadoStub.puntuar(chisteFalso)).thenReturn(10);
        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(5);

        Yayo yayo = new Yayo(proovedorStub, invitadoStub);


        //Act
        Chiste chiste = yayo.contarChiste(tiempoStub);

        //Assert
        Assert.assertFalse(chiste.esMalo());

    }

    @Test
    public void seObtienenLosMejoresChistesDeYayoCorrectamente(){
        // Arrange
        Chiste chisteMalo = new Chiste("Programming","Hello pepe!","Hello pepe!");
        Chiste chisteBueno = new Chiste("Christmas","Hello pepe!","Hi Mark");

        Invitado invitadoStub = mock(Invitado.class);
        when(invitadoStub.puntuar(chisteMalo)).thenReturn(4);
        when(invitadoStub.puntuar(chisteBueno)).thenReturn(9);

        Proveedor proovedorStub = mock(Proveedor.class);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteMalo);


        Tiempo tiempoStub = mock(Tiempo.class);
        when(tiempoStub.obtenerDiaDeHoy()).thenReturn(5);

        Yayo yayo = new Yayo(proovedorStub, invitadoStub);

        int cantidadChistesBuenosEsperados = 5;
        //Act
        yayo.contarChiste(tiempoStub);
        yayo.contarChiste(tiempoStub);
        yayo.contarChiste(tiempoStub);
        yayo.contarChiste(tiempoStub);
        when(proovedorStub.solicitarChiste("Christmas", "en")).thenReturn(chisteBueno);
        yayo.contarChiste(tiempoStub);
        yayo.contarChiste(tiempoStub);
        yayo.contarChiste(tiempoStub);
        List<Chiste> chistes = yayo.mejoresChistes(cantidadChistesBuenosEsperados);

        //Assert con 5 chistes
        Assert.assertEquals(cantidadChistesBuenosEsperados, chistes.size());

        cantidadChistesBuenosEsperados = 3;
        chistes = yayo.mejoresChistes(cantidadChistesBuenosEsperados);
        //Assert con 3 chistes
        Assert.assertEquals(cantidadChistesBuenosEsperados, chistes.size());

    }

    @Ignore("Test es ignorado")
    @Test
    public void testSame() {
        Assert.assertEquals(1, 1);
    }
}
