Unmodifiable Collection:
------------------------
**List**
1. This creates an ArrayList.
2. List.of() is used to create the unmodifiable collection.
3. It means that add, remove or set function cannot be invoked on this. If this is invoked it would throw an UnsupportedException.
4. The of method has 0 to 10 parameters and after that it take variable parameters.
5. Null values cannot be added in the of method. If added will throw an NullPointerException.

**Set**
1. This creates a HashSet.
2. Set.of() is used to create the unmodifiable collection.
3. It means that add, remove function cannot be invoked on this. If this is invoked it would throw an UnsupportedException.
4. The of method has 0 to 10 parameters and after that it take variable parameters.
5. Null values cannot be added in the of method. If added will throw an NullPointerException.
6. Duplicate values can be added, if added will throw a DuplicateElementException.

**Map**
1. This creates a HashMap.
2. Map.of() is used to create the unmodifiable collection.
3. It means that put, remove function cannot be invoked on this. If this is invoked it would throw an UnsupportedException.
4. The of method is different when compared with Set and List. The syntax is as below:
```
Map<String, Integer> alphabets = Map.ofEntries(
    Map.entry("ABC",100),
    Map.entry("DEF", 120),
    Map.entry("XYZ", 50)
);
```
5. Null key value cannot be added in the of method. If added will throw an NullPointerException.
6. Duplicate key cannot be added to the map, if added will throw an IllegalArgumentException.

**In what scenarios should the of() method be used?**

The *of* method returns an unmodifiable collection which can be used in below scenarios:
1. *Passing it to client*: Since this creates an unmodifiable collection, it can be passed to client and one can ensure that this is immutable.
2. *Thread Safety*
3. *Provides space efficiency* 

**What is the difference between UnModifiableList and of method?**

| Unmodifiable List      | of                |
|------------------------|-------------------|
|The code is not very concise| The code is concise |
|Creates a view on top of underlying collection, No operations are allowed on the view, but any changes in underlying collection changes will show up in the view | No operations are allowed and its not a view |
|Null value is allowed | Null value not allowed|
|Duplicates allowed | Duplicates not allowed|

