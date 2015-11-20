import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("* 数当てゲーム *");
		int ans = new java.util.Random().nextInt(100);
		int y;
		String user = null;
		boolean flg = true;

		while (flg) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("\n1～100までの数値を入れてね");
				user = br.readLine();
				if (isNumber(user)) {
					y = Integer.parseInt(user);
					if (ans == y) {
						System.out.println("正解");
						break;
					} else if (100 < y) {
						System.out.println("ふざけるな");
						continue;
					}  else if(0==y){
						System.out.println("(　´,_ゝ｀)ﾌﾟｯ");
						continue;
					}else if (ans > y) {
						System.out.println("もっと上");
						continue;
					}else {
						System.out.println("もっと下");
						continue;
					}
				} else {
					System.out.println("数値を入力して下さい");
					continue;
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n…ゲームを終了します…");

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
