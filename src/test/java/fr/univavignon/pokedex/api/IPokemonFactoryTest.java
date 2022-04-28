package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pf;
    private Pokemon tt;
    //Pokemon bulb = mock(Pokemon.class);

    @Before
    public void init(){
        pf = new RocketPokemonFactory();
        //tt = pf.createPokemon(0,10,100,1,1);
        tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);

    }

    @Test
    public void shouldReturn0(){
        assertEquals(tt.getIndex(),0);
    }
    @Test
    public void shouldReturn613(){
        assertEquals(tt.getCp(),613);
    }
    @Test
    public void shouldReturn64(){
        assertEquals(tt.getHp(),64);
    }
    @Test
    public void shouldReturn4and4000(){
        assertEquals(tt.getCandy(),4);
        assertEquals(tt.getDust(),4000);
    }


    @Test
    public void shouldReturnBetween0and200(){
            assertTrue(tt.getAttack() < 200 && tt.getAttack() > 0);
    }



}