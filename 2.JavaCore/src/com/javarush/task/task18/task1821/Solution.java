package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
        
		try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //создаю map для отсортированного списка по ключу (байту-символу)
            
			while (fileInputStream.available() > 0) {
				int symbol = fileInputStream.read();
                
				if (treeMap.containsKey(symbol)) { //если байт-символ есть в map
					treeMap.put(symbol, treeMap.get(symbol) + 1); //перезаписываю ключ и увеличиваю значение на 1
                    
				} else {
					treeMap.put(symbol, 1); //если ключа нет - добавляю в карту со значением 1
				}
			}
			for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()) {
				System.out.println((char)(int)pair.getKey() + " " + pair.getValue()); //преобразую ключ в символ и вывожу результат
			}
		}

		/*try (FileInputStream fis = new FileInputStream(args[0])) { // вариант решения получше
			int[] symbolsArray = new int[256];
			while (fis.available() > 0) {
				symbolsArray[fis.read()]++;
			}
			for (int i = 0; i < symbolsArray.length; i++) {
				if (symbolsArray[i] > 0) {
					System.out.println((char) i + " " + symbolsArray[i]);
				}
			}
		}*/
	}
}
