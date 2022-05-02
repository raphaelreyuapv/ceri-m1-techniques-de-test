package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokedexFactory implements IPokedexFactory{
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(new ArrayList<Pokemon>(),new RocketPokemonFactory(),new PokemonMetadataProvider());
    }

}
