package model;


import java.util.Arrays;
import java.util.stream.Collectors;

public enum Feeling {
    VERY_GOOD,
    GOOD,
    SLIGHTLY_GOOD,
    MEH,
    SLIGHTLY_BAD,
    BAD,
    VERY_BAD,
    TERRIBLE;

    @Override
    public String toString() {
        // "VERY_BAD" -> "Very Bad"
        return Arrays.stream( this.name()
                        .split( "_" ) )
                .map( s -> s.charAt( 0 ) + s.substring( 1 ).toLowerCase() )
                .collect( Collectors.joining(" ") );
    }
}
