package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory{

    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "Bulbizare");
        aMap.put(1, "Aquali");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Random rand = new Random();
        int attack = rand.nextInt(16)-1;
        int def = rand.nextInt(16)-1;
        int stamina = rand.nextInt(16)-1;
        double iv = (attack+def+stamina)/45*100;
        return new Pokemon(index,index2name.get(index),attack,def,stamina,cp,hp,dust,candy,iv);
    }
}
