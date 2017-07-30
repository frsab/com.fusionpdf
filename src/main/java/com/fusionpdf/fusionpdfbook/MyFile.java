package com.fusionpdf.fusionpdfbook;

import java.io.File;
import java.util.List;

public interface  MyFile {
	public String  getNom();
	public MesType  getType();
	public List<MyFile>  getEnfants();
	void show();
	
	

}
