package data.structure.collection;


import data.structure.collection.file.FileInfo;
import data.structure.collection.file.Files;
import data.structure.collection.set.ListSet;
import data.structure.collection.set.Set;
import data.structure.collection.set.TreeSet;

public class Main {
	
	static void test1() {

		Set<Integer> listSet = new ListSet<>();
		listSet.add(10);
		listSet.add(11);
		listSet.add(11);
		listSet.add(12);
		listSet.add(10);
		
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(12);
		treeSet.add(10);
		treeSet.add(7);
		treeSet.add(11);
		treeSet.add(10);
		treeSet.add(11);
		treeSet.add(9);
		
		treeSet.traversal(new Set.Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	
	static void testSet(Set<String> set, String[] words) {
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.contains(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.remove(words[i]);
		}
	}
	
	static void test2() {
		FileInfo fileInfo = Files.read("C:\\Users\\MJ Lee\\Desktop\\src\\java\\util",
				new String[]{"java"});
		
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
//		Times.test("ListSet", new Task() {
//			public void execute() {
//				testSet(new ListSet<>(), words);
//			}
//		});
		
		Times.test("TreeSet", new Times.Task() {
			public void execute() {
				testSet(new TreeSet<>(), words);
			}
		});
	}

	public static void main(String[] args) {
		test2();
	}

}
