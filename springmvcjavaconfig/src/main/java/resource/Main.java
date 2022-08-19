package resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) throws IOException {
		// resource 패키지 : Main.java & db.properties 복사
		// classpath : 경로를 이쪽으로 사용하겠다
		Resource resource = (new FileSystemResourceLoader()).getResource("classpath:resource/db.properties");
		InputStream is = resource.getInputStream();
		
		int d;
		
		while((d=is.read())!=-1) {
			System.out.print((char)d);
		}
		
	}

}
