package hu.bearmaster.tutorial.matek;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PrímTárTest {

    private PrímTár prímTár = new PrímTár();

    @ParameterizedTest
    @ValueSource(ints =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 44983, 85751})
    void prímIgazzalTérVisszaPrímSzámokra(int prím) {
        assertThat(prímTár.prím(prím)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints =
            {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 35, 42, 44, 49, 52, 60, 63, 68, 75, 81, 85, 91, 95, 100, 10403, 307561})
    void prímHamissalTérVisszaÖsszetettSzámokra(int összetett) {
        assertThat(prímTár.prím(összetett)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("számÉsRákövetkezőPrímForrás")
    void következőPrím(int szám, int rákövetkezőPrím) {
        assertThat(prímTár.következőPrím(szám)).isEqualTo(rákövetkezőPrím);
    }

    static Stream<Arguments> számÉsRákövetkezőPrímForrás() {
        return Stream.of(
                arguments(2, 3),
                arguments(4, 5),
                arguments(28, 29),
                arguments(48, 53),
                arguments(99, 101),
                arguments(198, 199),
                arguments(198, 199),
                arguments(338, 347),
                arguments(622, 631),
                arguments(1000, 1009)
        );
    }

}