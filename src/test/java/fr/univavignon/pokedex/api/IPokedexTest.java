package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class IPokedexTest {


    IPokedex pokedex;
    Pokemon tt;
    PokemonMetadata pmt;
    List listpoke = mock(List.class);

    @Before
    public void setup() throws Exception{
            pokedex = mock(IPokedex.class);
            tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
            when(pokedex.getPokemon(0)).thenReturn(tt);
            pmt = new PokemonMetadata(0,"Bulbizare",126,126,90);
            when(pokedex.getPokemonMetadata(0)).thenReturn(pmt);
            when(listpoke.size()).thenReturn(1);
            when(pokedex.size()).thenReturn(1);
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
    public void shouldReturnIv(){
        try {
            assertEquals(pokedex.getPokemon(0).getIv(), tt.getIv(),tt.getIv());
        }catch(Exception e){

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

    @Test
    public void shouldReturnSize(){
        assertEquals(pokedex.size(),listpoke.size());
    }

    @Test
    public void shouldReturnPokemonlist(){
        when(pokedex.getPokemons()).thenReturn(listpoke);
        assertEquals(pokedex.getPokemons().size(),listpoke.size());
    }

    @Test
    public void shouldReturnAddedPokemon(){
        when(pokedex.addPokemon(tt)).thenReturn(0);
        assertEquals(pokedex.addPokemon(tt),tt.getIndex());
    }

    @Test
    public void shouldCreatePokemon(){
        when(pokedex.createPokemon(0,613,64,4000,4)).thenReturn(tt);
        assertEquals(pokedex.createPokemon(0,613,64,4000,4),tt);
    }

    @Test
    public void shouldReturnPokemonMetadata(){
        try {
            when(pokedex.getPokemonMetadata(0)).thenReturn(pmt);
            assertEquals(pokedex.getPokemonMetadata(0),pmt);
        }catch(Exception e){

        }

    }
    @Test
    public void shouldReturnSortedList(){
        PokemonComparators pc = PokemonComparators.INDEX;
        when(pokedex.getPokemons(pc)).thenReturn(listpoke);
        List<Pokemon> sorted = pokedex.getPokemons(pc);
        assertEquals(sorted,listpoke);

    }

    @Test
    public void shouldReturnPokemonsList(){
        when(pokedex.getPokemons()).thenReturn(listpoke);
        List<Pokemon> sorted = pokedex.getPokemons();
        assertEquals(sorted,listpoke);

    }

    @Test(expected = PokedexException.class)
    public void shouldThrowPokedexException() throws PokedexException {
        when(pokedex.getPokemon(2)).thenThrow(new PokedexException("missing"));
        pokedex.getPokemon(2);
    }

}