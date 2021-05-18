package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class QuestionFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		long currentTimeMilis = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); // 밀리초로부터 시간 포맷으로 변환한다.
		int ranNum = (int)(Math.random() * 100000); // 임의의 숫자를 만든다.
		
		// 확장자 가져오기
		
		String name = originFile.getName(); // 원래 파일의 이름을 만든다.
		String ext = null; // 확장자를 저장하기 위한 변수를 선언한다.
		
		
		int dot = name.lastIndexOf("."); // 
		
		if(dot!= -1) {
			ext = name.substring(dot);
		} else {
			ext = "";
		}
		
		String fileName = sdf.format(new Date(currentTimeMilis)) + ranNum + ext;
		
		File newFile = new File(originFile.getParent(), fileName);
		
		
		return newFile;
	}
	

}
