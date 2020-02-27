package com.jiker.keju.taxi;

import org.junit.platform.commons.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReadFile {
    String dataInfo;

    public ReadFile(String fileName) throws IOException {
        dataInfo = "";
        String filePath = ReadFile.class.getClassLoader().getResource(fileName).getPath();//获取resource
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
            while (line != null){
                resolveDataInfo(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

    }
    private void resolveDataInfo(String line) {
        String[] lineElements = line.split(",");
        Pattern pattern = Pattern.compile("[^0-9]");
        String dataMiles = pattern.matcher(lineElements[0]).replaceAll("");
        String dataTime = pattern.matcher(lineElements[1]).replaceAll("");
        dataInfo = dataInfo + dataMiles + "&" + dataTime + ",";
    }

    public String getDataInfo(){
        return StringUtils.isBlank(this.dataInfo) ? null : this.dataInfo.substring(0,dataInfo.length()-1);
    }
}
