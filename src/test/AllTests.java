package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Connect4ColumnFullTest.class, Connect4DiagonalDownTest.class,
		Connect4DiagonalUpTest.class, Connect4HorizWinTest.class, Connect4IsFullTest.class, Connect4VertWinTest.class })
public class AllTests {

}
