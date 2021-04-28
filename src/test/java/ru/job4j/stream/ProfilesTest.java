package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void collectAddressWithCityUniqueSort() {
        List<Profile> profiles = List.of(
                new Profile(new Address("New York", "Congress", 1, 13)),
                new Profile(new Address("New York", "Congress", 1, 13)),
                new Profile(new Address("Jersey", "Main", 5, 77)),
                new Profile(new Address("Denver", "Coronado", 3, 1))
        );
        Profiles profiles1 = new Profiles();
        List<Address> rsl = profiles1.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Denver", "Coronado", 3, 1));
        expected.add(new Address("Jersey", "Main", 5, 77));
        expected.add(new Address("New York", "Congress", 1, 13));
        assertThat(rsl, is(expected));
    }
}