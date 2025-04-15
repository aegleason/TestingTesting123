package com.example.testingtesting123

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("Test Item") //
        collection.addItem(item) //
        assertEquals("Collection size should be 1 after adding an item", 1, collection.size()) //
        assertEquals("The added item should be retrievable", item, collection.get(0)) //
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        val item1 = Item("Apple") //
        val item2 = Item("apple") //
        val item3 = Item("Orange") //

        collection.addItem(item1) //
        assertEquals("Collection size should be 1 after adding the first item", 1, collection.size()) //


        collection.addItem(item2) //

        assertEquals("Collection size should still be 1 after adding a duplicate item (case-insensitive)", 1, collection.size()) //
        assertEquals("The first item should still be 'Apple'", "Apple", collection.get(0).name) //


        collection.addItem(item3) //
        assertEquals("Collection size should be 2 after adding a second unique item", 2, collection.size()) //
        assertEquals("The second item should be 'Orange'", "Orange", collection.get(1).name) //
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}