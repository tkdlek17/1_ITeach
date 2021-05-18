package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class QuestionFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		long currentTimeMilis = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); // �и��ʷκ��� �ð� �������� ��ȯ�Ѵ�.
		int ranNum = (int)(Math.random() * 100000); // ������ ���ڸ� �����.
		
		// Ȯ���� ��������
		
		String name = originFile.getName(); // ���� ������ �̸��� �����.
		String ext = null; // Ȯ���ڸ� �����ϱ� ���� ������ �����Ѵ�.
		
		
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
