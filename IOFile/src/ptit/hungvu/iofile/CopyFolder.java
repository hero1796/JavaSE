/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.iofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HungVu
 */
public class CopyFolder {

	private static Scanner sc;

	static class CopyThread implements Runnable {

		private String srcFileName, desFileName;

		public CopyThread(String srcFileName, String desFileName) {
			this.srcFileName = srcFileName;
			this.desFileName = desFileName;
		}

		@Override
		public void run() {
			File srcFile = new File(srcFileName);
			File desFile = new File(desFileName);
			try {
				BufferedInputStream input = new BufferedInputStream(new FileInputStream(srcFile));
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(desFile));
				byte[] in = new byte[1024];
				while ((input.read(in)) != -1) {
					output.write(in, 0, in.length);
				}
				input.close();
				output.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) {
		String srcFolder, desFolder;
		sc = new Scanner(System.in);
		System.out.println("Source folder: ");
		srcFolder = sc.nextLine();
		System.out.println("Destination foler: ");
		desFolder = sc.nextLine();
		File folder = new File(srcFolder);
		File[] listFiles = folder.listFiles();
		String srcFile, desFile;
		ArrayList<Thread> arrThread = new ArrayList<>();
		for (File item : listFiles) {
			if (!item.isDirectory()) {
				srcFile = srcFolder + "/" + item.getName();
				desFile = desFolder + "/" + item.getName();
				arrThread.add(new Thread(new CopyThread(srcFile, desFile)));
			}
		}
		arrThread.forEach((thread) -> {
			thread.start();
		});
	}
}
