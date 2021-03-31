package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortNaturalOrderById(){
        Item item1 = new Item("alfa");
        Item item2 = new Item("beta");
        Item item3 = new Item("gamma");
        item1.setId(101);
        item2.setId(102);
        item3.setId(103);
        List<Item> input = Arrays.asList(item3,item1,item2);
        List<Item> expected = Arrays.asList(item1,item2,item3);
        Collections.sort(input,new SortByIdItem());
        assertEquals(expected,input);

    }

    @Test
    public void whenSortNaturalOrderByName(){
        Item item1 = new Item("alfa");
        Item item2 = new Item("beta");
        Item item3 = new Item("gamma");
        item1.setId(101);
        item2.setId(102);
        item3.setId(103);
        List<Item> input = Arrays.asList(item3,item1,item2);
        List<Item> expected = Arrays.asList(item1,item2,item3);
        Collections.sort(input,new SortByNameItem());
        assertEquals(expected,input);

    }

    @Test
    public void whenSortReverseOrderById(){
        Item item1 = new Item("alfa");
        Item item2 = new Item("beta");
        Item item3 = new Item("gamma");
        item1.setId(101);
        item2.setId(102);
        item3.setId(103);
        List<Item> input = Arrays.asList(item3,item1,item2);
        List<Item> expected = Arrays.asList(item3,item2,item1);
        Collections.sort(input,new RevSortByIdItem());
        assertEquals(expected,input);

    }

    @Test
    public void whenSortReverseOrderByName(){
        Item item1 = new Item("alfa");
        Item item2 = new Item("beta");
        Item item3 = new Item("gamma");
        item1.setId(101);
        item2.setId(102);
        item3.setId(103);
        List<Item> input = Arrays.asList(item3,item1,item2);
        List<Item> expected = Arrays.asList(item3,item2,item1);
        Collections.sort(input,new RevSortByIdItem());
        assertEquals(expected,input);

    }
}