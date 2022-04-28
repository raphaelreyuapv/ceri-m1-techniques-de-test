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
    private RocketPokemonFactory rpf = new RocketPokemonFactory();
    @Before
    public void init(){
        pf = mock(IPokemonFactory.class);
        //tt = pf.createPokemon(0,10,100,1,1);
        tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
        when(pf.createPokemon(0,613,64,4000,4)).thenReturn(tt);
        bulb = pf.createPokemon(0,613,64,4000,4);
    }


    @Test
    public void shouldReturn1000stats(){
        Pokemon test = rpf.createPokemon(-1,1000,1000,4000,4);
        assertEquals(test.getAttack(),1000);
    }
    @Test
    public void shouldDefault(){
        Pokemon test = rpf.createPokemon(4,1000,1000,1000,4);
        assertEquals(test.getName(),"MISSINGNO");
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

    @Test
    public void shouldReturnPokemon(){
        assertEquals(rpf.createPokemon(0,613,64,4000,4).getIndex(),tt.getIndex());
    }


}