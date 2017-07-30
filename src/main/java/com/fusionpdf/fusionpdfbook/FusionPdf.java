package com.fusionpdf.fusionpdfbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class FusionPdf {
	private static final String OUTPUT_FOLDER = "D:\\books\\EditionENI_UnivLyon";
	private static final String INPUT_FOLDER = "D:\\booksIput\\";

	public static void main(String[] args) {
		System.out.println("output :" + OUTPUT_FOLDER);
		System.out.println("input :" + INPUT_FOLDER);

		TreeSet<MyFile> outputRoot = new TreeSet<MyFile>();
		TreeSet<MyFile> insputRoot = new TreeSet<MyFile>();
		File outoutRep = new File(OUTPUT_FOLDER);
		showRep(outoutRep);
	}

	@SuppressWarnings("deprecation")
	private static void showRep(File file) {
	if(file.isDirectory()) {
		System.out.println(repertoireEtFichier(file));
		PDDocument document = new PDDocument();
		List<File> fileToLoaded=new ArrayList<File>();
		List<PDDocument> pddDocumentToLoaded=new ArrayList<PDDocument>();
		File[] xx = file.listFiles();
		Arrays.sort(xx);
		 for (int i = 0; i < xx.length; i++) {
			 showRep(xx[i]);//.getName()+ "), ";
			 if(!(xx[i].isDirectory())&& xx[i].getName().endsWith(".pdf")){
				 fileToLoaded.add(xx[i]);
				 PDDocument c;
				try {
					c = PDDocument.load(xx[i]);
					pddDocumentToLoaded.add(c);
				} catch (InvalidPasswordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 }
		 }
			PDFMergerUtility PDFmerger = new PDFMergerUtility();
			PDFmerger.setDestinationFileName(INPUT_FOLDER+file.getName()+"merged.pdf");
			for (File ff : fileToLoaded) {
				try {
					PDFmerger.addSource(ff);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
			try {
				PDFmerger.mergeDocuments();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (PDDocument doc : pddDocumentToLoaded) {
				try {
					doc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 try {
			String path=INPUT_FOLDER+file.getName()+".pdf";
			document.save(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		System.out.println(file.getName());
	}
		
	}

	private static String repertoireEtFichier(File file) {
		String result="";
		result+=file.getName() + " [";
		List<File> listeFichiers = Arrays.asList(file.listFiles());
		File[] xx = file.listFiles();
		 for (int i = 0; i < xx.length; i++) {
			 result+="("+xx[i].getName()+ "), ";
		 }
		result+= " ]";
		return result;
	}
}
