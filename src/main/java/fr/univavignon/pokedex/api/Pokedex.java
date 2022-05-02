package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    List<Pokemon> pokemonList;
    IPokemonFactory factory;
    IPokemonMetadataProvider metadataProvider;

    public Pokedex(List<Pokemon> pokemonList, IPokemonFactory factory, IPokemonMetadataProvider metadataProvider) {
        this.pokemonList = pokemonList;
        this.factory = factory;
        this.metadataProvider = metadataProvider;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }



    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        Pokemon tt = pokemonList.get(id);
        if (tt == null){
            throw new PokedexException("Index pokemon non trouvé");
        }
        return tt;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> tt = pokemonList;
        tt.sort(order);
        return tt;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon tt = factory.createPokemon(index,cp,hp,dust,candy);
        return tt;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata tt = metadataProvider.getPokemonMetadata(index);
        if(tt == null){
            throw new PokedexException("Pokemonmetada non trouvé");
        }
        return tt;
    }
}
