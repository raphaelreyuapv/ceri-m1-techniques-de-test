package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    private PokemonMetadata pm;
    private IPokemonMetadataProvider pmp;

    @Before
    public void init(){
        pmp = mock(IPokemonMetadataProvider.class);
        try {
            pm = new PokemonMetadata(0, "Bulbizare", 126, 126, 90);
            when(pmp.getPokemonMetadata(0)).thenReturn(pm);
        }catch(Exception e){

        }
    }

    @Test
    public void shouldReturnBulbizare(){
        try {
            PokemonMetadata test = pmp.getPokemonMetadata(0);
            assertEquals(test.getName(), pm.getName());
        }catch(Exception e){

        }
    }

    @Test
    public void shouldReturnIndex(){
        try {
            PokemonMetadata test = pmp.getPokemonMetadata(0);
            assertEquals(test.getIndex(), pm.getIndex());
        }catch(Exception e){

        }
    }
    @Test
    public void shouldReturnAttack(){
        try {
            PokemonMetadata test = pmp.getPokemonMetadata(0);
            assertEquals(test.getAttack(), pm.getAttack());
        }catch(Exception e){

        }
    }
    @Test
    public void shouldReturnDefense(){
        try {
            PokemonMetadata test = pmp.getPokemonMetadata(0);
            assertEquals(test.getAttack(), pm.getDefense());
        }catch(Exception e){

        }
    }
    @Test
    public void shouldReturnStamina(){
        try {
            PokemonMetadata test = pmp.getPokemonMetadata(0);
            assertEquals(test.getStamina(), pm.getStamina());
        }catch(Exception e){

        }
    }
}