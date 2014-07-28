package initializer;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import framework.XmlParser;

public class ControllerInitializer {
	
	//파일명을 지정하는 부분까지 분리하고 싶은데 그렇게 하면 파일명을 지정하는 메소드는 어디서 호출해야 하는가?
	//근데 생각해보면 환경설정을 web.xml에서 하도록 정해져 있는 것처럼 그냥 여기 쓰는 파일도 Cmap.xml로 고정시켜버려도 될 것 같기도...
	public void init() {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			
//			URL location = ControllerInitializer.class.getProtectionDomain().getCodeSource().getLocation();
//			String path = location.getPath();
//			String filePath = path.substring( 0, path.lastIndexOf('/')+1);
			
//			File xmlFile = new File(filePath+"ControllerInfo.xml");
//			parser.parse(xmlFile, new XmlParser());
			
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("ControllerInfo.xml");
					
			parser.parse(is, new XmlParser());
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
