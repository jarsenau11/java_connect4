This is a simple application that allows users to play a console or GUI based game of Connect 4.

To run the application, use the connect4.jar file by entering the following command into the command line in the directory with the connect4.jar file:

```java --enable-preview --module-path [/path/to/JavaFX/lib] --add-modules javafx.controls -jar connect4.jar``` where [/path/to/JavaFX/lib] is your path to the JavaFX lib folder.

Alternatively, if you wish to use an IDE to run the program, you will need to:
- enable Java tests for JUnit 4 (or delete the test folder)
- add JavaFX jar files to the dependencies/referenced libraries
- add the following line to the VM Options: 

``` "--module-path [/path/to/JavaFX/lib] --add-modules=javafx.controls" ```
where [/path/to/JavaFX/lib] is your path to the JavaFX lib folder 
For example: ```java --enable-preview --module-path E:/javafx/javafx-sdk-18.0.1/lib --add-modules javafx.controls -jar connect4.jar```

The main method is located in src/ui/Connect4GUI.java
