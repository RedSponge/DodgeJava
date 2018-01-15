package com.redsponge.dodge.input.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileManager {

	@SuppressWarnings("resource")
	public String readExternalFile(String filename) {
		String text = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int content;
			while ((content = br.read()) != -1) {
				text += (char) content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	@SuppressWarnings("resource")
	public String readInternalFile(String filename) {
		String text = "";
		try {
			File f = new File(getClass().getClassLoader().getResource(filename).getPath());
			BufferedReader br = new BufferedReader(new FileReader(f));
			int content;
			while ((content = br.read()) != -1) {
				text += (char) content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

}
