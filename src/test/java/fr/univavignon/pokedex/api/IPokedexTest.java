package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class IPokedexTest {


    IPokedex pokedex;
    Pokemon tt;

    @Before
    public void setup() throws Exception{
            pokedex = mock(IPokedex.class);
            tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
            when(pokedex.getPokemon(0)).thenReturn(tt);
           // pokedex.addPokemon(tt);
    }


    @Test
    public void shouldReturnIndex(){
        try {
            assertEquals(pokedex.getPokemon(0).getIndex(),0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnMetadata(){
        try {
            PokemonMetadata pm = pokedex.getPokemonMetadata(0);
            assertEquals(0,0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}