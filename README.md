# Indexing-client
How to use this libaray?

1- Download the dump of the ontology you want. For example download the dbpedia dumps: <br />
  wget http://downloads.dbpedia.org/2015-04/core-i18n/en/labels_en.nt.bz2 <br />
  wget http://downloads.dbpedia.org/2015-04/core-i18n/en/mappingbased-properties_en.nt.bz2
  wget http://downloads.dbpedia.org/2015-04/core-i18n/en/infobox-properties_en.nt.bz2
  Decompresse them ; )
  Make a unique dump using „cat mappingbased-properties_en.nt infobox-properties_en > dump-en.nt"
2- Install octave
3- Download the git repository: https://github.com/WDAqua/Indexing-server
4- Go into src/main/java/Index.class and modify the two variables

       String octavePath="/usr/bin/octave";
       String dump = "/ssd/dennis/dump-it.nt“;

to the corresponding directories. For octave you can find it out with „which octave“ on CL.
5- Do „mvn package“ to compile. (NOTE: you need java 8 due to dependencies to Jena)
6- Now you can run the server with „java -jar „ on the corresponding jar in the target folder.

The corresponing client can be found under:
https://github.com/WDAqua/Indexing-client
