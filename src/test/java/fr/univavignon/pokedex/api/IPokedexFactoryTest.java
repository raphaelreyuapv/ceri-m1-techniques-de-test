package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {


    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
    IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokedex pokedex = mock(IPokedex.class);
    List pokelist = mock(List.class);
    Pokemon tt;

    @Before
    public void init(){
        tt = new Pokemon(0,"Bulbizare",126,126,90,613,64,4000,4,56.0);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
        try {
            when(pokedex.getPokemon(0)).thenReturn(tt);
            when(pokedex.getPokemons()).thenReturn(pokelist);
            when(pokelist.get(0)).thenReturn(tt);
            when(pokedex.size()).thenReturn(pokelist.size());
            when(pokelist.size()).thenReturn(1);
        }catch(Exception e){

        }
    }

    @Test
    public void shouldReturnIndex(){
        try {
            assertEquals(pokedex.getPokemon(0).getIndex(),tt.getIndex());
        }catch(Exception e){

        }
    }

    @Test
    public void shouldReturnPokemonIndex0(){
        List<Pokemon> pokelist = pokedex.getPokemons();
        assertEquals(pokelist.get(0).getIndex(),tt.getIndex());
    }

    @Test
    public void shouldReturnSize(){
        assertEquals(pokedex.size(),pokelist.size());
    }

}