import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.naming.CommunicationException;

/*
 * Date:14-07-2017
 * Puprose:Read text file and print the portfolio in the descending order of their overall value
 * Developed By:J.Felixhansow
 */
public class PortfolioTracker {
	ArrayList<Integer> value = new ArrayList<Integer>();
	Map<Integer, String> shortform = new HashMap<Integer, String>();
	int countvalue = 0;
	String str = "";
	FileReader fr;
	BufferedReader br;

	private void trackPortfolio(String filePath) {
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			while (br.read() >= 0) {

				if (br.read() == 13 && br.read() == 10) {
					continue;
				}
				str = br.readLine();
				String[] s = str.split(",");

				String[] count;
				int i = 0;
				String sh = null;
				int h = 0;
				for (String t : s) {
					count = t.split("-");
					for (String coo : count) {
						++i;
						if (i == 1 && coo != null) {
							sh = coo;

						} else if (i == 2) {
							String c = coo;
							h = Integer.parseInt(c);
							countvalue += h;
							i = 0;
						}

					}

				}
				value.add(countvalue);
				shortform.put(countvalue, str);
				str = null;
				countvalue = 0;

			}

			Collections.sort(value, Collections.reverseOrder());

			for (int a : value) {
				System.out.println(shortform.get(a));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		PortfolioTracker pt = new PortfolioTracker();


	}

}
