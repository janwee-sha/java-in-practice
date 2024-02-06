package new_features.jdk9;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImmutableCollectionFactoryMethod {
    public static class FactoryMethodTest {
        @Test
        public void shouldCreateImmutableCollections() {
            List<String> list = List.of("守墓人", "牧师");
            Map<String, String> map = Map.of("Sherlock", "Holmes", "John", "Watson");
            assertThatThrownBy(() -> {
                list.add("农民");
            }).isInstanceOf(UnsupportedOperationException.class);
            assertThatThrownBy(() -> {
                map.put("Jon", "Wick");
            }).isInstanceOf(UnsupportedOperationException.class);
        }
    }
}
