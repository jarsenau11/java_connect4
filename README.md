This is a simple application that allows users to play a console or GUI based game of Connect 4.

To run the application, Java tests for JUnit 4 will need to be enabled (alternatively, the test 
folder can be deleted), JavaFX jar files will need to be added to the dependencies, and the 
following line will need to be added to the VM Options: 

``` "--module-path [/path/to/JavaFX/lib] --add-modules=javafx.controls" ```
where [/path/to/JavaFX/lib] is your path to the JavaFX lib folder.

The main method is located in src/ui/Connect4GUI.java
