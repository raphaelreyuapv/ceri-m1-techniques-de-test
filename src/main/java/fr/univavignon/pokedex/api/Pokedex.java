package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements  IPokedex{

    List<Pokemon> list;
    int index = 0;
    public Pokedex(){
        list = new ArrayList<Pokemon>();
    }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        list.add(pokemon);
        index++;
        return index-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return list.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return list;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sorted = list;
        sorted.sort(order);
        return sorted;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon tt = new Pokemon(index,
                list.get(index).getName(),
                list.get(index).getAttack(),
                list.get(index).getDefense(),
                list.get(index).getStamina(),
                cp,
                hp,
                dust,
                candy,
                list.get(index).getIv()
                );
        return tt;

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pm = new PokemonMetadata(index,
                list.get(index).getName(),
                list.get(index).getAttack(),
                list.get(index).getDefense(),
                list.get(index).getStamina()
                );
        return pm;
    }
}
