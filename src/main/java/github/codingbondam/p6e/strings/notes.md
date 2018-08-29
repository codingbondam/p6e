# things to remember

1. `utf-8` uses 1 to 4 8-bit chars to encode Unicode code points
2. `utf-16` ues 1 to 2 16-bit chars
3. frequent unicode code points are encoded with lesser number of chars
4. `ascii` encoded text becomes subset of `utf-8` encoded text
5.  In java char is 2 byte. String is internally stored as an array of `char`
6. `StringBuffer` is threadsafe while `StringBuilder` is more efficient
7. The compiler uses `StringBuffer` when you concatenate using `+`
 
