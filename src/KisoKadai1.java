import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("☆1～100までの数字を入力してね☆");
		String str = null;
		String str2 = null;
		int x;
		int y;
		boolean flg = true;

		while (flg) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("xの値を入れてね");
				str = br.readLine();

				if (isNumber(str)) {
					x = Integer.parseInt(str);
					if (x >= 1 && x <= 100) {
						System.out.println("ｙの値を入れてね");
						break;
					} else {
						System.out.println("1～100までの数値を入れてね");
						continue;
					}
				} else {
					System.out.println("数値を入れてね");
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while (flg) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				str2 = br.readLine();

				if (isNumber(str2)) {
					y = Integer.parseInt(str2);
					if (y >=1 && y <= 100) {
						break;
					} else {
						System.out.println("入力値;1～100までの数値を入れてね");
						continue;
					}
				} else {
					System.out.println("入力値;数値を入れてね");
					continue;
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		x = Integer.parseInt(str);
		y = Integer.parseInt(str2);

		for (int i = 1; i <= x; i++) {
			System.out.println();

			for (int j = 1; j <= y; j++) {
				if (i * j < 10) {
					System.out.print("     ");
				} else if (i * j < 100) {
					System.out.print("    ");
				} else if (i * j < 1000) {
					System.out.print("   ");
				} else if (i * j == 10000) {
					System.out.print(" ");
				} else {
					System.out.print("  ");
				}

				System.out.print(" ");
				System.out.print(i * j);
			}

		}
	}

	public static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}

	}
}
