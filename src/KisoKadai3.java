import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("--Hello--");

		int end = 0;
		while (end == 0) {

			System.out.println("** メニュー **\n --1:読み書き用ファイルを指定する --0:終了--");
			// フォルダ操作の場合
			// 1.フォルダ作成
			// 2.フォルダパスを表示する

			// 処理開始
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int n = 0;
			// エラー判定
			if (str.matches("^[0-1]+$")) {
				n = Integer.parseInt(str);
			} else {
				System.out.println("\n[1]か[0]でメニューを選択して下さい。\n");
				continue;
			}
			// 終了判定
			if (n == 0) {
				System.out.println("終了します");
				break;
			}

			boolean menu_flag = true;
			while (menu_flag) {
				// メニュー
				// 1:読み書き用ファイルを指定する
				System.out.println("\n読み書きする為のファイルを指定してください。");
				System.out.println("例: C:\\Users\\internous\\test.txt\n");
				System.out.println("終了する場合には99を入力してください。");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				String path = br2.readLine();
				if(path.equals("99")){
					System.out.println("終了します。");
					System.exit(0);
				}

				File directory=new File(path);
				if(!directory.isFile()){
					System.out.println("正しくありません。入力し直してください");
					continue;
				}

				if(!directory.isDirectory()){
					System.out.println("正しくありません");
					continue;
				}

				// ファイルパスを指定する
				File file = new File(path);
				// ディレクトリパスを取得する
				File dir = new File(file.getParent());

				if (!dir.exists()) {
					dir.mkdirs();
					System.out.println("指定されたフォルダを作成しました。");
				} else {
					System.out.println("指定されたフォルダは既に存在します。");
				}

				if (file.exists()) {
					System.out.println("指定されたファイルは既に存在します。\n" + file.getAbsolutePath());
				} else {
					System.out.println("ファイルは存在しません。\n新しく作成します。" + file.getAbsolutePath());
					try {
						if (file.createNewFile()) {
							System.out.println("作成しました");
						} else {
							System.out.println("作成失敗しました");
							System.out.println("再度指定してください");
							continue;
						}
					} catch (IOException e) {
						System.out.println(e);
					}
				}


				System.out.println("** メニュー **\n --1:書込み-- --2:読込み-- --9:終了-- ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String menu = br3.readLine();
				if (menu.equals("1")) {
					System.out.println("書込み処理を開始します");
					try {
						boolean mode = false;
						System.out.println("書き込み方法を指定してください。\n1:追記、2:上書き");
						BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
						String str4 = br4.readLine();

						// モードを決める
						switch (str4) {
						case "1":
							mode = true;
							break;
						case "2":
							mode = false;
						default:
							break;
						}
						//出力先を作成する
						FileWriter fw = new FileWriter(file.getAbsolutePath(), mode);
						PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
						System.out.println("書き込んでください");
						//内容を指定する
						BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
						String str5 = br5.readLine();
						pw.println(str5);

						//ファイルに書き出す
						pw.close();

						//終了メッセージを画面に出力する
						System.out.println("出力が完了しました。");

					} catch (IOException ex) {
						//例外時処理
						ex.printStackTrace();
					}

				}else if (menu.equals("2")) {
					System.out.println("読込み処理を開始します");
					try{
						FileReader filereader = new FileReader(file.getAbsolutePath());

						int ch;
						while((ch = filereader.read()) != -1){
							System.out.print((char)ch);
						}

						filereader.close();
					}catch(FileNotFoundException e){
						System.out.println(e);
					}catch(IOException e){
						System.out.println(e);
					}
				}else if (menu.equals("9")) {
					System.out.println("終了します。");
					System.exit(0);
				}else{
					System.out.println("入力間違いがあります。再起動します。");
					continue;
				}
			}
		}
	}
}

// ファイル読み取り

/*
 * BufferedReader br2= new BufferedReader(new
 * java.io.InputStreamReader(System.in)); String str2 = br.readLine();
 *
 * try{ FileReader fil=new FileReader(file.getAbsolutePath());
 *
 * int aa; while((aa=fil.read())!=-1){ System.err.println((char)aa); }
 *
 * fil.close(); }catch(FileNotFoundException e){ System.out.println(e);
 * }catch(IOException e){ System.out.println(e); }
 */