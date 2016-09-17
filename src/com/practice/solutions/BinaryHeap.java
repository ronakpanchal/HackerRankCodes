package com.practice.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

	private List<Integer> heap = new ArrayList<>();
	private int size;

	public void addElement(int element) {
		heap.add(size++, element);
		heapify();
	}

	private void heapify() {

		int count = size - 1;
		int parent_Index = (count - 1) / 2;
		int parent;
		int element;
		int temp;

		while (parent_Index >= 0 && (count != parent_Index)) {
			element = heap.get(count);
			parent = heap.get(parent_Index);
			if (element < parent) {
				temp = element;
				heap.set(count, parent);
				heap.set(parent_Index, temp);
				count = parent_Index;
				parent_Index = (count / 2);
			} else {
				break;
			}
		}
	}

	public int getMinElement() {
		if (heap.size() > 0) {
			return heap.get(0);
		} else {
			return -1;
		}

	}

	public void deleteElement(int element) {
		int index = searchElement(element);
		int temp;
		if (index != -1) {
			int last_element = heap.get(size - 1);
			size--;
			heap.set(index, last_element);
			int i = index;
			int a = (2 * i) + 1;
			int b = (2 * i) + 2;
			while (a < size - 1) {
				if (heap.get(i) < heap.get(a) && heap.get(i) < b) {
					return;
				} else {
					if (heap.get(a) < heap.get(b)) {
						temp = heap.get(i);
						heap.set(i, heap.get(a));
						heap.set(a, temp);
						i = a;
					} else {
						temp = heap.get(i);
						heap.set(i, heap.get(b));
						heap.set(b, temp);
						i = b;
					}
					a = (2 * i) + 1;
					b = (2 * i) + 2;
				}
			}
		}
	}

	public int searchElement(int element) {
		for (int i = 0; i < heap.size(); i++) {
			if (heap.get(i) == element) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BinaryHeap obj = new BinaryHeap();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] result;
		try {
			String[] array = in.readLine().split(" ");
			int numberOfQ=Integer.parseInt(array[0]);
			result = new int[numberOfQ];
			int count = 0;
			for (int i = 0; i < numberOfQ; i++) {
				String[] inp = in.readLine().split(" ");
				if (inp.length == 1) {
					int answer = obj.getMinElement();
					result[count++] = answer;
				} else {
					int element = Integer.parseInt(inp[1]);

					if (Integer.parseInt(inp[0]) == 1) {
						obj.addElement(element);
					} else {
						obj.deleteElement(element);
					}
				}

			}
			for(int j=0;j<count;j++){
				System.out.println(result[j]);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
