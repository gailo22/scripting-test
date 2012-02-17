package com.scripting.app;
import javax.script.*;
import java.io.File;
/**
 * Java Virtual Machine Scripting (Jvms)
 */
public class Jvms 
{
	//TODO Add an option to process all files with the same name (ignoring extension)
	//TODO Add an option to process all files based upon an extension ?
    public static void main( String[] args )
    {   
	  	long startTime, endTime;
	
		if (args.length==0 || (args.length==1 && args[0].endsWith("version")))
			version();
	
		for (String fileName: args){
			
			if (!fileName.trim().equals(""))
			{ 
				startTime = System.nanoTime();	
		  		ScriptEngine eng = getEngineByFile(fileName);
		    	System.out.println("\n*** " + fileName + " using " + eng.getFactory().getEngineName() );
				File file=new java.io.File(fileName);
		
				if (!file.exists())
					fileName ="src/main/resources/scripts/"+fileName;

				try {
			  		eng.eval(new java.io.FileReader(fileName));
				}catch (Throwable e){
					e.printStackTrace();
				} 
				finally {
			  		endTime = System.nanoTime();
				}
			System.out.println("*** " + (endTime - startTime) + " Nanoseconds");
  			}
		}
    }

	/**
	 *
	 */
	public static ScriptEngine getEngineByFile(String file)
	{
		String ext = file.substring(file.indexOf(".") + 1, file.length());
		return new ScriptEngineManager().getEngineByExtension(ext);
	}
	
	/**
	 *
	 */
	public static ScriptEngine getEngineByName(String name)
	{
		return new ScriptEngineManager().getEngineByName(name);
	}

	/**
	 *
	 */
	public static void version(){
		
		System.out.println("\n-------------------\nJvms: Version 1.00\n-------------------");
		java.util.List<ScriptEngineFactory> fs = new ScriptEngineManager().getEngineFactories();

		for (ScriptEngineFactory f : fs) {
			System.out.println("Engine   : " + padLeft(f.getEngineName()  ,25) + "\t" + f.getEngineVersion());
			System.out.println("Language : " + padLeft(f.getLanguageName(),25) + "\t" + f.getLanguageVersion() + "\n");
		}
	}
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$-" + n + "s", s);  
	}
}