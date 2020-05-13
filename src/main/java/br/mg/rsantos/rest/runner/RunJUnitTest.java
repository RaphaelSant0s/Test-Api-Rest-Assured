package br.mg.rsantos.rest.runner;

import br.mg.rsantos.rest.tests.BookCreation;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookCreation.class

})
public class RunJUnitTest {



}
