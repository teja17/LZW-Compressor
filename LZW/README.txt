1. Encoder.java :In this, the input text provided in input.txt is encoded and stored in file input.lzw in UTF-16BE format
2. Decoder.java :In this, the encoded input text provided in input.lzw is decoded and stored in file input_decoded.txt

Program Design:
Encoder:
1)Read the input text from input file based on the first argument passed to the program, and stored it in a Character ArrayList.
2)Then took the second argument for bit_length which was used to compute the maximum table size.
3)Initialized the hash table with the first 256 ASCII values.
4)Implemented the encoding logic provided to encode the file content and then wrote the same into input.lzw file.
 
Decoder:
1)Read the input text from encoded input file based on the first argument passed to the program, and stored it in a Integer ArrayList.
2)Then took the second argument for bit_length which was used to compute the maximum table size.
3)Initialized the hash table with the first 256 ASCII values.
4)Implemented the decoding logic provided to decode the file content and then wrote the same into input_decoded.txt file.
 
Data Structure Design:
1. Table:Hashtable is used to store the string and corresponding code value pair.Hashtable is used because the search time is constant O(1).The hashtable is intialized with the first 256 ASCII values. And the the table grows until Max table size =2^bit_length.

2. ArrayList: The input read from inputfile is stored in ArrayList. ArrayList data structure is used as it has dynamic size.

Programming Language Used: Java
Compiler version:java version "9.0.4"

Steps to execute the Program:
1. Copy both the project files(Encoder and Decoder) in your working directory.

Encoder:
1.Compile the Encoder java file.
2.Run the Encoder class passing two arguments 1)input2.txt file and 2)bit length
3.A new file will be created in the location of input2.txt with the name "input2.lzw" which will contain the encoded data.

Decoder:
1.Compile the Decoder java file.
2.Run the Decoder class passing two arguments 1)input2.lzw file and 2)bit length
3.A new file will be created in the location of input2.lzw with the name "input2_decoded.lzw" which will contain the decoded data.

Summary:Given an ASCII text file as input to the encoder,encoder does encode the content. And decoder is able to correctly decode the data back into its actual form.
