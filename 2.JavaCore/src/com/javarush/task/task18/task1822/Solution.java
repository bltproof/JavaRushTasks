package com.javarush.task.task18.task1822;

import java.io.*;

/*
Поиск данных внутри файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fileInput = new BufferedReader(new FileReader(input.readLine()))){

			while (fileInput.ready()) {
				String line = fileInput.readLine();
				if (line.startsWith(args[0] + " ")){
					System.out.println(line);
					break;
				}
			}
		}
	}
}
