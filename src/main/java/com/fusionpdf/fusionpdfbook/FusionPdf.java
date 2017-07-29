package com.fusionpdf.fusionpdfbook;

import java.io.File;

public class FusionPdf 
{
    private static final String OUTPUT_FOLDER = "D:\\books";
    private static final String INPUT_FOLDER = "D:\\booksIput";

	public static void main( String[] args )
    {
        System.out.println( "output :" +OUTPUT_FOLDER);       
        System.out.println( "input :" +INPUT_FOLDER);
        
        
        File rep = new File(OUTPUT_FOLDER);
        File[] fichiersJava = rep.listFiles();
        for (int i = 0; i < fichiersJava.length; i++) {
			File file = fichiersJava[i];
			System.out.println(file.getName());
			
		}
    }
}
