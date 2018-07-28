package cn.kkl.mall.item.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.kkl.mall.item.pojo.Item;
import cn.kkl.mall.pojo.TbItem;
import cn.kkl.mall.pojo.TbItemDesc;
import cn.kkl.mall.service.ItemDescService;
import cn.kkl.mall.service.ItemService;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class HtmlGenListener implements MessageListener {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDescService itemDescService;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage=(TextMessage) message;
		Map map = new HashMap();
		Writer out=null;
		try {
			Long itemId=Long.parseLong(textMessage.getText());
			TbItem tbItem = itemService.getItemById(itemId);
			Item item = new Item(tbItem);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			TbItemDesc itemDesc = itemDescService.getItemDescById(itemId);
			map.put("item", item);
			map.put("itemDesc", itemDesc);
			
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			out=new FileWriter(HTML_GEN_PATH+itemId+".html");
			template.process(map, out);
			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally {
			try {
				if (out!=null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
