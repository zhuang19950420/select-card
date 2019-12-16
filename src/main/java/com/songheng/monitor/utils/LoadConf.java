package com.songheng.monitor.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadConf {
    private Properties prop = new Properties();

    private void loadconf() throws IOException {
        String path ="src\\main\\resources\\";
        path = path + "jiekou.properties";
        prop.load(new FileInputStream(path));

    }

    public LoadConf() throws IOException {
        loadconf();
    }

    public boolean chkProperty(String _key) {
        return prop.containsKey(_key);
    }

    public String getProperty(String _key) {
        return prop.getProperty(_key);
    }

	public static void main(String[] args) throws
			IOException {
        LoadConf mycnf = new LoadConf();
		System.out.println(mycnf.getProperty("testflag"));
	}
}