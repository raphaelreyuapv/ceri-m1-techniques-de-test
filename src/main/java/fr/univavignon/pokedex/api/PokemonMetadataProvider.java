package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    List<PokemonMetadata> metadataList;

    public PokemonMetadataProvider() {
        metadataList = new ArrayList<PokemonMetadata>();
        metadataList.add(new PokemonMetadata(0,"Bulbizare",64,64,90));

    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataList.get(index);
    }
}
