package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory ptf = mock(IPokemonTrainerFactory.class);
    IPokedexFactory pf = mock(IPokedexFactory.class);
    IPokedex pokedex = mock(IPokedex.class);
    PokemonTrainer pt;

    @Before
    public void init(){
        pt = new PokemonTrainer("Bonjour",Team.MYSTIC,pokedex);
        when(ptf.createTrainer("Bonjour",Team.MYSTIC,pf)).thenReturn(pt);

    }

    @Test
    public void shouldReturnName(){
        PokemonTrainer test = ptf.createTrainer("Bonjour",Team.MYSTIC,pf);
        assertEquals(pt.getName(),test.getName());
    }

    @Test
    public void shouldReturnTeam(){
        PokemonTrainer test = ptf.createTrainer("Bonjour",Team.MYSTIC,pf);
        assertEquals(pt.getTeam(),test.getTeam());
    }


}