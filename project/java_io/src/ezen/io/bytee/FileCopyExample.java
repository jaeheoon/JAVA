package ezen.io.bytee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 입출력을 이용해 파일 복사 프로그램 응용
 * @author 홍재헌
 * 230525 수업
 */
public class FileCopyExample {
	
	public static long copy(String srcFile, String copyFile) throws IOException {
		long copyCount = 0;
		
		File file = new File(srcFile);											//파일이 있는지 없는지 유효성 검사
		if (!file.exists()) {
			throw new IOException("복사하고자 하는 파일을 찾을 수 없습니다.");	// 검사하고 이름 지정하여 반환하는 쪽에 예외처리 후 메세지 출력
		}
		
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(copyFile);
		
		byte[] buffer = new byte[1024];
		int count = 0;
		while((count = in.read(buffer)) != -1) {
			out.write(buffer, 0, count);
			copyCount += count;
		}
		return copyCount;
	}

	public static void main(String[] args){
		String srcFile = FileCopyExample.class.getResource("/assets/cosmo.jpg").getFile();
		String copyFile = FileCopyExample.class.getResource("/assets/").getFile() + "cosmo2.jpg";
		
//		long a = 0;
//		try {
//			a = copy(srcFile, copyFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		new Thread(new Runnable() {			//보통 파일복사는 쓰레드를 이용한다 ? 복사할때 다른 작업을 실행할 수 없기 때문에
			@Override
			public void run() {
				long a = 0;
				try {
					a = copy(srcFile, copyFile);
					System.out.println("파일 복사 완료, 복사된 파일의 크기는: " + a);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
		
	}

}
