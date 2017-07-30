package com.fusionpdf.fusionpdfbook;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Repertoire implements MyFile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8749789641477639033L;
	private Repertoire repertoireParent;
	private File file;
	private List<MyFile> ListeEnfant;

	public Repertoire(File f) {
		System.out.println("(f.getPath())"+f.getPath());
		this.file = f;
		if (f.isDirectory()) {
			List<File> listeFichiers = Arrays.asList(f.listFiles());
			File[] xx = f.listFiles();
			 for (int i = 0; i < xx.length; i++) {
			 this.addEnfant(xx[i]);
			 }
		} else {
			System.out.println(f.getName() + " est un fichier simple");
		}

	}

	@Override
	public List<MyFile> getEnfants() {

		return this.getListeEnfant();
	}

	@Override
	public MesType getType() {

		return MesType.repertoire;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<MyFile> getListeEnfant() {
		return ListeEnfant;
	}

	public void setListeEnfant(List<MyFile> listeEnfant) {
		ListeEnfant = listeEnfant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getNom() {
		return file.getName();
	}

	public void addEnfant(File f) {
		File[] fichiers = f.listFiles();
		System.out.println( "addEnfant"+f.getName() + " " + fichiers.length);

		List<File> listeFichiers = Arrays.asList(fichiers);
		for (File file : listeFichiers) {
			Repertoire repertoire = new Repertoire(file);
			if (file.isDirectory()) {
				String[] listeFils = file.list();
			} else {
			}
		}

	}

	@Override
	public void show() {
		System.out.println(file.getPath());
		for (MyFile myFile : ListeEnfant) {
			myFile.show();
		}

	}
}
