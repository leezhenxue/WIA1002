package Lab3_ADT_and_Bag;

/**
 * An interface that describes the operations of a bag of objects.
 */
public interface BagInterface<T> {

    /**
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is full.
     *
     * @return true if the bag is full, or false if not
     */
    public boolean isFull();

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     */
    public T remove();

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false if not
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if this bag contains anEntry, or false otherwise
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    public T[] toArray();

    /**
     * Combines the contents of two bags into a new bag.
     * @param bag2 The second bag to combine with the first.
     * @return A new bag containing all elements from both bags.
     */
    public BagInterface<T> union(BagInterface<T> bag2);

    /**
     * Find overlapping entries
     * 
     * @param bag2 The second bag to have intersection with this bag.
     * @return as a new bag the intersection of the bag receiving 
     * the call to the method and the bag that is the method’s one argumen
     */
    public BagInterface<T> intersection(BagInterface<T> bag2);

    /**
     * @param bag2 The second bag to have difference with this bag.
     * @return as a new bag the difference of the bag receiving the call to 
     * the method and the bag that is the method’s one argument
     */
    public BagInterface<T> difference(BagInterface<T> bag2);
} // end BagInterface
