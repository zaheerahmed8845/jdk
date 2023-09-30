Unmodifiable Collection:
------------------------
**List**
1. This creates an ArrayList.
2. List.of() is used to create the unmodifiable collection.
3. It means that add, remove or set function cannot be invoked on this. If this is invoked it would throw an UnsupportedException.
4. The of method has 0 to 10 parameters and after that it take variable parameters.

**Set**
1. This creates a HashSet.
2. Set.of() is used to create the unmodifiable collection.
3. It means that add, remove function cannot be invoked on this. If this is invoked it would throw an UnsupportedException.
4. The of method has 0 to 10 parameters and after that it take variable parameters.

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
