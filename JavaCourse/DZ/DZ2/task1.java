// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class task1 {

    public static String reader(String fpath) {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader reader = Files.newBufferedReader(Paths.get(fpath))) {
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line).append(System.lineSeparator());
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      String str = sb.toString();
      return str;
  
    }
  
    public static StringBuilder MakeInList(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        System.out.println(line3);
        StringBuilder result = new StringBuilder("select * from students where ");

        String [] arrayData = line3.split(", ");
        for (int i =0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if(!arrData[1].equals("null") ) {
                if (i != 0) {
                    result.append(" and ");
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                } else {
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                }
            }
            
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        
        String str  = reader("dataForSelect.txt");
        StringBuilder resultSelect = MakeInList(str);
        System.out.println(resultSelect);
        
      }
  }