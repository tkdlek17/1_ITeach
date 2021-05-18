package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
	@Override
	public File rename(File originFile) {
		// 시간 + 랜덤 값 으로 파일명을 지정
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int ranNum = (int)(Math.random()*100000);
		
		// 확장자 가져오기
		String name = originFile.getName();
		String ext = null; // 확장자 명
		
		int dot = name.lastIndexOf("."); // 확장자가 없으면 -1반환
		if(dot != -1) {
			ext = name.substring(dot);
		}else {
			ext = "";
		}
		
		String fileName = sdf.format(new Date(currentTime)) + ranNum+ ext;
		//	  파일이름	 =	 현재시간   + 랜덤숫자  + 확장자
		File newFile = new File(originFile.getParent(), fileName);
							// 기존 파일을 가져온 경로, 새로운 파일명으로 바꿈
		
		return newFile;
	}
}