package es.ies.puerto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.ies.puerto.model.UsuarioServiceModel;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceModelTest {

    @Mock
    private UsuarioServiceModel usuarioServiceModel;


    @BeforeEach
    void setUp() {
        //usuarioServiceModel = new UsuarioServiceModel();
        //when(metodo).thenReturn(valor);
        System.out.println("valor de usuario: " + usuarioServiceModel);
    }

    @Test
    void miTest(){
        System.out.println("Soy el primer test");
    }
    
}