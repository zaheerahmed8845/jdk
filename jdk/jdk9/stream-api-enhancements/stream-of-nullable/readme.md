Stream of Nullable
------------------

1. This is used to remove the null value from Stream.
2. The Stream of Nullable returns a Stream.of(value), if it is present or Stream.empty() if the value is null.
   Stream.ofNullable() -> null ? Stream.of(value) : Stream.empty()
3. To flatten the returned Stream response, flat map is used.
