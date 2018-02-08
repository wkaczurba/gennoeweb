# gennoeweb
Simple Spring-Boot based password generator.
Primary purpose of it is to try jitpack.io.
The pom.xml uses GITHUB dependency from: https://github.com/wkaczurba/gennoe

The application is supposed to allow option of:
 - Text generation:
     - generate generic random text passwords/contents
       - it should allow to optimize passwords to contain particular characters
       - filter unwanted characters out
          - characters only accissible from a generic QWERTY keyboard.
       - add optional subwords into it (as a separate service)
          - words from technology/industry
          - words from particular language
          //- use some neo4j for that?
          //- optimal subwords should be taken from a separate microservice
     

   
 