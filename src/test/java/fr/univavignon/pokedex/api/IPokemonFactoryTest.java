package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pf;
    private Pokemon tt;
    Pokemon bulb;

    @Before
    public void init(){
        pf = mock(IPokemonFactory.class);
        //tt = pf.createPokemon(0,10,100,1,1);
        tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
        when(pf.createPokemon(0,613,64,4000,4)).thenReturn(tt);
        bulb = pf.createPokemon(0,613,64,4000,4);
    }

    @Test
    public void shouldReturnIndex(){
        assertEquals(tt.getIndex(),bulb.getIndex());
    }
    @Test
    public void shouldReturnCp(){
        assertEquals(tt.getCp(),bulb.getCp());
    }
    @Test
    public void shouldReturnHp(){
        assertEquals(tt.getHp(),bulb.getHp());
    }
    @Test
    public void shouldReturnCandy(){
        assertEquals(tt.getCandy(),bulb.getCandy());
    }
    @Test
    public void shouldReturnDust(){
        assertEquals(tt.getDust(),bulb.getDust());
    }


}