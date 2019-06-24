package com.project.bangumi_community.test;

import org.junit.Test;

import com.youbenzi.mdtool.tool.MDTool;

public class TestMDTool {
	@Test
	public void fun1() {
		String html = MDTool.markdown2Html("## 关于收费\r\n" + 
				"\r\n" + 
				"**马克飞象**为新用户提供 10 天的试用期，试用期过后需要[续费](maxiang.info/vip.html)才能继续使用。未购买或者未及时续费，将不能同步新的笔记。之前保存过的笔记依然可以编辑。\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"## 反馈与建议\r\n" + 
				"- 微博：[@马克飞象](http://weibo.com/u/2788354117)，[@GGock](http://weibo.com/ggock \"开发者个人账号\")\r\n" + 
				"- 邮箱：<hustgock@gmail.com>\r\n" + 
				"");
		System.out.println(html);
	}
}
