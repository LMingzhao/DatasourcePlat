/**   
 * 
 * @Title: GeneratorMapperStarter.java 
 * @Prject: spring-service
 * @Package: generator 
 * @author: Lmz
 * @date: 2017年12月7日 下午2:22:21 
 * @version: V1.0   
 */
package com.dsplat.utils;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.cglib.beans.BeanCopier.Generator;

/** 
 *
 * @ClassName: GeneratorMapperStarter 
 * @author: Lmz
 * @date: 2017年12月7日 下午2:22:21  
 */
public class GeneratorMapperStarter {

	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(
			        Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
