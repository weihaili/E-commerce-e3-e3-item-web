package cn.kkl.mail.testFreemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Admin
 * use freeMarker step:
 * 1. create template file
 * 2. create configuration instance
 * 3. set the save path of template file and set the encoding format of the template file ,generally utf-8
 * 4. load template file,create template instance
 * 5. create data set,it maybe map(recommended use) or pojo
 * 6. create a writer instance,designation save path and name of output file 
 * 7. generate static page
 * 9. close stream  
 */
public class Testfm {
	
	private Configuration configuration;
	private Template template;
	private Map<String, Object> data;

	@Before
	public void init() {
		configuration = new Configuration(Configuration.getVersion());
		try {
			configuration.setDirectoryForTemplateLoading(new File("D:\\E-commerce\\supermarket\\E3\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
			configuration.setDefaultEncoding("UTF-8");
			template = configuration.getTemplate("hello.ftl");
			data=new HashMap<>();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		data.put("hello", "hello freemarker!");
		Writer out=null;
		try {
			out = new FileWriter(new File("D:\\temp\\freemarker\\hello.txt"));
			template.process(data, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		try {
			if (out!=null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
