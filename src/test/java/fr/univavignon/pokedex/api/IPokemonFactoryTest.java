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
        pf = new PokemonFactory();
        //pf = new RocketPokemonFactory();
        //tt = pf.createPokemon(0,10,100,1,1);
        tt = pf.createPokemon(0,613,64,4000,4);

        //when(pf.createPokemon(0,613,64,4000,4)).thenReturn(tt);
        bulb = pf.createPokemon(0,613,64,4000,4);
    }


    @Test
    public void shouldReturnBelow15Stats(){
        Pokemon test = pf.createPokemon(0,1000,1000,4000,4);
        assertTrue(test.getAttack() < 15);
    }
    @Test
    public void shouldReturnNull(){
        Pokemon test = pf.createPokemon(-1,1000,1000,1000,4);
        assertNull(test);
    }
    @Test
    public void atkBetween0and15(){
        assertTrue(tt.getAttack()<15 && tt.getAttack()>0);
    }
    @Test
    public void defBetween0and15(){
        assertTrue(tt.getDefense()<15 && tt.getDefense()>0);
    }
    @Test
    public void staBetween0and15(){
        assertTrue(tt.getStamina()<15 && tt.getStamina()>0);
    }
    @Test
    public void shouldReturnName(){
            assertEquals(tt.getName(),bulb.getName());
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