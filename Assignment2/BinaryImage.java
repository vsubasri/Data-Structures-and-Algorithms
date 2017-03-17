/*
 * Name: Valli Subasri
 * Student Number: 250697148
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryImage {
	public static void main(String[] args) {
		int[][] img = null;
		boolean[][] imgBool;
		int[] sets;
		int[] characters;

		if (args.length != 1)
			System.out.println("Correct use: binaryImage filename.txt)");
		else {
			try {
				FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader is = new InputStreamReader(fis);
				BufferedReader in = new BufferedReader(is);

				img = new int[71][71];
				imgBool = new boolean[71][71];

				String components;
				for (int i = 0; in.ready(); i++) {
					components = in.readLine();
					for (int j = 0; j < components.length(); j++)
						if (components.charAt(j) == '+') {
							img[i][j] = 1;
							imgBool[i][j] = true;
						}
				}
				in.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
			} catch (IOException e) {
				System.out.println("Cannot read file.");
			}
		}

		System.out.println("\n(1)\n");

		// prints binary image
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img.length; j++) {
				System.out.print(img[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n(2)\n");

		// creates the Union Find and connects its components.
		UandF imageSet = new UandF(img.length * img.length + 1);
		for (int i = 0; i < img.length; i++)
			for (int j = 0; j < img.length; j++)
				if (img[i][j] == 1) {
					imageSet.make_set((i * img.length + j) + 1);
					if (j > 0 && img[i][j - 1] == 1)
						imageSet.union_sets(i * img.length + (j - 1) + 1, i
								* img.length + j + 1);
					if (i > 0 && img[i - 1][j] == 1)
						imageSet.union_sets((i - 1) * img.length + j + 1, i
								* img.length + j + 1);
				}

		sets = new int[imageSet.final_sets()];
		characters = new int[sets.length];

		// prints the connected component image where each component is labelled with a unique character
		int z;
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img.length; j++) {
				z = imageSet.find_set(i * img.length + j + 1) + 96;
				if (z == 96)
					System.out.print(' ');
				else {
					System.out.print((char) z);
					sets[z - 97]++;
				}
			}
			System.out.println();
		}
		System.out.println("\n(3)\n");

		// sorts the lists.
		int[] sortedSets = new int[sets.length];
		for (int i = 0; i < sets.length; i++)
			sortedSets[i] = sets[i];
		for (int i = 0; i < sortedSets.length; i++)
			characters[i] = sortedSets[i];
		Arrays.sort(sortedSets);

		// prints a list sorted by component size, where each line of the list contains the size and the label of a component,
		for (int i = 0; i < sortedSets.length; i++)
			for (int j = 0; j < characters.length; j++)
				if (sortedSets[i] == characters[j]) {
					System.out.println((char) (j + 97) + "\t  \t"
							+ sortedSets[i]);
					characters[j] = -1;
					break;
				}
		System.out.println("\n(4)\n");

		// prints connected component image whose size equals to one or two removed
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img.length; j++) {
				z = imageSet.find_set(i * img.length + j + 1) + 96;
				if (z == 96 || sets[z - 97] == 1)
					System.out.print(' ');
				else
					System.out.print((char) z);
			}
			System.out.println();
		}
		System.out.println();
	}
}
