package com.scripting.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import javax.script.*;

import com.scripting.app.Jvms;

/**
 * Unit test for simple App.
 */
public class JvmsTest 
    extends TestCase
{
	Jvms app;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JvmsTest( String testName )
    {
	    super( testName );
    }

	public void setUp()
	{
		app = new Jvms();
	}

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JvmsTest.class );
    }

   public static void outputByEngine(String engineName, String outputCmd) throws javax.script.ScriptException{
		
		ScriptEngine engine = Jvms.getEngineByName(engineName);
		if (engine==null){System.out.println("Could not find engine: "+engineName);}
		engine.eval(outputCmd);
	}

	public void testCanGetEngineByFile()
	{
		assertNotNull(Jvms.getEngineByFile("test.rb")); //jruby
		assertNotNull(Jvms.getEngineByFile("test.py")); //jython
		assertNotNull(Jvms.getEngineByFile("test.js")); //JavaScript
		assertNotNull(Jvms.getEngineByFile("test.clj")); //Clojure
		assertNotNull(Jvms.getEngineByFile("test.groovy")); //Groovy
		assertNull(Jvms.getEngineByFile("test.invalid")); // invalid engine
	}

}
