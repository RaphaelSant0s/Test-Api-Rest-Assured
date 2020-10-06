package rest.util;

import java.io.File;

public class teste {
	public static void main(String[] args) throws Exception {
		
		File file = FileManager.getRecursiveFiles("C:\\Users\\Zupper\\Desktop\\folder1", "teste");

		System.out.println(file.getName());

	}
}
