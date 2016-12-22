package core.Store;

/**
 * Ensures that an object has an available ID.
 *
 * Does not ensure that the object is unique. But rather
 * encourages semantically that the object (at least amongst its
 * pears) should be uniquely identifiable.
 *
 */
public interface Unique {

    int getId();
}
