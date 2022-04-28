package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class IPokedexTest {


    IPokedex pokedex;
    Pokemon tt;
    PokemonMetadata pmt;

    @Before
    public void setup() throws Exception{
            pokedex = mock(IPokedex.class);
            tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
            when(pokedex.getPokemon(0)).thenReturn(tt);
            pmt = new PokemonMetadata(0,"Bulbizare",126,126,90);
            when(pokedex.getPokemonMetadata(0)).thenReturn(pmt);
           // pokedex.addPokemon(tt);
    }


    @Test
    public void shouldReturnIndex(){
        try {
            assertEquals(pokedex.getPokemon(0).getIndex(),tt.getIndex());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnMetadataIndex(){
        try {
            PokemonMetadata pm = pokedex.getPokemonMetadata(0);
            assertEquals(pm.getIndex(),pmt.getIndex());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}