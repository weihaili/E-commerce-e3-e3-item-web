package cn.kkl.mail.testFreemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.kkl.mail.testFreemarker.pojo.Student;
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
			template = configuration.getTemplate("hello.ftl");
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
	
	@Test
	public void testPojo() {
		Student student = new Student("yaoming",18,001,'m',"yuhuatai"); 
		
		data.put("student", student);
		Writer out=null;
		try {
			template = configuration.getTemplate("student.ftl");
			out = new FileWriter(new File("D:\\temp\\freemarker\\student.html"));
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
	
	@Test
	public void testList() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("yaoming",18,001,'m',"yuhuatai"));
		students.add(new Student("tlp",108,444,'f',"yuhuatai"));
		students.add(new Student("telep",48,334,'f',"yuhuatai"));
		students.add(new Student("topop",38,381,'m',"yuhuatai"));
		students.add(new Student("taolap",14,141,'m',"yuhuatai"));
		students.add(new Student("tilip",58,331,'m',"yuhuatai"));
		
		data.put("students", students);
		Writer out=null;
		try {
			template = configuration.getTemplate("studentList.ftl");
			out = new FileWriter(new File("D:\\temp\\freemarker\\studentList.html"));
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
	
	@Test
	public void testListIndex() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("yaoming",18,001,'m',"yuhuatai"));
		students.add(new Student("tlp",108,444,'f',"yuhuatai"));
		students.add(new Student("telep",48,334,'f',"yuhuatai"));
		students.add(new Student("topop",38,381,'m',"yuhuatai"));
		students.add(new Student("taolap",14,141,'m',"yuhuatai"));
		students.add(new Student("tilip",58,331,'m',"yuhuatai"));
		
		data.put("students", students);
		Writer out=null;
		try {
			template = configuration.getTemplate("studentList_index.ftl");
			out = new FileWriter(new File("D:\\temp\\freemarker\\studentList_index-2.html"));
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
	
	@Test
	public void testDate() {
		data.put("date", new Date());
		Writer out=null;
		try {
			template = configuration.getTemplate("date.ftl");
			out = new FileWriter(new File("D:\\temp\\freemarker\\date.html"));
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
