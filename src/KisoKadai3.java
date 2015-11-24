import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {
	public static void main(String args[]) throws IOException {

		boolean init = true;
		while (init) {
			// ファイルパスを指定する
			File file =null;
			// ディレクトリパスを取得する
			File dir=null;
			try{
				// メニュー
				// 1:読み書き用ファイルを指定する
				System.out.println("\n読み書きする為のファイルを指定してください。");
				System.out.println("例: C:\\Users\\internous\\test.txt\n");
				System.out.println("終了する場合には99を入力してください。");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String path = br.readLine();

				if (path.length() == 0) {
					System.err.println("何も入力されませんでした。\n再度入力してください。");
					continue;
				}

				if(path.equals("99")){
					System.out.println("処理を終了します。");
					System.exit(0);
				}

				// ファイルパスを指定する
				file = new File(path);
				// ディレクトリパスを取得する
				dir=new File(file.getParent());


				if(!(file.isFile())){
					System.err.println("ファイルが指定されていません");
				}
				if(!(file.isDirectory())){
					System.err.println("ディレクトリが指定されていません");
				}

				if(!dir.exists()){
					System.out.println("フォルダがありません。:"+file.getAbsolutePath());
					dir.mkdirs();
					System.out.println("作成成功");
				} else {
					System.out.println("フォルダは既に存在します。");
				}
			}catch(Exception e){
				System.err.println("入力に誤りがあります");
				continue;
			}
			if(file.exists()){
				System.out.println("ファイルは既に存在します。\n" + file.getAbsolutePath());
			}else{
				System.out.println("新しく作成します。\n"+file.getAbsolutePath());
				try{
					if (file.createNewFile()){
						System.out.println("作成しました"+file.getAbsolutePath());
					}else{
						System.out.println("作成失敗しました");
						System.out.println("再度指定してください");
					}
				}catch(IOException e){
					System.out.println(e);
				}
			}



			int end = 0;
			while(end==0){

				System.out.println("** メニュー **\n --1:書込み-- --2:読込み-- --0:終了-- ");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				String str = br2.readLine();
				int nu = 0;

				if(str.matches("^[0-9]+$")){
					nu=Integer.parseInt(str);
				}else{
					System.out.println("\n----------\n半角数値でメニューを選択してください。\n----------\n");
				}

				if(nu==0){
					System.out.println("終了します。");
					break;
				}

				if(nu==1){
					try {
						boolean mode = false;
						System.out.println("書き込み方法を指定してください。\n1:追記、2:上書き");
						BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
						String str2 = br3.readLine();
						// モードを決める
						switch (str2) {
						case "1":
							mode = true;
							break;
						case "2":
							mode = false;
						default:
							break;
						}
						System.out.println("書き込んでください");
						//出力先を作成する
						FileWriter fw = new FileWriter(file.getAbsolutePath(), mode);
						PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

						//内容を指定する
						BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
						String str3 = br4.readLine();
						pw.println(str3);

						//ファイルに書き出す
						pw.close();

						//終了メッセージを画面に出力する
						System.out.println("出力が完了しました。");

					} catch (IOException ex) {
						//例外時処理
						ex.printStackTrace();
					}

				}
				if(nu==2){
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
				}
			}
			System.out.println("--処理終了--");
		}


		}



	}
